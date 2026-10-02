package com.serilum.shulkerdropstwo.forge.events;

import com.serilum.shulkerdropstwo.events.ShulkerEvent;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeShulkerEvent {
	@SubscribeEvent
	public static void mobItemDrop(LivingDropsEvent e) {
		Entity entity = e.getEntity();
		ShulkerEvent.mobItemDrop(entity.level(), entity, null);
	}
}
