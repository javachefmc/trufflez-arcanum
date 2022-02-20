package com.trufflez.tsarcanum.world.feature.tree;

import com.trufflez.tsarcanum.mixin.TrunkPlacerTypeInvoker;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsLargeTrunkPlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsRootedTrunkPlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsSpreadTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class TsTrunkPlacers {
    
    public static final TrunkPlacerType<TsLargeTrunkPlacer> LARGE_TRUNK_PLACER;
    public static final TrunkPlacerType<TsSpreadTrunkPlacer> SPREAD_TRUNK_PLACER;
    public static final TrunkPlacerType<TsRootedTrunkPlacer> ROOTED_TRUNK_PLACER;
    
    static {
        LARGE_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("large_trunk_placer", TsLargeTrunkPlacer.CODEC);
        SPREAD_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("spread_trunk_placer", TsSpreadTrunkPlacer.CODEC);
        ROOTED_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("rooted_trunk_placer", TsRootedTrunkPlacer.CODEC);
    }
}
