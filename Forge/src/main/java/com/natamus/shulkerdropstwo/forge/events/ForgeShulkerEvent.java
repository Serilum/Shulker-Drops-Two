package com.natamus.shulkerdropstwo.forge.events;

import com.natamus.shulkerdropstwo.events.ShulkerEvent;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeShulkerEvent {
	@SubscribeEvent
	public void mobItemDrop(LivingDropsEvent e) {
		Entity entity = e.getEntity();
		ShulkerEvent.mobItemDrop(entity.getCommandSenderWorld(), entity, null);
	}
}
