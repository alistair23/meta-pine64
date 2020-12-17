FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-sun6i-Increase-the-maximum-UART-baud-rate.patch \
	   "

DEPENDS += "arm-trusted-firmware u-boot-tools-native"

do_configure[depends] += "arm-trusted-firmware:do_deploy"

do_configure_prepend() {
    if [ ! -f ${B}/bl31.bin ]; then
        ln ${DEPLOY_DIR}/images/${MACHINE}/bl31-${MACHINE}.bin ${B}/bl31.bin
    fi
}
