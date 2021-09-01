/*package vvyzen.genesismod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CloverBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Block.box(16.0D, 0.0D, 16.0D, 4.0D, 4.0D, 4.0D);

    public CloverBlock(Properties p_51021_) {
        super(p_51021_);
    }

    public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
        Vec3 var5 = p_53517_.getOffset(p_53518_, p_53519_);
        return SHAPE.move(var5.x, var5.y, var5.z);
    }


}*/

