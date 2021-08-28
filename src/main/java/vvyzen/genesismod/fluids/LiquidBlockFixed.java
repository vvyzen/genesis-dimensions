package vvyzen.genesismod.fluids;

import com.google.common.collect.Lists;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;

import java.util.List;

public class LiquidBlockFixed extends LiquidBlock {

    protected final FlowingFluid fluid;
    private final List<FluidState> stateCache;
    public LiquidBlockFixed(java.util.function.Supplier<? extends FlowingFluid> p_54694_, BlockBehaviour.Properties properties) {
        super(properties);
        this.fluid = getFluid();
        this.stateCache = Lists.newArrayList();
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, Integer.valueOf(0)));
        this.supplier = p_54694_;
    }

    private final java.util.function.Supplier<? extends net.minecraft.world.level.material.Fluid> supplier;
    public FlowingFluid getFluid() {
        return (FlowingFluid)supplier.get();
    }

}