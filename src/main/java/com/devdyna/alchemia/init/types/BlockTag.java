package com.devdyna.alchemia.init.types;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;

import static com.devdyna.alchemia.init.Material.tagBlock;

public class BlockTag {
    public static  void register(IEventBus bus){
        
    }

    public static final TagKey<Block> LEAVES = tagBlock("crook_leaves");

    public static final TagKey<Block> SPRINKLER = tagBlock("sprinkler_deny");

    public static final TagKey<Block> Deposit_0 = tagBlock("0_landing/deposit");
    public static final TagKey<Block> Deposit_1 = tagBlock("1_grass/deposit");
    public static final TagKey<Block> Deposit_2 = tagBlock("2_rocky/deposit");
    public static final TagKey<Block> Deposit_3 = tagBlock("3_desert/deposit");
    public static final TagKey<Block> Deposit_4 = tagBlock("4_magic/deposit");
    public static final TagKey<Block> Deposit_5 = tagBlock("5_mud/deposit");
    public static final TagKey<Block> Deposit_6 = tagBlock("6_podzol/deposit");
    public static final TagKey<Block> Deposit_7 = tagBlock("7_snow/deposit");
    public static final TagKey<Block> Deposit_8 = tagBlock("8_magma/deposit");





}