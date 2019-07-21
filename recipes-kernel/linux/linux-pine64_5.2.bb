DESCRIPTION = "Pine64 Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.2"
LINUX_VERSION_EXTENSION = "-pine64"

BRANCH = "sunxi64-5.2"
SRCREV = "3c0ea3bedc07d93945ddc50e8bac7bdae30df08a"
SRC_URI = " \
           git://github.com/anarsoul/linux-2.6.git;branch=${BRANCH} \
           file://extra.cfg \
	  "

KBUILD_DEFCONFIG_sopine-a64 = "defconfig"
KBUILD_DEFCONFIG_pine-a64-lts = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "pine-a64-lts|sopine-a64"

