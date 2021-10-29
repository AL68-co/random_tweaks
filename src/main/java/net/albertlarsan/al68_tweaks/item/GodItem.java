package net.albertlarsan.al68_tweaks.item;

import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GodItem extends Item {

    public GodItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (hand == Hand.MAIN_HAND) {
            if (!world.isClient()) {
                PlayerAbilities abilities = (user.getAbilities());
                if (!abilities.invulnerable) {
                    abilities.invulnerable = true;
                    user.setInvulnerable(true);
                } else {
                    if (!(user.isCreative() || user.isSpectator())) {
                        abilities.invulnerable = false;
                        user.setInvulnerable(false);
                    }
                }
            }
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

}
