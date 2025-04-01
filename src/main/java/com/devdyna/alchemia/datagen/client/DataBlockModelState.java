package com.devdyna.alchemia.datagen.client;

import static com.devdyna.alchemia.Main.MODID;

import com.devdyna.alchemia.init.types.Blocks;
import com.devdyna.alchemia.utils.DataGenUtil;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataBlockModelState extends BlockStateProvider {

    public DataBlockModelState(PackOutput o, ExistingFileHelper f) {
        super(o, MODID, f);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(Blocks.PLANTER.get(),
                models().getExistingFile(DataGenUtil.getResource("block/azalea/pot")));

        // simpleBlock(Blocks.AZALEA.get(),
        //         DataGenUtil.BlockwithParent(
        //                 Blocks.AZALEA.get(), this)
        //                 .renderType(DataGenUtil.CUTOUT));

    }

}
