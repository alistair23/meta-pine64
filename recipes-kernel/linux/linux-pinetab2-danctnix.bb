DESCRIPTION = "Linux kernel fork with built-in wifi and USB support for PineTab2"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel 
require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/pt2-files:"

SRC_URI = "git://codeberg.org/DanctNIX/linux-pinetab2.git;protocol=https;nobranch=1 \
           file://disable_drm_msm.cfg \
           file://screen.cfg \
           file://usb.cfg \
           file://rockchip.cfg \
          "

LINUX_VERSION ?= "6.16.9"
DANCTNIX_VERSION ?= "1"
SRCREV = "v${LINUX_VERSION}-danctnix${DANCTNIX_VERSION}"
PV = "${LINUX_VERSION}-danctnix${DANCTNIX_VERSION}"

COMPATIBLE_MACHINE = "pine-pinetab2"

KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"
