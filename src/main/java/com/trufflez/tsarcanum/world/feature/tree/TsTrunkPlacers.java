package com.trufflez.tsarcanum.world.feature.tree;

import com.trufflez.tsarcanum.TsArcanum;
import com.trufflez.tsarcanum.mixin.TrunkPlacerTypeInvoker;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsCanopyTrunkPlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsRootedTrunkPlacer;
import com.trufflez.tsarcanum.world.feature.tree.trunkplacer.TsBranchyTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class TsTrunkPlacers {
    
    public static final TrunkPlacerType<TsCanopyTrunkPlacer> CANOPY_TRUNK_PLACER;
    public static final TrunkPlacerType<TsBranchyTrunkPlacer> BRANCHY_TRUNK_PLACER;
    public static final TrunkPlacerType<TsRootedTrunkPlacer> ROOTED_TRUNK_PLACER;
    
    static {
        CANOPY_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("canopy_trunk_placer", TsCanopyTrunkPlacer.CODEC);
        BRANCHY_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("branchy_trunk_placer", TsBranchyTrunkPlacer.CODEC);
        ROOTED_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("rooted_trunk_placer", TsRootedTrunkPlacer.CODEC);
    }
    
    public static void init() {
        TsArcanum.LOGGER.debug("Registering TrunkPlacers");
    }
}
