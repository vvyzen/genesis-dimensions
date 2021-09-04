//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package vvyzen.genesismod.world.level.feature.trunkplacers;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import vvyzen.genesismod.init.BlockRegistry;
import vvyzen.genesismod.init.TreeRegistry;

public class EternalTrunkPlacer extends TrunkPlacer {

    public static final Codec<EternalTrunkPlacer> CODEC = RecordCodecBuilder.create((p_70136_) -> {
        return trunkPlacerParts(p_70136_).apply(p_70136_, EternalTrunkPlacer::new);
    });
    private static final double TRUNK_HEIGHT_SCALE = 1.0D;
    private static final double CLUSTER_DENSITY_MAGIC = 5.382D;
    private static final double BRANCH_SLOPE = 0.381D;
    private static final double BRANCH_LENGTH_MAGIC = 10.328D;

    public EternalTrunkPlacer(int p_70094_, int p_70095_, int p_70096_) {
        super(p_70094_, p_70095_, p_70096_);
    }

    protected TrunkPlacerType<?> type() {
        return TreeRegistry.ETERNAL_TRUNK_PLACER;
    }

    public List<FoliageAttachment> placeTrunk(LevelSimulatedReader p_161801_, BiConsumer<BlockPos, BlockState> p_161802_, Random p_161803_, int p_161804_, BlockPos p_161805_, TreeConfiguration p_161806_) {
        BlockPos Cvar7 = p_161805_.below();
        placeDirt(p_161801_, p_161802_, p_161803_, Cvar7, p_161806_);
        placeDirt(p_161801_, p_161802_, p_161803_, Cvar7.east(), p_161806_);
        placeDirt(p_161801_, p_161802_, p_161803_, Cvar7.south(), p_161806_);
        placeDirt(p_161801_, p_161802_, p_161803_, Cvar7.south().east(), p_161806_);
        BlockPos.MutableBlockPos Cvar8 = new BlockPos.MutableBlockPos();

        for (int Cvar9 = 0; Cvar9 < p_161804_; ++Cvar9) {
            placeLogIfFreeWithOffset(p_161801_, p_161802_, p_161803_, Cvar8, p_161806_, p_161805_, 0, Cvar9, 0);
            if (Cvar9 < p_161804_ - 1) {
                placeLogIfFreeWithOffset(p_161801_, p_161802_, p_161803_, Cvar8, p_161806_, p_161805_, 1, Cvar9, 0);
                placeLogIfFreeWithOffset(p_161801_, p_161802_, p_161803_, Cvar8, p_161806_, p_161805_, 1, Cvar9, 1);
                placeLogIfFreeWithOffset(p_161801_, p_161802_, p_161803_, Cvar8, p_161806_, p_161805_, 0, Cvar9, 1);
            }
        }


        boolean var7 = true;
        int var8 = p_161804_ + 2;
        int var9 = Mth.floor((double) var8 * 0.618D);
        setDirtAt(p_161801_, p_161802_, p_161803_, p_161805_.below(), p_161806_);
        double var10 = 1.0D;
        int var12 = Math.min(1, Mth.floor(1.382D + Math.pow(1.0D * (double) var8 / 13.0D, 2.0D)));
        int var13 = p_161805_.getY() + var9;
        int var14 = var8 - 5;
        List<EternalTrunkPlacer.FoliageCoords> var15 = Lists.newArrayList();
        var15.add(new EternalTrunkPlacer.FoliageCoords(p_161805_.above(var14), var13));

        for (; var14 >= 0; --var14) {
            float var16 = treeShape(var8, var14);
            if (!(var16 < 0.0F)) {
                for (int var17 = 0; var17 < var12; ++var17) {
                    double var18 = 1.0D;
                    double var20 = 1.0D * (double) var16 * ((double) p_161803_.nextFloat() + 0.328D);
                    double var22 = (double) (p_161803_.nextFloat() * 2.0F) * 3.141592653589793D;
                    double var24 = var20 * Math.sin(var22) + 0.5D;
                    double var26 = var20 * Math.cos(var22) + 0.5D;
                    BlockPos var28 = p_161805_.offset(var24, (double) (var14 - 1), var26);
                    BlockPos var29 = var28.above(5);
                    if (this.makeLimb(p_161801_, p_161802_, p_161803_, var28, var29, false, p_161806_)) {
                        int var30 = p_161805_.getX() - var28.getX();
                        int var31 = p_161805_.getZ() - var28.getZ();
                        double var32 = (double) var28.getY() - Math.sqrt((double) (var30 * var30 + var31 * var31)) * 0.381D;
                        int var34 = var32 > (double) var13 ? var13 : (int) var32;
                        BlockPos var35 = new BlockPos(p_161805_.getX(), var34, p_161805_.getZ());
                        if (this.makeLimb(p_161801_, p_161802_, p_161803_, var35, var28, false, p_161806_)) {
                            var15.add(new EternalTrunkPlacer.FoliageCoords(var28, var35.getY()));
                        }
                    }
                }
            }
        }

        this.makeLimb(p_161801_, p_161802_, p_161803_, p_161805_, p_161805_.above(var9), true, p_161806_);
        this.makeBranches(p_161801_, p_161802_, p_161803_, var8, p_161805_, var15, p_161806_);
        List<FoliageAttachment> var36 = Lists.newArrayList();
        Iterator var37 = var15.iterator();

        while (var37.hasNext()) {
            EternalTrunkPlacer.FoliageCoords var38 = (EternalTrunkPlacer.FoliageCoords) var37.next();
            if (this.trimBranches(var8, var38.getBranchBase() - p_161805_.getY())) {
                var36.add(var38.attachment);
            }
        }

        return var36;
    }

    private static void placeLogIfFreeWithOffset(LevelSimulatedReader p_161842_, BiConsumer<BlockPos, BlockState> p_161843_, Random p_161844_, BlockPos.MutableBlockPos p_161845_, TreeConfiguration p_161846_, BlockPos p_161847_, int p_161848_, int p_161849_, int p_161850_) {
        p_161845_.setWithOffset(p_161847_, p_161848_, p_161849_, p_161850_);
        placeLogIfFree(p_161842_, p_161843_, p_161844_, p_161845_, p_161846_);
    }

    private boolean makeLimb(LevelSimulatedReader p_161816_, BiConsumer<BlockPos, BlockState> p_161817_, Random p_161818_, BlockPos p_161819_, BlockPos p_161820_, boolean p_161821_, TreeConfiguration p_161822_) {
        if (!p_161821_ && Objects.equals(p_161819_, p_161820_)) {
            return true;
        } else {
            BlockPos var8 = p_161820_.offset(-p_161819_.getX(), -p_161819_.getY(), -p_161819_.getZ());
            int var9 = this.getSteps(var8);
            float var10 = (float) var8.getX() / (float) var9;
            float var11 = (float) var8.getY() / (float) var9;
            float var12 = (float) var8.getZ() / (float) var9;

            for (int var13 = 0; var13 <= var9; ++var13) {
                BlockPos var14 = p_161819_.offset((double) (0.5F + (float) var13 * var10), (double) (0.5F + (float) var13 * var11), (double) (0.5F + (float) var13 * var12));
                if (p_161821_) {
                    TrunkPlacer.placeLog(p_161816_, p_161817_, p_161818_, var14, p_161822_, (p_161826_) -> {
                        return (BlockState) p_161826_.setValue(RotatedPillarBlock.AXIS, this.getLogAxis(p_161819_, var14));
                    });
                } else if (!TreeFeature.isFree(p_161816_, var14)) {
                    return false;
                }
            }

            return true;
        }
    }

    private int getSteps(BlockPos p_70128_) {
        int var2 = Mth.abs(p_70128_.getX());
        int var3 = Mth.abs(p_70128_.getY());
        int var4 = Mth.abs(p_70128_.getZ());
        return Math.max(var2, Math.max(var3, var4));
    }

    private Axis getLogAxis(BlockPos p_70130_, BlockPos p_70131_) {
        Axis var3 = Axis.Y;
        int var4 = Math.abs(p_70131_.getX() - p_70130_.getX());
        int var5 = Math.abs(p_70131_.getZ() - p_70130_.getZ());
        int var6 = Math.max(var4, var5);
        if (var6 > 0) {
            if (var4 == var6) {
                var3 = Axis.X;
            } else {
                var3 = Axis.Z;
            }
        }

        return var3;
    }

    private boolean trimBranches(int p_70099_, int p_70100_) {
        return (double) p_70100_ >= (double) p_70099_ * 0.2D;
    }

    private void makeBranches(LevelSimulatedReader p_161808_, BiConsumer<BlockPos, BlockState> p_161809_, Random p_161810_, int p_161811_, BlockPos p_161812_, List<EternalTrunkPlacer.FoliageCoords> p_161813_, TreeConfiguration p_161814_) {
        Iterator var8 = p_161813_.iterator();

        while (var8.hasNext()) {
            EternalTrunkPlacer.FoliageCoords var9 = (EternalTrunkPlacer.FoliageCoords) var8.next();
            int var10 = var9.getBranchBase();
            BlockPos var11 = new BlockPos(p_161812_.getX(), var10, p_161812_.getZ());
            if (!var11.equals(var9.attachment.pos()) && this.trimBranches(p_161811_, var10 - p_161812_.getY())) {
                this.makeLimb(p_161808_, p_161809_, p_161810_, var11, var9.attachment.pos(), true, p_161814_);
            }
        }

    }

    private static float treeShape(int p_70133_, int p_70134_) {
        if ((float) p_70134_ < (float) p_70133_ * 0.3F) {
            return -1.0F;
        } else {
            float var2 = (float) p_70133_ / 2.0F;
            float var3 = var2 - (float) p_70134_;
            float var4 = Mth.sqrt(var2 * var2 - var3 * var3);
            if (var3 == 0.0F) {
                var4 = var2;
            } else if (Math.abs(var3) >= var2) {
                return 0.0F;
            }

            return var4 * 0.5F;
        }
    }

    static class FoliageCoords {
        final FoliageAttachment attachment;
        private final int branchBase;

        public FoliageCoords(BlockPos p_70140_, int p_70141_) {
            this.attachment = new FoliageAttachment(p_70140_, 0, false);
            this.branchBase = p_70141_;
        }

        public int getBranchBase() {
            return this.branchBase;
        }
    }

    protected static void placeDirt(LevelSimulatedReader p_161881_, BiConsumer<BlockPos, BlockState> p_161882_, Random p_161883_, BlockPos p_161884_, TreeConfiguration p_161885_) {
            p_161882_.accept(p_161884_, BlockRegistry.SULPHURIC_SOIL.get().defaultBlockState());
    }
}
