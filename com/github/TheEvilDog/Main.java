package com.github.TheEvilDog;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.TheEvilDog.listeners.HurtListener;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println ("NauseaOnHurt has enabled!");
		saveDefaultConfig();
		new HurtListener (this);
	}
}
