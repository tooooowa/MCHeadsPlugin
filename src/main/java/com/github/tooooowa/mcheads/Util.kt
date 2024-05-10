package com.github.tooooowa.mcheads

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.profile.PlayerProfile
import java.net.URL
import java.util.*

object Util {
    fun getCustomHead(mcUrl: String): ItemStack {
        val urlStr = "http://textures.minecraft.net/texture/${mcUrl}"
        val head = ItemStack(Material.PLAYER_HEAD)
        val skullMeta = head.itemMeta as SkullMeta
        val profile: PlayerProfile = Bukkit.createPlayerProfile(UUID.randomUUID())
        val url = URL(urlStr)
        val texture = profile.textures
        texture.skin = url
        profile.setTextures(texture);
        skullMeta.ownerProfile = profile
        head.setItemMeta(skullMeta);
        return head
    }
}