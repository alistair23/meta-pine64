require conf/machine/include/arm/arch-arm64.inc
require conf/machine/include/rk3588.inc

EXTRA_IMAGEDEPENDS += "u-boot"
UBOOT_MACHINE ?= "rock5b-rk3588_defconfig"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto"
KCONFIG_MODE ?= "alldefconfig"
KBUILD_DEFCONFIG ?= "defconfig"
LINUX_VERSION_EXTENSION ?= "-rock5b"

KERNEL_IMAGETYPE = "Image"
KERNEL_DEVICETREE = " \
    rockchip/rk3588-rock-5b.dtb \
    rockchip/rk3588-rock-5b-pcie-ep.dtbo \
    rockchip/rk3588-rock-5b-pcie-srns.dtbo \
    "

MACHINE_EXTRA_RRECOMMENDS += "kernel-modules"

UBOOT_EXTLINUX = "1"
UBOOT_EXTLINUX_CONSOLE = "console=ttyS2,1500000"
UBOOT_EXTLINUX_ROOT = "root=/dev/mmcblk1p2"
UBOOT_EXTLINUX_FDT = "../rk3588-rock-5b.dtb"

IMAGE_FSTYPES += "wic"
WKS_FILE ?= "radxa-rock5b-bsp-image.wks"

WKS_FILE_DEPENDS ?= " \
    e2fsprogs-native \
    mtools-native \
    dosfstools-native \
    virtual/bootloader \
    virtual/kernel \
    "

SERIAL_CONSOLES = "1500000;ttyS2"
MACHINE_FEATURES = "alsa apm keyboard rtc serial usbgadget usbhost vfat ext2 ext3 wifi"
