package vvyzen.genesismod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class SulphuricGrassBlock extends Block implements BonemealableBlock {

    public SulphuricGrassBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter p_50897_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(Level p_50901_, Random p_50902_, BlockPos p_50903_, BlockState p_50904_) {
        return false;
    }

    @Override
    public void performBonemeal(ServerLevel p_50893_, Random p_50894_, BlockPos p_50895_, BlockState p_50896_) {

    }
}
