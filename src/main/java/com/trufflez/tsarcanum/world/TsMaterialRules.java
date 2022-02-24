package com.trufflez.tsarcanum.world;

import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class TsMaterialRules {

    
    
    
    
    // per each custom biome
    /*public static final SurfaceRules.RuleSource SWAMP_SURFACE_RULES = SurfaceRules.ifTrue(SurfaceRules.isBiome(BYGBiomes.BAYOU, BYGBiomes.CYPRESS_SWAMPLANDS),
            SurfaceRules.ifTrue(
                    ABOVE_62,
                    SurfaceRules.ifTrue(SurfaceRules.not(ABOVE_63),
                            SurfaceRules.ifTrue(
                                    SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D),
                                    SurfaceRules.state(Blocks.WATER.defaultBlockState())
                            )
                    )
            ));
    */
    
    
    // per each custom biome
    public static final MaterialRules.MaterialRule OVERWORLD_ABOVE_PRELIMINARY_SURFACE = MaterialRules.condition(MaterialRules.surface(),
            MaterialRules.sequence());
    
    public static final MaterialRules.MaterialRule OVERWORLD_SURFACE_RULES = MaterialRules.sequence(OVERWORLD_ABOVE_PRELIMINARY_SURFACE);
    
}
