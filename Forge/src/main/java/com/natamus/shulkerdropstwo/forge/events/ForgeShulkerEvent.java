package com.natamus.shulkerdropstwo.forge.events;

import com.natamus.shulkerdropstwo.events.ShulkerEvent;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeShulkerEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeShulkerEvent.class);

		LivingDropsEvent.BUS.addListener(ForgeShulkerEvent::mobItemDrop);
	}

	@SubscribeEvent
	public static void mobItemDrop(LivingDropsEvent e) {
		Entity entity = e.getEntity();
		ShulkerEvent.mobItemDrop(entity.level(), entity, null);
	}
}
