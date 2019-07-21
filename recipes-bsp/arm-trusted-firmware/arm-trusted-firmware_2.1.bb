SUMMARY = "Arm Trusted Firmware (ATF)"
DESCRIPTION = "Trusted Firmware-A (TF-A) provides a reference implementation of secure world software for Armv7-A and Armv8-A, including a Secure Monitor executing at Exception Level 3 (EL3)."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = 'file://license.rst;md5=c709b197e22b81ede21109dbffd5f363'

inherit deploy

PROVIDES = "virtual/arm-trusted-firmware"

BRANCH = "master"
SRCREV ?= "ee80da114b9da8bd48e82ad0187c6534a2f11e71"
SRC_URI = "git://github.com/ARM-software/arm-trusted-firmware.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "pine-a64-lts|sopine-a64"
PLATFORM_pine-a64-lts = "sun50i_a64"
PLATFORM_sopine-a64 = "sun50i_a64"

# Let the Makefile handle setting up the CFLAGS and LDFLAGS as it is a standalone application
CFLAGS[unexport] = "1"
LDFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"

do_configure() {
	:
}

do_compile() {
	oe_runmake -C ${S} BUILD_BASE=${B} CROSS_COMPILE="${TARGET_PREFIX}" PLAT="${PLATFORM}" bl31
}

do_install() {
	:
}

do_deploy() {
	install -m 0644 ${S}/${PLATFORM}/release/bl31/bl31.elf ${DEPLOYDIR}/bl31-${MACHINE}.elf
	install -m 0644 ${S}/${PLATFORM}/release/bl31.bin ${DEPLOYDIR}/bl31-${MACHINE}.bin
}

addtask deploy before do_build after do_compile
