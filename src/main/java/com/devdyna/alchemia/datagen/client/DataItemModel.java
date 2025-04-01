package com.devdyna.alchemia.datagen.client;

import static com.devdyna.alchemia.Main.MODID;

import com.devdyna.alchemia.init.types.Blocks;
import com.devdyna.alchemia.init.types.Items;
import com.devdyna.alchemia.utils.DataGenUtil;
import com.devdyna.alchemia.utils.LogUtil;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataItemModel extends ItemModelProvider {

    public DataItemModel(PackOutput o, ExistingFileHelper f) {
        super(o, MODID, f);
    }

    @Override
    protected void registerModels() {

        Items.zTool.getEntries().forEach(item -> {
            try {
                DataGenUtil.itemTool(item.get(), this);
            } catch (Exception e) {
                LogUtil.info(e.toString());
            }

        });

        Items.zItem.getEntries().forEach(item -> {

            try {
                DataGenUtil.itemModel(item.get(), this);
            } catch (Exception e) {
                LogUtil.info(e.toString());
            }

        });

        Blocks.zBlockItem.getEntries().forEach(block -> {
            try {
                DataGenUtil.itemBlock(block.get(), this);
            } catch (Exception e) {
                LogUtil.info(e.toString());
            }
        });

    }

}
