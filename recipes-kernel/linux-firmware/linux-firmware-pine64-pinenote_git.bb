SUMMARY = "Pine64 PineNote A55 Firmware"
HOMEPAGE = "https://gitlab.com/calebccff/firmware-pine64-pinenote"
DESCRIPTION = "Pine64 PineNote A55 Firmware"
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://LICENSE;md5="

SRCREV = "6676e4cabf5f68062da86ef528ac033507f02529"
PV = "0.1+git${SRCPV}"

SRC_URI = "git://gitlab.com/calebccff/firmware-pine64-pinenote.git;protocol=https;branch=main"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "pinenote-a55"

do_install(){
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 644 ${B}/waveform.bin ${D}${nonarch_base_libdir}/firmware/

    install -d ${D}${nonarch_base_libdir}/firmware/brcm
    cp -r ${B}/brcm/* ${D}${nonarch_base_libdir}/firmware/brcm/
    ln -sf fw_bcm43455c0_ag_cy.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.bin
    ln -sf nvram_ap6255_cy.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.txt
    ln -sf fw_bcm43455c0_ag_cy.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.pine64,pinenote.bin
    ln -sf nvram_ap6255_cy.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.pine64,pinenote.txt        

    # TODO: fix this instead of disabling it?
    #mv ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.clm_blob ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.clm_blob.DISABLED
}

FILES_${PN} += " \
    ${base_libdir}/firmware/waveform.bin \
    ${base_libdir}/firmware/brcm/* \
"
