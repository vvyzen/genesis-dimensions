package vvyzen.genesismod.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

import java.util.Random;

public class SSPPublic extends BlockStateProvider {
    public static final Codec<SSPPublic> CODEC = BlockState.CODEC.fieldOf("state").xmap(SSPPublic::new, (p_68804_) -> {
        return p_68804_.state;
    }).codec();
    private final BlockState state;

    public SSPPublic(BlockState p_68801_) {
        this.state = p_68801_;
    }

    protected BlockStateProviderType<?> type() {
        return BlockStateProviderType.SIMPLE_STATE_PROVIDER;
    }

    public BlockState getState(Random p_68806_, BlockPos p_68807_) {
        return this.state;
    }
}