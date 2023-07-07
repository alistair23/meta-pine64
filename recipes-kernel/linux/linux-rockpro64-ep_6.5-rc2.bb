DESCRIPTION = "Mainline Linux kernel with PCIe End Point support for RockPro64"
SECTION = "kernel"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "6.5-rc2"
LINUX_VERSION_EXTENSION = "-rockpro64-ep"

BRANCH = "rockpro64_ep_v25"
SRCREV = "988e28cbb080750ebb1f0bdd7c26e88529a6d2bd"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI = "git://github.com/damien-lemoal/linux.git;protocol=https;branch=${BRANCH} \
           file://defconfig \
	  "

KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "pine-rockpro64"

# This is necessary since kmeta would be necessary otherwise
KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"
