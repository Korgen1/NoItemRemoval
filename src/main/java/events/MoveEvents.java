package events;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import xyz.korgen.noitemremoval.NoItemRemoval;

public class MoveEvents implements Listener {
    @EventHandler
    public void OnItemDrop(PlayerDropItemEvent event){
        FileConfiguration config = NoItemRemoval.plugin.getConfig();
        Player p = event.getPlayer();
        if (!p.hasPermission("NoItemRemoval.Bypass")) {
            for (String item : config.getStringList("whitelist")) {
                if (event.getItemDrop().getItemStack().getType() == Material.matchMaterial(item)) {
                    return;
                }
            }
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void OnItemMove(InventoryClickEvent event){
        FileConfiguration config = NoItemRemoval.plugin.getConfig();
        HumanEntity p = event.getWhoClicked();
        if (!p.hasPermission("NoItemRemoval.Bypass")) {
            if (event.getClickedInventory().getType() != InventoryType.PLAYER) {
                for (String item : config.getStringList("whitelist")) {
                    if (event.getCurrentItem().getType() == Material.matchMaterial(item) ^ event.getCursor().getType() == Material.matchMaterial(item)) {
                        return;
                    }
                }
                event.setCancelled(true);
            }
            if (event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                for (String item : config.getStringList("whitelist")) {
                    if (event.getCurrentItem().getType() == Material.matchMaterial(item)) {
                        return;
                    }
                }
                event.setCancelled(true);
            }
        }
    }
}

