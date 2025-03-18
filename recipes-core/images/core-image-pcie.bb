SUMMARY = "A console-only image that supports a PCIe endpoint."

LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL += " spdm-utils pci-ep-scripts"

PREFERRED_PROVIDER_virtual/kernel = "linux-yocto-dev"

inherit core-image
