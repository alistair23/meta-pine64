#require recipes-core/images/core-image-minimal.bb
require recipes-core/images/core-image-minimal-dev.bb
require recipes-graphics/images/core-image-x11.bb

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
#    packagegroup-tools-bluetooth \
#

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

# graphics
IMAGE_INSTALL += " \
    libinput \
    xinput \
    xinput-calibrator \
    evtest \
"
#    vulkan-loader \
#    vulkan-tools \
#    vulkan-samples \
#

# multimedia audio
IMAGE_INSTALL += " \
    alsa-lib \
    alsa-plugins \
    alsa-tools \
    alsa-utils \
    flac \
    ffmpeg \
    liba52 \
    libogg \
    mpg123 \
    pulseaudio \
    pulseaudio-server \
    libpulse \
"
#    vlc \
#

# multimedia video
IMAGE_INSTALL += " \
    libpng \
    tiff \
"
