package com.github.TheEvilDog.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import com.github.TheEvilDog.Main;

public class HurtListener implements Listener {
	
	private static Main plugin;
	private PotionEffectType effect;
	private int length, amplifier; 
	
	public HurtListener (Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents (this, plugin);
		effect= PotionEffectType.getByName (plugin.getConfig().getString("potion_effect"));
		length= plugin.getConfig().getInt("effect_length");
		amplifier= plugin.getConfig().getInt ("effect_amplifier");
	}
	
	@EventHandler
	public void onHurt (EntityDamageEvent hurt) {
		if (hurt.getEntity().getType() == EntityType.PLAYER) {
			Player p = (Player) hurt.getEntity(); 
			p.addPotionEffect(new PotionEffect (effect, length, amplifier));
		}
	}
}
