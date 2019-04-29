package virtuoel.towelette.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.BambooBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(BambooBlock.class)
public class BambooBlockMixin
{
	@Redirect(method = "getPlacementState", at = @At(value = "INVOKE", target = "getFluidState"))
	public FluidState getPlacementStateGetFluidStateProxy(World obj, BlockPos blockPos_1)
	{
		return Fluids.EMPTY.getDefaultState();
	}
}
