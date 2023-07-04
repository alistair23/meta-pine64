SOC_FAMILY = "rk3399"

require conf/machine/include/soc-family.inc

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
UBOOT_BINARY ?= "u-boot.itb"
SPL_BINARY ?= "idbloader.img"

TFA_PLATFORM = "rk3399"
TFA_BUILD_TARGET = "bl31"
