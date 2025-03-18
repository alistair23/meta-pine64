SOC_FAMILY = "rk3588"

require conf/machine/include/soc-family.inc

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
UBOOT_BINARY ?= "u-boot.itb"
SPL_BINARY ?= "idbloader.img"

TFA_PLATFORM = "rk3588"
TFA_BUILD_TARGET = "bl31"
