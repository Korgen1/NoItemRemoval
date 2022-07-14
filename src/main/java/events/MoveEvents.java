package events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;

public class MoveEvents implements Listener {

    @EventHandler
    public void OnItemDrop(PlayerDropItemEvent event){
        event.setCancelled(true);
    }
    @EventHandler
    public void OnItemMove(InventoryClickEvent event){
        if (event.getClickedInventory().getType() != InventoryType.PLAYER){
            event.setCancelled(true);
        }
        if(event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
            event.setCancelled(true);
        }
    }
}
