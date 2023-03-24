package earth.terrarium.ad_astra.fabric;

import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.common.data.PlanetData;
import earth.terrarium.ad_astra.common.registry.ModCommands;
import earth.terrarium.ad_astra.common.registry.ModEntityTypes;
import earth.terrarium.ad_astra.common.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AdAstraFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AdAstra.init();
        ModEntityTypes.registerAttributes((type, builder) -> FabricDefaultAttributeRegistry.register(type.get(), builder.get()));
        CommandRegistrationCallback.EVENT.register((dispatcher, registry, selection) -> ModCommands.registerCommands(command -> command.accept(dispatcher)));
        registerCreativeTabs();
        registerReloadListeners();
    }

    public static void registerCreativeTabs() {
        ModItems.onRegisterCreativeTabs((loc, item, items) -> FabricItemGroup.builder(loc)
                .title(Component.translatable("itemGroup." + loc.getNamespace() + "." + loc.getPath()))
                .icon(() -> item.get().getDefaultInstance())
                .displayItems((itemDisplayParameters, output) -> items.forEach(output::accept))
                .build());
    }

    public static void registerReloadListeners() {
        PlanetData.onRegisterReloadListeners((id, listener) -> ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return id;
            }

            @Override
            public CompletableFuture<Void> reload(PreparationBarrier synchronizer, ResourceManager manager, ProfilerFiller prepareProfiler, ProfilerFiller applyProfiler, Executor prepareExecutor, Executor applyExecutor) {
                return listener.reload(synchronizer, manager, prepareProfiler, applyProfiler, prepareExecutor, applyExecutor);
            }
        }));
    }
}
