SOC_FAMILY = "a64"

require conf/machine/include/soc-family.inc

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
UBOOT_BINARY ?= "u-boot-sunxi-with-spl.bin"
SPL_BINARY ?= "spl/sunxi-spl.bin"
UBOOT_ENTRYPOINT = "0x40080000"
UBOOT_DTB_LOADADDRESS = "0x4FA00000"
UBOOT_ENV ?= "boot"
UBOOT_ENV_SUFFIX ?= "scr"
