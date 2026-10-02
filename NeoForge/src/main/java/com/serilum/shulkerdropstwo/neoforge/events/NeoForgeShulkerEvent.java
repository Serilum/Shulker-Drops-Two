package com.serilum.shulkerdropstwo.neoforge.events;

import com.serilum.shulkerdropstwo.events.ShulkerEvent;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.bus.api.SubscribeEvent;

public class NeoForgeShulkerEvent {
	@SubscribeEvent
	public static void mobItemDrop(LivingDropsEvent e) {
		Entity entity = e.getEntity();
		ShulkerEvent.mobItemDrop(entity.level(), entity, null);
	}
}
