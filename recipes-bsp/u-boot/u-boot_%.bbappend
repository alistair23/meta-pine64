FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:a64 = " \
    file://boot.cmd \
    file://0001-sun6i-Increase-the-maximum-UART-baud-rate.patch \
    "

DEPENDS:append:a64 = " u-boot-tools-native"

ATF_DEPENDS ??= ""

EXTRA_OEMAKE:append:a64 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_a64.bin"
ATF_DEPENDS:a64 = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:h6 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_h6.bin"
ATF_DEPENDS:h6 = " trusted-firmware-a:do_deploy"

do_compile[depends] .= "${ATF_DEPENDS}"

do_configure:prepend:a64() {
    mkimage -A arm -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/boot.cmd ${WORKDIR}/boot.scr
}

FILES_${PN}:append:a64 = " /boot/boot.scr"
