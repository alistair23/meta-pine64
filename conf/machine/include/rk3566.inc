SOC_FAMILY = "rk3566"

require conf/machine/include/soc-family.inc

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
UBOOT_BINARY ?= "u-boot-rockchip.bin"
SPL_BINARY ?= ""

TFA_PLATFORM = "rk3566"
TFA_BUILD_TARGET = "bl31"
