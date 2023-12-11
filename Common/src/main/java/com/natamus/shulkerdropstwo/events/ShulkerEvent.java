package com.natamus.shulkerdropstwo.events;

import com.natamus.collective.functions.TaskFunctions;
import com.natamus.shulkerdropstwo.config.ConfigHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;

public class ShulkerEvent {
	public static void mobItemDrop(Level world, Entity entity, DamageSource damageSource) {
		if (world.isClientSide) {
			return;
		}
		
		if (!(entity instanceof Shulker)) {
			return;
		}
		
		BlockPos epos = entity.blockPosition();
		
		TaskFunctions.enqueueTask(world, () -> {
			List<ItemEntity> shellies = new ArrayList<ItemEntity>();

			int r = 1;
			for (Entity ea : world.getEntities(null, new AABB(epos.getX()-r, epos.getY()-r, epos.getZ()-r, epos.getX()+r, epos.getY()+r, epos.getZ()+r))) {
				if (ea instanceof ItemEntity) {
					ItemEntity ie = (ItemEntity)ea;
					if (ie.getItem().getItem().equals(Items.SHULKER_SHELL)) {
						if (ie.blockPosition().equals(epos)) {
							shellies.add(ie);
						}
					}
				}
			}

			if (shellies.size() > 0) {
				for (ItemEntity shellentity : shellies) {
					ItemStack item = shellentity.getItem();

					item.setCount(ConfigHandler.shulkerDropAmount);
					shellentity.setItem(item);
				}
			}
			else if (ConfigHandler.alwaysDropShells) {
				ItemEntity newshell = new ItemEntity(world, epos.getX(), epos.getY(), epos.getZ(), new ItemStack(Items.SHULKER_SHELL, ConfigHandler.shulkerDropAmount));

				world.addFreshEntity(newshell);
			}
		}, 0);
	}
}
