KCONFIG_MODE ?= "alldefconfig"
KBUILD_DEFCONFIG ?= "defconfig"

COMPATIBLE_MACHINE:append:pine-h64 = "|pine-h64"
COMPATIBLE_MACHINE:append:pine-rockpro64 = "|pine-rockpro64"
