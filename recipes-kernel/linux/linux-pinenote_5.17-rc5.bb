SUMMARY = "Linux kernel customized for the PineNote A55 by Peter Geis (pgwipeout)"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://gitlab.com/pgwipeout/linux-next.git;branch=main;protocol=https;nocheckout=1;name=pinenote"

SRC_URI += " \
           file://defconfig \
           "

KCONFIG_MODE = "--alldefconfig"

KERNEL_DEVICETREE:pinenote-a55 += " rockchip/rk3566-pinenote.dtb"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION ?= "5.17-rc5"
LINUX_VERSION_EXTENSION:append:pinenote-a55 = "-pinenote"

SRCREV = "216057340a4d1e20e0a1ef9d5cba4b0f96296d27"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE:append:pinenote-a55 = "|pinenote-a55"
