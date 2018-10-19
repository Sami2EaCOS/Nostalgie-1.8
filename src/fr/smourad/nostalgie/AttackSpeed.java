package fr.smourad.nostalgie;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AttackSpeed implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(1000);
		}
	}
	
}
