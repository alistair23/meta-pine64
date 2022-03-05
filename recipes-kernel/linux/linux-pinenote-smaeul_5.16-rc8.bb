SUMMARY = "Linux kernel customized for the PineNote A55 by smaeul"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/smaeul/linux.git;branch=rk356x-ebc-dev;protocol=https;nocheckout=1;name=pinenote"

SRC_URI += " \
           file://defconfig \
           "

KCONFIG_MODE = "--alldefconfig"

KERNEL_DEVICETREE:pinenote-a55 += " rockchip/rk3566-pinenote.dtb"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION ?= "5.16-rc8"
LINUX_VERSION_EXTENSION:append:pinenote-a55 = "-pinenote"

SRCREV = "46e87f1f9c7dd22af26d99f60eb83d2cace43cb5"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE:append:pinenote-a55 = "|pinenote-a55"
