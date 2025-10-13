SUMMARY = "BES2600 Wi-Fi/BT module firmware files for use with Linux kernel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d5bc05fb40113dd55f55169a4f7b6f02"

SRC_URI = "git://gitlab.com/pine64-org/bes2600-firmware.git;branch=main;protocol=https"

PV = "bes2600_firmware+git"
SRCREV = "cd21914580fcfd5ca6eef0872de0fd2b28d81d41"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE="pine-pinetab2"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    cp -r ${S}/firmware/* ${D}${nonarch_base_libdir}/firmware/
    install -m 0644 ${S}/LICENSE ${D}${nonarch_base_libdir}/firmware/LICENSE.bes2600
}

FILES:${PN} = "${nonarch_base_libdir}/firmware"
