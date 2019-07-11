DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.2"

BRANCH = "linux-5.2.y"
SRCREV = "${AUTOREV}"
SRC_URI = " \
           git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;branch=${BRANCH} \
           file://0001-dts-sun50i-a64-sopine-Enable-WiFi-and-Bluetooth.patch \
           file://extra.cfg \
	  "

KBUILD_DEFCONFIG_sopine-a64 = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "sopine-a64"

