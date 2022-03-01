package com.trufflez.tsarcanum.world.feature.tree;

import com.trufflez.tsarcanum.mixin.FoliagePlacerTypeInvoker;
import com.trufflez.tsarcanum.world.feature.tree.foliageplacer.TsDroopyFoliagePlacer;
import com.trufflez.tsarcanum.world.feature.tree.foliageplacer.TsLargeFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class TsFoliagePlacers {
    
    public static final FoliagePlacerType<TsLargeFoliagePlacer> LARGE_FOLIAGE_PLACER;
    public static final FoliagePlacerType<TsDroopyFoliagePlacer> DROOPY_FOLIAGE_PLACER;
    
    static {
        LARGE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("large_foliage_placer", TsLargeFoliagePlacer.CODEC);
        DROOPY_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("droopy_foliage_placer", TsDroopyFoliagePlacer.CODEC);
    }
}
