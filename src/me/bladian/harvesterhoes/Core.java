package me.bladian.harvesterhoes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Bladian. Before using the code, kindly ask permission to him via the following methods.
 * <p>
 * Twitter: BladianMC
 * Discord: Bladian#6411
 * <p>
 * Thank you for reading!
 */


public class Core extends JavaPlugin
{

    private Reference reference;

    public Reference getReference()
    {
        return reference;
    }

    @Override
    public void onDisable()
    {

    }

    @Override
    public void onEnable()
    {
        reference = new Reference();

        Configuration config = getConfig();
        reference.setMaterial(Material.valueOf(config.getString("item.material")));
        reference.setName(config.getString("item.name"));
        reference.setLore(config.getStringList("item.lore"));

        reference.setPermission(config.getString("permission"));

        getCommand("HarvesterHoe").setExecutor(new ComHarvesterHoe(this));
        getServer().getPluginManager().registerEvents(new Events(this), this);
    }
}
