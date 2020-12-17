SOC_FAMILY = "h6"

require conf/machine/include/soc-family.inc

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
SPL_BINARY ?= "u-boot-sunxi-with-spl.bin"
UBOOT_ENTRYPOINT = "0x4fd00000"

TFA_PLATFORM = "sun50i_h6"
TFA_BUILD_TARGET = "bl31"
