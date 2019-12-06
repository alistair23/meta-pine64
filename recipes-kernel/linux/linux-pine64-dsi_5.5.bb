DESCRIPTION = "Pine64 Linux Kernel with touchscreen support"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.5"
LINUX_VERSION_EXTENSION = "-pine64-dsi"

PV = "${LINUX_VERSION}+git${SRCPV}"

BRANCH = "alistair/sunxi64-5.5-dsi"
SRCREV = "4af29cf02054b656119c53b2eec5c9996d4521b6"
SRC_URI = "git://github.com/alistair23/linux.git;branch=${BRANCH} \
           file://extra.cfg \
           file://screen.cfg \
	  "

KBUILD_DEFCONFIG_sopine-a64 = "defconfig"
KBUILD_DEFCONFIG_pine-a64-lts = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "pine-a64-lts|sopine-a64"

