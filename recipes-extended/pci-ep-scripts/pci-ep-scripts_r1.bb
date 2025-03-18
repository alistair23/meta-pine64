SUMMARY = "PCIe Endpoint Scripts"
DESCRIPTION = "PCIe Endpoint Scripts"
HOMEPAGE = "https://github.com/damien-lemoal/buildroot/tree/rock5b_ep_v31/board/radxa/rock5b-ep/overlay/root/pci-ep"
LICENSE = "GPL-2.0-or-later"

RDEPENDS:${PN} = " \
    bash \
    pciutils \
    fio \
    "

do_install() {
    install -d ${D}${bindir}/
    cp ${FILE_DIRNAME}/${BPN}/* ${D}${bindir}/
}

FILES:${PN} += "${bindir}/epf-remove.sh"
FILES:${PN} += "${bindir}/epf-reset.sh"
FILES:${PN} += "${bindir}/epf-unbind.sh"
FILES:${PN} += "${bindir}/fio-test.sh"
FILES:${PN} += "${bindir}/nvmet-pci-epf"
FILES:${PN} += "${bindir}/pci-rescan.sh"
