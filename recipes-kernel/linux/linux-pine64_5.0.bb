DESCRIPTION = "Pine64 Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.0"
LINUX_VERSION_EXTENSION = "-pine64"

BRANCH = "sunxi64-5.0"
SRCREV = "7e50bbc07bee10a663b08ab9e6e2083c2ddf2117"
SRC_URI = " \
          git://github.com/anarsoul/linux-2.6.git;branch=${BRANCH} \
          file://extra.cfg \
	  "

KBUILD_DEFCONFIG_sopine-a64 = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "sopine-a64"

