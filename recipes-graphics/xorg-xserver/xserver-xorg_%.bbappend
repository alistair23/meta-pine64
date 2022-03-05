
FILESEXTRAPATHS:prepend:pinenote-a55 := "${THISDIR}/files:"

SRC_URI:append:pinenote-a55 = " \
	file://50-touchscreen.conf \
"

do_install:append:pinenote-a55() {
	install -d ${D}${datadir}/X11/xorg.conf.d
	install -m 0644 ${WORKDIR}/50-touchscreen.conf ${D}${datadir}/X11/xorg.conf.d/
}

FILES_${PN}:append:pinenote-a55 = " \
	${datadir}/X11/xorg.conf.d/50-touchscreen.conf \
"
