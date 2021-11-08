DESCRIPTION = "Mainline Linux kernel with touchscreen support for Pine64"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.10"
LINUX_VERSION_EXTENSION = "-mainline"
KERNEL_VERSION_SANITY_SKIP="1"

BRANCH = "linux-5.10.y"
SRCREV = "${AUTOREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;branch=${BRANCH} \
           file://0001-arm64-allwinner-Add-HDMI-sound-for-sopine-baseboard.patch \
           file://0002-arm64-allwinner-sopine-baseboard-Enable-Bluetooth-an.patch \
           file://0003-arm64-allwinner-pine64-Enable-Bluetooth-and-WiFi.patch \
           file://0004-arm64-allwinner-sopine-baseboard-Enable-FeiyangFY070.patch \
           file://0005-arm64-allwinner-sopine-baseboard-Enable-I2C-touchscr.patch \
           file://0006-drivers-sunxi-mmc-Don-t-specify-PROBE_PREFER_ASYNCHR.patch \
           file://extra.cfg \
           file://screen.cfg \
           file://battery.cfg \
	  "

KBUILD_DEFCONFIG_sopine-a64 = "defconfig"
KBUILD_DEFCONFIG_pine-a64-lts = "defconfig"
KBUILD_DEFCONFIG_pine-a64-plus = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "pine-a64-lts|sopine-a64|pine-a64-plus"

# This is necessary since kmeta would be necessary otherwise
KERNEL_FEATURES_remove = "cfg/fs/vfat.scc"
