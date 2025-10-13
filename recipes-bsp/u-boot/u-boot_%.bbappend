FILESEXTRAPATHS:prepend := "${THISDIR}/files:${THISDIR}/pt2-files:"

SRC_URI:append:a64 = " \
    file://boot.cmd \
    "

SRC_URI:append:pine-pinetab2 = " \
    file://disable_preconsole_buffer.cfg \
    "

DEPENDS:append:a64 = " u-boot-tools-native"
DEPENDS:append:rk3399 = " u-boot-tools-native python3-pyelftools-native"

ATF_DEPENDS ??= ""

EXTRA_OEMAKE:append:a64 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_a64.bin"
# We don't support the OpenRISC Crust firmware
# https://elixir.bootlin.com/u-boot/latest/source/board/sunxi/README.sunxi64#L64
EXTRA_OEMAKE:append:a64 = " SCP=/dev/null"
ATF_DEPENDS:a64 = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:h6 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_h6.bin"
# We don't support the OpenRISC Crust firmware
# https://elixir.bootlin.com/u-boot/latest/source/board/sunxi/README.sunxi64#L64
EXTRA_OEMAKE:append:h6 = " SCP=/dev/null"
ATF_DEPENDS:h6 = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:rk3399 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3399.elf"
ATF_DEPENDS:rk3399 = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:rk3588 = " \
	BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3588.elf \
	ROCKCHIP_TPL=${DEPLOY_DIR_IMAGE}/ddr-rk3588.bin \
	"
EXTRA_OEMAKE:append:rk3566 = " \
	BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3566.elf \
	ROCKCHIP_TPL=${DEPLOY_DIR_IMAGE}/ddr-rk3566.bin \
	"

ATF_DEPENDS:rk3588 = " rockchip-rkbin:do_deploy"
ATF_DEPENDS:rk3566 = " rockchip-rkbin:do_deploy"

do_compile[depends] .= "${ATF_DEPENDS}"

do_configure:prepend:a64() {
    mkimage -A arm -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/boot.cmd ${WORKDIR}/boot.scr
}

FILES_${PN}:append:a64 = " /boot/boot.scr"
