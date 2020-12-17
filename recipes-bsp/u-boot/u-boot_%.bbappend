FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_a64 = " \
    file://boot.txt \
    file://0001-sun6i-Increase-the-maximum-UART-baud-rate.patch \
    "

DEPENDS_append_a64 = " u-boot-tools-native"

ATF_DEPENDS ??= ""

EXTRA_OEMAKE_append_a64 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_a64.bin"
ATF_DEPENDS_a64 = " virtual/trusted-firmware-a:do_deploy"

EXTRA_OEMAKE_append_h6 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_h6.bin"
ATF_DEPENDS_h6 = " virtual/trusted-firmware-a:do_deploy"

do_compile[depends] .= "${ATF_DEPENDS}"

do_configure_prepend_a64() {
    mkimage -A arm -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/boot.txt ${WORKDIR}/boot.scr
}

FILES_${PN}_append_a64 = " /boot/boot.scr"
