DESCRIPTION = "Pine64 Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.2"
LINUX_VERSION_EXTENSION = "-pine64"

BRANCH = "sunxi64-5.2"
SRCREV = "b82ed8944bb22eadb789e8b3b0f5935dacfc9dea"
SRC_URI = " \
           git://github.com/alistair23/linux.git;branch=${BRANCH} \
           file://extra.cfg \
	  "

KBUILD_DEFCONFIG_sopine-a64 = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "sopine-a64"

