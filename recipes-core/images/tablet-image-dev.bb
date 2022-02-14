#require recipes-core/images/core-image-minimal.bb
require recipes-core/images/core-image-minimal-dev.bb

DESCRIPTION = "An e-reader tablet image suitable for development work."

IMAGE_FEATURES += "dev-pkgs"

#EXTRA_IMAGE_FEATURES += " allow-empty-password empty-root-password"
EXTRA_IMAGE_FEATURES += " debug-tweaks"

inherit extrausers
EXTRA_USERS_PARAMS = "\
    usermod -P '' root; \
"

# core
IMAGE_INSTALL += " \
    coreutils \
"

# networking
IMAGE_INSTALL += " \
    packagegroup-pinenote-networking \
"

# connectivity
IMAGE_INSTALL += " \
    bluez5 \
"

# devtools
IMAGE_INSTALL += " \
    python3 \
    python3-pip \
"

# extended
IMAGE_INSTALL += " \
    diffutils \
    iputils \
    screen \
"

# support
IMAGE_INSTALL += " \
    vim \
    nano \
    tree \
"
