package vvyzen.genesismod.init;

import net.minecraft.world.level.material.*;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vvyzen.genesismod.GenesisMod;
import vvyzen.genesismod.fluids.BloodFluid;
import vvyzen.genesismod.fluids.FluidProperties;


public class FluidRegistry {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, GenesisMod.MODID);

    //fuck
    //public static final RegistryObject<BloodFluid.Flowing> FLOWING_BLOOD = FLUIDS.register("flowing_blood", () -> new BloodFluid.Flowing(FluidProperties.BLOOD_PROPERTIES));
    //public static final RegistryObject<BloodFluid.Source> BLOOD_SOURCE = FLUIDS.register("blood_source", () -> new BloodFluid.Source(FluidProperties.BLOOD_PROPERTIES) );
    public static final RegistryObject<ForgeFlowingFluid.Flowing> FLOWING_BLOOD = FLUIDS.register("flowing_blood", () -> new ForgeFlowingFluid.Flowing(FluidProperties.BLOOD_PROPERTIES));
    public static final RegistryObject<ForgeFlowingFluid.Source> BLOOD_SOURCE = FLUIDS.register("blood_source", () -> new ForgeFlowingFluid.Source(FluidProperties.BLOOD_PROPERTIES) );

}