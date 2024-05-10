package com.github.tooooowa.mcheads

import com.github.tooooowa.mcheads.Util.getCustomHead
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

object HeadCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        if (args[0].length > 16) {
            val head = getCustomHead(args[0])
            sender.inventory.addItem(head)
        } else {
            val player = Bukkit.getOfflinePlayer(args[0])
            val head = ItemStack(Material.PLAYER_HEAD)
            val headMeta = head.itemMeta as SkullMeta
            headMeta.owningPlayer = player
            head.itemMeta = headMeta
            sender.inventory.addItem(head)
        }
        return true
    }
}