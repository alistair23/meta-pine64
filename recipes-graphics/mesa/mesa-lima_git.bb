require recipes-graphics/mesa/mesa.inc

BRANCH = "master"
SRCREV = "6ec9733b9f16e94dc3b3a0e6f9e88bced6955e86"
SRC_URI = "git://gitlab.freedesktop.org/mesa/mesa.git;branch=${BRANCH} \
"

S = "${WORKDIR}/git"

DEPENDS += "python3-native python3-mako python3-mako-native gettext-native libdrm"
DEPENDS += "${@bb.utils.contains('PACKAGECONFIG', 'x11', 'xrandr', '', d)}"

PACKAGECONFIG[lima] = ""
GALLIUMDRIVERS_append ="${@bb.utils.contains('PACKAGECONFIG', 'lima', ',lima', '', d)}"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}

