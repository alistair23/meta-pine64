SUMMARY = "RockPro64 PCIe Endpoint Helper Scripts"
HOMEPAGE = "https://github.com/damien-lemoal/buildroot/tree/rockpro64_ep_v23/board/pine64/rockpro64_ep"
LICENSE = "GPL-2.0-only"

do_install() {
    install -d ${D}${bindir}/
    install -m 755 ${FILE_DIRNAME}/files/nvme-epf-setup.sh ${D}${bindir}/
    install -m 755 ${FILE_DIRNAME}/files/test-epf-setup.sh ${D}${bindir}/
}

FILES_${PN} += "${bindir}/nvme-epf-setup.sh"
FILES_${PN} += "${bindir}/test-epf-setup.sh"
