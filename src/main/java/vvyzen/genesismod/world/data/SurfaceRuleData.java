package vvyzen.genesismod.world.data;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import vvyzen.genesismod.init.BlockRegistry;

public class SurfaceRuleData {

    private static final SurfaceRules.RuleSource BEDROCK = stateRule(Blocks.BEDROCK);


    private static final SurfaceRules.RuleSource S_DIRT = stateRule(BlockRegistry.SULPHURIC_SOIL.get());
    private static final SurfaceRules.RuleSource S_GRASS = stateRule(BlockRegistry.SULPHURIC_GRASS.get());
    private static final SurfaceRules.RuleSource MOONSTONE = stateRule(BlockRegistry.MOONSTONE.get());
    private static final SurfaceRules.RuleSource ASH = stateRule(BlockRegistry.ASH.get());
    private static final SurfaceRules.RuleSource SOOT = stateRule(BlockRegistry.SOOT.get());

    public static SurfaceRules.RuleSource OWO_SURFACE(){
        SurfaceRules.ConditionSource aboveWater = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource bedrockFloor = SurfaceRules.verticalGradient("ssvrfi:bedrock_floor", VerticalAnchor.aboveBottom(0),VerticalAnchor.aboveBottom(5));


        SurfaceRules.ifTrue(bedrockFloor,BEDROCK);

        return null;
    }






    private static SurfaceRules.RuleSource stateRule(Block block){
        return stateRule(block);
    }

    private static SurfaceRules.RuleSource stateRule(BlockState state){
        return SurfaceRules.state(state);
    }
}
