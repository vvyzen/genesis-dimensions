/*package vvyzen.genesismod.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.*;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import vvyzen.genesismod.init.BlockRegistry;
import vvyzen.genesismod.init.FluidRegistry;

public class BloodFluid extends FlowingFluid {


    @Override
    public Fluid getFlowing() {
        return FluidRegistry.FLOWING_BLOOD.get();
    }
    @Override
    public Fluid getSource() {
        return FluidRegistry.BLOOD_SOURCE.get();
    }

    @Override
    protected boolean canConvertToSource() {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor p_76002_, BlockPos p_76003_, BlockState p_76004_) {

    }

    @Override
    protected int getSlopeFindDistance(LevelReader p_76074_) {
        return 4;
    }

    @Override
    protected int getDropOff(LevelReader p_76087_) {
        return 1;
    }


    public Block getBlock(){
        return BlockRegistry.BLOOD.get();
    }

    @Override
    public Item getBucket() {
        return null;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState p_76127_, BlockGetter p_76128_, BlockPos p_76129_, Fluid p_76130_, Direction p_76131_) {
        return false;
    }

    @Override
    public int getTickDelay(LevelReader p_76120_) {
        return 10;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState p_76136_) {
        return null;
    }

    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 0;
    }

    public static class Flowing extends BloodFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> p_76476_) {
            super.createFluidStateDefinition(p_76476_);
            p_76476_.add(LEVEL);
        }

        public int getAmount(FluidState p_76480_) {
            return p_76480_.getValue(LEVEL);
        }

        public boolean isSource(FluidState p_76478_) {
            return false;
        }
    }

    public static class Source extends WaterFluid {
        public int getAmount(FluidState p_76485_) {
            return 8;
        }

        public boolean isSource(FluidState p_76483_) {
            return true;
        }
    }
}*/