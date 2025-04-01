package com.devdyna.alchemia.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.alchemia.Main;
import com.devdyna.alchemia.init.builder.ResourceGen.Deposit;
import com.devdyna.alchemia.init.types.BlockTag;
import com.devdyna.alchemia.init.types.Blocks;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import static net.minecraft.world.level.block.Blocks.SUGAR_CANE;
import static net.minecraft.world.level.block.Blocks.CACTUS;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import static com.devdyna.alchemia.init.Material.*;

@SuppressWarnings("null")

public class DataBlockTag extends BlockTagsProvider {

    public DataBlockTag(PackOutput o, CompletableFuture<Provider> l, ExistingFileHelper f) {
        super(o, l, Main.MODID, f);
    }

    @Override
    protected void addTags(Provider p) {
        tag(BlockTag.LEAVES)
                .addTag(BlockTags.LEAVES);
        tag(BlockTag.SPRINKLER)
                .addTag(BlockTags.CROPS)
                .add(Blocks.AZALEA.get(), CACTUS, SUGAR_CANE);

        // landing
        tag(BlockTag.Deposit_0).add(
                getDeposit(Deposit.IRON),
                getDeposit(Deposit.STONE));

        // grass
        tag(BlockTag.Deposit_1).add(
                getDeposit(Deposit.COPPER),
                getDeposit(Deposit.IRON),
                getDeposit(Deposit.STONE));

        // rocky
        tag(BlockTag.Deposit_2).add(
                getDeposit(Deposit.GOLD),
                getDeposit(Deposit.IRON),
                getDeposit(Deposit.STONE));

        // sand
        tag(BlockTag.Deposit_3).add(
                getDeposit(Deposit.SAND),
                getDeposit(Deposit.GOLD));

        // magic
        // tag(BlockTag.Deposit_4).add(
        // getDeposit(Deposit.IRON),
        // getDeposit(Deposit.STONE));

        // mud
        tag(BlockTag.Deposit_5).add(
                getDeposit(Deposit.STONE));

        // podzol
        // tag(BlockTag.Deposit_6).add(
        // getDeposit(Deposit.IRON),
        // getDeposit(Deposit.STONE));

        // snow
        tag(BlockTag.Deposit_7).add(
                getDeposit(Deposit.PLATINUM));

        // magma
        tag(BlockTag.Deposit_8).add(
                getDeposit(Deposit.URANIUM));
    }

}