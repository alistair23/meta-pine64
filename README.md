# meta-pine64

Pine64 Layer for OpenEmbedded/Yocto

## Description

This is the general hardware specific BSP overlay for the Pine64 devices.

This layer aims to support as many features as possible on Pine64 devices.
Where possible the layer aims to use opensource and upstream projects
avoiding custom forks and binary solutions.

## Dependencies

This layer depends on:

* URI: git://github.com/openembedded/openembedded-core
  * branch: master
  * revision: HEAD
* URI: git://github.com/openembedded/bitbake
  * branch: master
  * revision: HEAD

## Building

Follow the usual steps to setup OpenEmbedded and bitbake.

### SoPine

```
MACHINE=sopine-a64 bitbake core-image-base
```

### Using systemd instead of SysVinit

To use systemd add this to your local.conf:

```
DISTRO_FEATURES += "systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
```
### Connecting to WiFi

To use WiFi add this to your local.conf:

```
DISTRO_FEATURES += "ipv4 ipv6 wifi"
IMAGE_INSTALL_append = "linux-firmware-rtl8723bs"
IMAGE_INSTALL_append = " dhcp-client"
```

### Displaying the kernel boot log on HDMI

To see the kernel boot log on the HDMI output, which is useful for debugging, change `recipes-bsp/u-boot/files/boot.txt` to the following:

```
setenv bootargs console=tty0 console=ttyS0,115200 root=/dev/mmcblk0p2 rootwait
```

This results in adding `console=tty0` which will direct Linux to display the console on the display.

### Graphical display

To use Wayland graphics add this to your local.conf:

```
DISTRO_FEATURES += "wayland opengl"
PACKAGECONFIG_append_pn-virtual/mesa = "gallium sun4i"
```

Then build Weston using:

```MACHINE=sopine-a64 bitbake core-image-weston
```

To use X11 as well add this to your local.conf as well:

```
DISTRO_FEATURES += "x11"
```
Then build X11 using:

```
MACHINE=sopine-a64 bitbake core-image-x11
```
