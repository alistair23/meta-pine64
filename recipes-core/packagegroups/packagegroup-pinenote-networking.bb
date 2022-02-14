
DESCRIPTION = "PineNote Networking Package Group"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

# base Linux
RDEPENDS:${PN} = "\
    busybox \
    dnsmasq \
    dropbear \
    iw \
    openssl \
    networkmanager \
    networkmanager-nmcli \
    ntp \
    usbutils \
    wpa-supplicant \
    procps \
"

# dev
RDEPENDS:${PN}-dev = "\
    tcpdump \
"
