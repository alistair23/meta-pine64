DESCRIPTION = "Firmware files for RTL8723BS and RTL8723CS"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://README.md;md5=779f37dae32d47374b491836b4c5d94d"

COMPATIBLE_MACHINE = "sopine-a64"

inherit module

SRCREV = "cc77e7b6092c54500058cd027b679421b9399905"
SRC_URI = " \
    git://github.com/hadess/rtl8723bs.git;protocol=git;branch=master \
"

S = "${WORKDIR}/git"

do_configure() {
}

#do_compile() {
#}

do_install() {
    install -d ${D}/lib/firmware/rtlwifi/
    install -m 0644 ${S}/rtl8723bs_nic.bin ${D}/lib/firmware/rtlwifi/rtl8723bs_nic.bin
    install -m 0644 ${S}/rtl8723bs_wowlan.bin ${D}/lib/firmware/rtlwifi/rtl8723bs_wowlan.bin
}

FILES_${PN} = "/lib/firmware/rtlwifi"

