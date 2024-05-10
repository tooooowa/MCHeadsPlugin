package com.github.tooooowa.mcheads

import org.bukkit.plugin.java.JavaPlugin

class MCHeads : JavaPlugin() {

    override fun onEnable() {
        getCommand("head")?.setExecutor(HeadCommand)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
