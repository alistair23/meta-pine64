FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://${MACHINE}.txt \
	   "

DEPENDS += "arm-trusted-firmware u-boot-tools-native"

do_configure[depends] += "arm-trusted-firmware:do_deploy"

do_configure_prepend() {
    if [ ! -f ${B}/bl31.bin ]; then
        ln ${DEPLOY_DIR}/images/${MACHINE}/bl31-${MACHINE}.bin ${B}/bl31.bin
    fi

    mkimage -A arm -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/${MACHINE}.txt ${WORKDIR}/boot.scr
}

FILES_${PN} += "/boot/boot.scr"
