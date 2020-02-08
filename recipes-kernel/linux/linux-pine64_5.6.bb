DESCRIPTION = "Pine64 Linux Kernel with touchscreen support"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.6"
LINUX_VERSION_EXTENSION = "-pine64"
KERNEL_VERSION_SANITY_SKIP="1"

PV = "${LINUX_VERSION}+git${SRCPV}"

BRANCH = "alistair/sunxi64-5.6-dsi"
SRCREV = "86762509858c418194fadf08f00506b5f8c1038d"
SRC_URI = "git://github.com/alistair23/linux.git;branch=${BRANCH} \
           file://extra.cfg \
           file://screen.cfg \
	  "

KBUILD_DEFCONFIG_sopine-a64 = "defconfig"
KBUILD_DEFCONFIG_pine-a64-lts = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "pine-a64-lts|sopine-a64"

