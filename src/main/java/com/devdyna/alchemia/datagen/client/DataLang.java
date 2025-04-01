package com.devdyna.alchemia.datagen.client;

import static com.devdyna.alchemia.Main.MODID;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DataLang extends LanguageProvider {

    public DataLang(PackOutput o) {
        super(o, MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //TODO
        // RegistryToLang("block",Blocks.AZALEA, "hi");
        // RegistryToLang("item",Items.AZALEA_SEEDS, "hi");
    }

    // @SuppressWarnings("rawtypes")
    // private void RegistryToLang(String type,DeferredHolder d,String text){
    //         add(type+"."+d.getRegisteredName().replace(":", "."),text);
    // }

}
