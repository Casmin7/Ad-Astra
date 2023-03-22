package earth.terrarium.ad_astra.common.config;

import com.teamresourceful.resourcefulconfig.common.annotations.Category;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;
import com.teamresourceful.resourcefulconfig.web.annotations.WebInfo;
import earth.terrarium.botarium.common.fluid.utils.FluidHooks;

@Category(id = "fuelRefinery", translation = "text.resourcefulconfig.ad_astra.option.fuelRefinery")
@WebInfo(icon = "fuel")
public final class FuelRefineryConfig {

    @ConfigEntry(
        id = "maxEnergy",
        type = EntryType.LONG,
        translation = "text.resourcefulconfig.ad_astra.option.fuelRefinery.maxEnergy"
    )
    public static long maxEnergy = 9000L;

    @ConfigEntry(
        id = "energyPerTick",
        type = EntryType.LONG,
        translation = "text.resourcefulconfig.ad_astra.option.fuelRefinery.energyPerTick"
    )
    public static long energyPerTick = 30L;

    @ConfigEntry(
        id = "tankSize",
        type = EntryType.LONG,
        translation = "text.resourcefulconfig.ad_astra.option.fuelRefinery.tankSize"
    )
    public static long tankSize = FluidHooks.buckets(3);
}