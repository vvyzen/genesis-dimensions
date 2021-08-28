package vvyzen.genesismod.fluids;

import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.*;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import vvyzen.genesismod.init.BlockRegistry;
import vvyzen.genesismod.init.FluidRegistry;

public class BloodFluid extends ForgeFlowingFluid {
    public BloodFluid(ForgeFlowingFluid.Properties properties) {
        super(properties);
    }

    @Override
    public Fluid getFlowing() {
        return FluidRegistry.FLOWING_BLOOD.get();
    }
    @Override
    public Fluid getSource() {
        return FluidRegistry.BLOOD_SOURCE.get();
    }


    public Block getBlock(){
        return BlockRegistry.BLOOD.get();
    }

    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 0;
    }

    public static class Flowing extends ForgeFlowingFluid {
        public Flowing(Properties properties)
        {
            super(properties);
            registerDefaultState(getStateDefinition().any().setValue(LEVEL, 7));
        }


        public void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> fluidstate) {
            super.createFluidStateDefinition(fluidstate);
            fluidstate.add(LEVEL);
        }

        public int getAmount(FluidState fluidstate) {
            return fluidstate.getValue(LEVEL);
        }

        public boolean isSource(FluidState fluidstate) {
            return false;
        }
    }

    public static class Source extends ForgeFlowingFluid
    {
        public Source(Properties properties)
        {
            super(properties);
        }

        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }
}