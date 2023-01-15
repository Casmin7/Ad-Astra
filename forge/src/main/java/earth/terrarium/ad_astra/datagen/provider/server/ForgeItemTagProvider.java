package earth.terrarium.ad_astra.datagen.provider.server;

import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.common.registry.ModItems;
import earth.terrarium.ad_astra.common.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ForgeItemTagProvider extends TagsProvider<Item> {
    public ForgeItemTagProvider(PackOutput arg, ResourceKey<? extends Registry<Item>> arg2, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, arg2, completableFuture, AdAstra.MOD_ID + "_forge", existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(forge("storage_blocks/etrium")).add(TagEntry.element(ModItems.ETRIUM_BLOCK.getId()));
        tag(forge("storage_blocks/steel")).add(TagEntry.element(ModItems.STEEL_BLOCK.getId()));
        tag(forge("storage_blocks/desmium")).add(TagEntry.element(ModItems.DESMIUM_BLOCK.getId()));
        tag(forge("storage_blocks/xebrium")).add(TagEntry.element(ModItems.XEBRIUM_BLOCK.getId()));
        tag(forge("storage_blocks/vesnium")).add(TagEntry.element(ModItems.VESNIUM_BLOCK.getId()));
        tag(forge("storage_blocks/aerolyte")).add(TagEntry.element(ModItems.AEROLYTE_BLOCK.getId()));

        tag(forge("plates/steel")).add(TagEntry.element(ModItems.STEEL_PLATE.getId()));
        tag(forge("rods/steel")).add(TagEntry.element(ModItems.STEEL_ROD.getId()));
        tag(forge("nuggets/steel")).add(TagEntry.element(ModItems.STEEL_NUGGET.getId()));
        tag(forge("ingots/steel")).add(TagEntry.element(ModItems.STEEL_INGOT.getId()));

        tag(forge("plates/desmium")).add(TagEntry.element(ModItems.DESMIUM_PLATE.getId()));
        tag(forge("nuggets/desmium")).add(TagEntry.element(ModItems.DESMIUM_NUGGET.getId()));
        tag(forge("ingots/desmium")).add(TagEntry.element(ModItems.DESMIUM_INGOT.getId()));

        tag(forge("plates/iron")).add(TagEntry.element(ModItems.IRON_PLATE.getId()));
        tag(forge("rods/iron")).add(TagEntry.element(ModItems.IRON_ROD.getId()));

        tag(forge("plates/xebrium")).add(TagEntry.element(ModItems.XEBRIUM_PLATE.getId()));
        tag(forge("nuggets/xebrium")).add(TagEntry.element(ModItems.XEBRIUM_NUGGET.getId()));
        tag(forge("ingots/xebrium")).add(TagEntry.element(ModItems.XEBRIUM_INGOT.getId()));

        tag(forge("plates/aerolyte")).add(TagEntry.element(ModItems.AEROLYTE_PLATE.getId()));
        tag(forge("nuggets/aerolyte")).add(TagEntry.element(ModItems.AEROLYTE_NUGGET.getId()));
        tag(forge("ingots/aerolyte")).add(TagEntry.element(ModItems.AEROLYTE_INGOT.getId()));

        tag(forge("plates/etrium")).add(TagEntry.element(ModItems.ETRIUM_PLATE.getId()));
        tag(forge("nuggets/etrium")).add(TagEntry.element(ModItems.ETRIUM_NUGGET.getId()));
        tag(forge("ingots/etrium")).add(TagEntry.element(ModItems.ETRIUM_INGOT.getId()));
    }

    private TagKey<Item> forge(String path) {
        return TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("forge", path));
    }
}
