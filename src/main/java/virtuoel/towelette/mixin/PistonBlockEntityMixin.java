package virtuoel.towelette.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.PistonBlockEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import virtuoel.towelette.util.FluidUtils;

@Mixin(PistonBlockEntity.class)
public abstract class PistonBlockEntityMixin
{
	@Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderingState(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/IWorld;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;"))
	public BlockState tickGetRenderingStateProxy(BlockState blockState_1, IWorld iWorld_1, BlockPos blockPos_1)
	{
		return FluidUtils.getStateWithFluid(Block.getRenderingState(blockState_1, iWorld_1, blockPos_1), Fluids.EMPTY.getDefaultState());
	}
}
