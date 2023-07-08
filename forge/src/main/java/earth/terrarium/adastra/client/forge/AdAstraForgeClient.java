package earth.terrarium.adastra.client.forge;

import earth.terrarium.adastra.client.AdAstraClient;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdAstraForgeClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(AdAstraClient::init);
        MinecraftForge.EVENT_BUS.addListener(AdAstraForgeClient::onClientTick);
    }

    @SubscribeEvent
    public static void postInit(FMLClientSetupEvent event) {
    }

    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase.equals(TickEvent.Phase.START)) {
            AdAstraClient.clientTick(Minecraft.getInstance());
        }
    }
}
