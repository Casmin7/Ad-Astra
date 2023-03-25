package earth.terrarium.ad_astra.datagen;

import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.datagen.provider.client.ModBlockStateProvider;
import earth.terrarium.ad_astra.datagen.provider.client.ModItemModelProvider;
import earth.terrarium.ad_astra.datagen.provider.client.ModLangProvider;
import earth.terrarium.ad_astra.datagen.provider.server.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = AdAstra.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class AdAstraDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();

        // Client
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(generator.getPackOutput(), existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(generator.getPackOutput(), existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLangProvider(generator.getPackOutput()));

        // Server
        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ForgeItemTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModPlanetProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModConfiguredCarverProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModDensityFunctionProvider(packOutput));
    }
}
