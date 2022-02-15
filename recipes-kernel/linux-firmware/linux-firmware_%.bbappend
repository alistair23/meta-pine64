# Released under the MIT license (see COPYING.MIT for the terms)

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
	file://pinenote-a55-firmware-broadcom/ \
"

# NOTE: This has the effect of pruning all of the unnecessary firmware binaries
#PACKAGES =+ " \
#
PACKAGES:pinenote-a55 = " \
        ${PN}-bcm43455 \
        ${PN}-broadcom-license \
"

# Only install the firmware that we need
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

	# install additional files
        cp -r ${WORKDIR}/pinenote-a55-firmware-broadcom/* ${D}${nonarch_base_libdir}/firmware/brcm/
	ln -sf fw_bcm43455c0_ag_cy.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.bin
	ln -sf nvram_ap6255_cy.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.txt
	ln -sf fw_bcm43455c0_ag_cy.bin ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.pine64,pinenote.bin
	ln -sf nvram_ap6255_cy.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43455-sdio.pine64,pinenote.txt        
}

FILES_${PN}-bcm43455 += " \
        ${nonarch_base_libdir}/firmware/brcm/* \
"
