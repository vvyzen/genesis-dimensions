/*package vvyzen.genesismod.fluids;

import com.google.common.collect.Lists;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import java.util.List;
import java.util.function.Supplier;

public class LiquidBlockFixed extends LiquidBlock {

    final FlowingFluid fluid;
    public final List<FluidState> stateCache;

    public LiquidBlockFixed(Fluid fluidtype, BlockBehaviour.Properties properties) {
        super((Supplier<? extends FlowingFluid>) fluidtype, properties);
        this.fluid = getFluid();
        this.stateCache = Lists.newArrayList();
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, Integer.valueOf(0)));
    }

    public FlowingFluid getFluid() {
        return (FlowingFluid)fluid;
    }

}*/