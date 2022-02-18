# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
	file://pinenote-a55-firmware/broadcom/ \
	file://pinenote-a55-firmware/rockchip-ebc/ \
"

# NOTE: This has the effect of pruning all of the unnecessary firmware binaries
#PACKAGES =+ " \
#
PACKAGES:pinenote-a55 = " \
        ${PN}-bcm43455 \
        ${PN}-broadcom-license \
        ${PN}-rockchip-ebc \
"

# Remove all extra firmware files and only install the ones that we need
do_install:append:pinenote-a55() {
        # temporarily move the files that we need
        install -d ${D}${nonarch_base_libdir}/firmware-tmp
        install -d ${D}${nonarch_base_libdir}/firmware-tmp/brcm
        install -d ${D}${nonarch_base_libdir}/firmware-tmp/cypress
        mv ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.* ${D}${nonarch_base_libdir}/firmware-tmp/brcm/
        mv ${D}${nonarch_base_libdir}/firmware/cypress/cyfmac43455-sdio.* ${D}${nonarch_base_libdir}/firmware-tmp/cypress/
        mv ${D}${nonarch_base_libdir}/firmware/LICENCE.broadcom_bcm43xx ${D}${nonarch_base_libdir}/firmware-tmp/LICENCE.broadcom_bcm43xx

	# delete all pre-existing firmware files!
	rm -rf ${D}${nonarch_base_libdir}/firmware

	# replace the files
        mv ${D}${nonarch_base_libdir}/firmware-tmp ${D}${nonarch_base_libdir}/firmware
}

# Install additional broadcom files
do_install:append:pinenote-a55() {
        cp -r ${WORKDIR}/pinenote-a55-firmware/broadcom/* ${D}${nonarch_base_libdir}/firmware/brcm/
	ln -sf fw_bcm43455c0_ag_cy.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.bin
	ln -sf nvram_ap6255_cy.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.txt
	ln -sf fw_bcm43455c0_ag_cy.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.pine64,pinenote.bin
	ln -sf nvram_ap6255_cy.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.pine64,pinenote.txt        

	# TODO: fix this instead of disabling it?
	mv ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.clm_blob ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.clm_blob.DISABLED
}

FILES_${PN}-bcm43455 += " \
        ${nonarch_base_libdir}/firmware/brcm/* \
"

# TODO: Figure out waveform.bin license
# Install Rockchip EBC files
do_install:append:pinenote-a55() {
	# Rockchip EBC waveform
        install -m 0644 ${WORKDIR}/pinenote-a55-firmware/rockchip-ebc/waveform.bin ${D}${nonarch_base_libdir}/firmware/
}

FILES_${PN}-rockchip-ebc = " \
        ${nonarch_base_libdir}/firmware/waveform.bin \
"
