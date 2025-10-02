package com.natamus.shulkerdropstwo.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.shulkerdropstwo.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean alwaysDropShells = false;
	@Entry(min = 1, max = 64) public static int shulkerDropAmount = 2;

	public static void initConfig() {
		configMetaData.put("alwaysDropShells", Arrays.asList(
			"Ignore the drop chance (default 50%) that a Shulker will drop their shell and instead makes them always drop it."
		));
		configMetaData.put("shulkerDropAmount", Arrays.asList(
			"Sets the amount of shells Shulkers drop."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}