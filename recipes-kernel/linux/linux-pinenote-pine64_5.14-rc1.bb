SUMMARY = "Pine64 Linux kernel"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://gitlab.com/pine64-org/quartz-bsp/linux-next.git;branch=rk356x-ebc-dev;protocol=https;nocheckout=1;name=pinenote"

SRC_URI += " \
           file://defconfig \
           "

KCONFIG_MODE = "--alldefconfig"

# TODO: Patch the dts into the source tree
KERNEL_DEVICETREE_pinenote += " rk3566-pinenote.dtb"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION ?= "5.14-rc1"
LINUX_VERSION_EXTENSION:append = "-pinenote"

SRCREV = "5a514485388e3e428791ad8c454325814e11bb7b"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_pinenote-a55:append = "|pinenote-a55"
