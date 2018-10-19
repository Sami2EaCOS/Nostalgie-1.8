package fr.smourad.nostalgie;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static int task;
	public static int gamerule;
	
	@Override
    public void onEnable() {		
		loadRegen(); 
		
		this.getServer().getPluginManager().registerEvents(new AttackSpeed(), this);
		
		
		gamerule = Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			
			@Override
			public void run() {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gamerule naturalRegeneration false");
			}
		}, 20);		
    }
    
    @Override
    public void onDisable() {
        
    }
    
    public void loadRegen() {
    	task = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!(p.getHealth() == p.getHealthScale())) {
                        p.setHealth(p.getHealth()+1);
                    }
                }
            }
        }, 20*4, 20*4);
    }
}
