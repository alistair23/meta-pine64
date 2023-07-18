FILESEXTRAPATHS:prepend := "${THISDIR}/ep-files:"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
KCONFIG_MODE ?= "alldefconfig"
KBUILD_DEFCONFIG ?= "defconfig"

COMPATIBLE_MACHINE:append:pine-h64 = "|pine-h64"
COMPATIBLE_MACHINE:append:pine-rockpro64 = "|pine-rockpro64"
COMPATIBLE_MACHINE:append:rk3588 = "|rk3588"

SRC_URI:append:rk3588 = " \
	file://rock5b-pcie-ep.cfg \
	file://0001-PCI-endpoint-Allow-EPF-drivers-to-configure-the-size.patch \
	file://0002-PCI-endpoint-Add-pci_epc_bar_size_to_rebar_cap.patch \
	file://0003-PCI-dwc-ep-Move-dw_pcie_ep_find_ext_capability.patch \
	file://0004-PCI-dwc-endpoint-Allow-EPF-drivers-to-configure-the-.patch \
	file://0005-PCI-keystone-Describe-Resizable-BARs-as-Resizable-BA.patch \
	file://0006-PCI-keystone-Specify-correct-alignment-requirement.patch \
	file://0007-PCI-dw-rockchip-Describe-Resizable-BARs-as-Resizable.patch \
	file://0008-PCI-dwc-ep-Add-dw_pcie_ep_hide_ext_capability.patch \
	file://0009-PCI-dw-rockchip-Hide-broken-ATS-capability.patch \
	file://0010-arm64-dts-dw-rockchip-Disable-iommu-for-pcie3x4-RC-a.patch \
	file://0011-nvmet-pci-epf-Keep-completion-queues-mapped.patch \
	file://0012-nvmet-pci-epf-Always-configure-BAR0-as-64-bit.patch \
	file://0013-arm64-dts-dw-rockchip-Limit-EP-to-single-lane.patch \
	file://0014-nvmet-pci-epf-Always-fully-initialize-completion-ent.patch \
	file://0015-nvmet-pci-epf-Clear-CC-and-CSTS-when-disabling-the-c.patch \
	file://0016-nvmet-pci-epf-Cleanup-link-state-management.patch \
"

# You can add this to the files to enable kernel debug options
# file://rock5b-debug.cfg

SRC_URI:append:qemux86-64 = " \
	file://nvme_tcp.cfg \
"

# Support device tree overlays
KERNEL_DTC_FLAGS = "--symbols"
