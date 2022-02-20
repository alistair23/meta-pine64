
NETWORK_MANAGER:pinenote-a55 = "networkmanager"

# PineNote is using NetworkManager, which conflicts with connman that is used by sato
#RDEPENDS_${PN}-base:remove:pinenote-a55 += "connman-gnome connman"
#RDEPENDS_${PN}-base:remove:pinenote-a55 += "${NETWORK_MANAGER}"
