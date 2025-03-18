DESCRIPTION = "Rockchip Firmware and Tool Binaries"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=11e3673115959bf596feaaa6ea7ce9a5"

SRC_URI = "git://github.com/rockchip-linux/rkbin;protocol=https;branch=master"
SRCREV = "f43a462e7a1429a9d407ae52b4745033034a6cf9"

PROVIDES += "trusted-firmware-a"
PROVIDES += "optee-os"

inherit bin_package deploy

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:rk3588 = "rk3588"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	# Nothing in this recipe is useful in a filesystem
	:
}

PACKAGES = "${PN}"
ALLOW_EMPTY:${PN} = "1"

do_deploy() {
	# Prebuilt TF-A
	install -m 644 ${S}/bin/rk35/rk3588_bl31_v*.elf ${DEPLOYDIR}/bl31-rk3588.elf
	# Prebuilt OPTEE-OS
	install -m 644 ${S}/bin/rk35/rk3588_bl32_v*.bin ${DEPLOYDIR}/tee-rk3588.bin
	# Prebuilt U-Boot TPL (DDR init)
	install -m 644 ${S}/bin/rk35/rk3588_ddr_lp4_2112MHz_lp5_2400MHz_v*.bin ${DEPLOYDIR}/ddr-rk3588.bin
}

addtask deploy after do_install
