package net.albertlarsan.al68_tweaks.item;

import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FlightItem extends GlintItem {

    public FlightItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (hand == Hand.MAIN_HAND) {
            if (world.isClient()) {
                PlayerAbilities abilities = (user.getAbilities());
                if (!abilities.allowFlying) {
                    abilities.allowFlying = true;
                } else {
                    if (!(user.isCreative() || user.isSpectator())) {
                        abilities.allowFlying = false;
                    }
                }
            }
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

}
