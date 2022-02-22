SUMMARY = "Linux kernel customized for the PineNote A55 by Peter Geis (pgwipeout)"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://gitlab.com/pgwipeout/linux-next.git;branch=main;protocol=https;nocheckout=1;name=pinenote"

SRC_URI += " \
           file://defconfig \
           "

KCONFIG_MODE = "--alldefconfig"

KERNEL_DEVICETREE_pinenote-a55 += " rockchip/rk3566-pinenote.dtb"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION ?= "5.17-rc3"
LINUX_VERSION_EXTENSION:append = "-pinenote"

SRCREV_pinenote-a55="eef94440e1ebae6426a07379e4ea149c2c601183"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_pinenote-a55:append = "|pinenote-a55"
