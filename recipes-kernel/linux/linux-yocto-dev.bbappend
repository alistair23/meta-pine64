FILESEXTRAPATHS:prepend := "${THISDIR}/ep-files:"

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
	file://0010-PCI-dwc-Add-support-for-vendor-specific-capability-s.patch \
	file://0011-PCI-dwc-Add-debugfs-based-silicon-debug-support.patch \
	file://0012-PCI-dwc-Add-debugfs-based-error-injection-support.patch \
	file://0013-PCI-dwc-Add-debugfs-based-statistical-counter-suppor.patch \
	file://0014-PCI-dwc-Add-the-debugfs-property-to-provide-the-LTSS.patch \
	file://0015-PCI-dwc-Add-rockchip-to-the-allowed-vendor-list.patch \
	file://0016-arm64-dts-dw-rockchip-Disable-iommu-for-pcie3x4-RC-a.patch \
	file://0017-nvmet-pci-epf-Set-NVMET_PCI_EPF_Q_LIVE-when-a-queue-.patch \
	file://0018-nvmet-pci-epf-Do-not-add-an-IRQ-vector-if-not-needed.patch \
	file://0019-nvmet-pci-epf-Keep-completion-queues-mapped.patch \
"

# Support device tree overlays
KERNEL_DTC_FLAGS = "--symbols"
