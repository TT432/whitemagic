package io.github.tt432.whitemagic.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.tt432.whitemagic.util.PoseStackDeque;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Deque;

/**
 * @author TT432
 */
@Mixin(PoseStack.class)
public class MixinPoseStack {
    @Mutable
    @Shadow
    @Final
    private Deque<PoseStack.Pose> poseStack;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void whiteMagic$init(CallbackInfo ci) {
        poseStack = new PoseStackDeque();
    }

    /**
     * @author TT432
     * @reason I hope overwrite
     */
    @Overwrite
    public void pushPose() {
        poseStack.push(null);
    }
}
