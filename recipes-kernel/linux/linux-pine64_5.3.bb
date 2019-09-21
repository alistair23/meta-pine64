DESCRIPTION = "Pine64 Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.3.0"
LINUX_VERSION_EXTENSION = "-pine64"

PV = "${LINUX_VERSION}+git${SRCPV}"

BRANCH = "sunxi64-5.3"
SRCREV = "c1533c70af80ea1cb25348e4931455e932f26af1"
SRC_URI = " \
           git://github.com/anarsoul/linux-2.6.git;branch=${BRANCH} \
           file://extra.cfg \
	  "

KBUILD_DEFCONFIG_sopine-a64 = "defconfig"
KBUILD_DEFCONFIG_pine-a64-lts = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "pine-a64-lts|sopine-a64"

