DESCRIPTION = "Pine64 Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.3.0"
LINUX_VERSION_EXTENSION = "-pine64"

PV = "${LINUX_VERSION}+git${SRCPV}"

BRANCH = "pine64-kernel"
SRCREV = "6ecddfc2164e0927e75c232d515225c6b21c71b4"
SRC_URI = " \
           git://gitlab.com/pine64-org/linux.git;branch=${BRANCH} \
           file://0001-net-stmmac-dwmac-sun8i-support-RGMII-modes-with-PHY-.patch \
           file://0002-arm64-allwinner-a64-disable-the-RTL8211E-internal-RX.patch \
           file://0003-Add-sopine-HDMI-sound-and-WiFi-support.patch \
           file://0004-sopine-baseboard-enable-HS200-for-eMMC.patch \
           file://0005-drm-bridge-Add-audio-workaround-for-dw_hdmi-v1.32a.patch \
           file://0006-rtl8723bs-disable-error-message-about-failure-to-all.patch \
           file://0007-arm64-allwinner-a64-enable-Bluetooth-On-Pine64.patch \
           file://0008-arm64-allwinner-a64-enable-Bluetooth-On-SoPine-baseb.patch \
           file://extra.cfg \
	  "

KBUILD_DEFCONFIG_sopine-a64 = "defconfig"
KBUILD_DEFCONFIG_pine-a64-lts = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "pine-a64-lts|sopine-a64"

