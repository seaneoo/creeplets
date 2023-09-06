package dev.seano.creeplets.block;

import dev.seano.creeplets.entity.CreepletTntEntity;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class CreepletTntBlock extends TntBlock {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0,
            14.0);

    public CreepletTntBlock(Settings settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos,
                                      ShapeContext context) {
        return SHAPE;
    }

    @SuppressWarnings("unused")
    public static void primeTnt(World world, BlockPos blockPos) {
        primeTnt(world, blockPos, null);
    }

    @SuppressWarnings("SameParameterValue")
    private static void primeTnt(World world, BlockPos blockPos, @Nullable LivingEntity igniter) {
        if (world.isClient) return;
        CreepletTntEntity creepletTntEntity = new CreepletTntEntity(world,
                (double) blockPos.getX() + 0.5, blockPos.getY(), (double) blockPos.getZ() + 0.5,
                igniter);
        world.spawnEntity(creepletTntEntity);
        world.playSound(null, creepletTntEntity.getX(), creepletTntEntity.getY(),
                creepletTntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS,
                1.0f, 1.0f);
        world.emitGameEvent(igniter, GameEvent.PRIME_FUSE, blockPos);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState,
                             boolean notify) {
        if (!oldState.isOf(state.getBlock())) {
            if (world.isReceivingRedstonePower(pos)) {
                primeTnt(world, pos);
                world.removeBlock(pos, false);
            }
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock,
                               BlockPos sourcePos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            primeTnt(world, pos);
            world.removeBlock(pos, false);
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && !player.isCreative() && state.get(UNSTABLE)) primeTnt(world, pos);
        super.onBreak(world, pos, state, player);
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (!world.isClient) {
            CreepletTntEntity creepletTntEntity = new CreepletTntEntity(world,
                    (double) pos.getX() + 0.5, pos.getY(), (double) pos.getZ() + 0.5,
                    explosion.getCausingEntity());
            int i = creepletTntEntity.getFuse();
            creepletTntEntity.setFuse((short) (world.random.nextInt(i / 4) + i / 8));
            world.spawnEntity(creepletTntEntity);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                              Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isOf(Items.FLINT_AND_STEEL) && !itemStack.isOf(Items.FIRE_CHARGE)) {
            return super.onUse(state, world, pos, player, hand, hit);
        } else {
            primeTnt(world, pos, player);
            world.setBlockState(pos, Blocks.AIR.getDefaultState(),
                    Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            Item item = itemStack.getItem();
            if (!player.isCreative()) {
                if (itemStack.isOf(Items.FLINT_AND_STEEL)) {
                    itemStack.damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
                } else {
                    itemStack.decrement(1);
                }
            }

            player.incrementStat(Stats.USED.getOrCreateStat(item));
            return ActionResult.success(world.isClient);
        }
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit,
                                ProjectileEntity projectile) {
        if (!world.isClient) {
            BlockPos blockPos = hit.getBlockPos();
            Entity entity = projectile.getOwner();
            if (projectile.isOnFire() && projectile.canModifyAt(world, blockPos)) {
                primeTnt(world, blockPos, entity instanceof LivingEntity ? (LivingEntity) entity
                        : null);
                world.removeBlock(blockPos, false);
            }
        }
    }
}
