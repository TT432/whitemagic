package io.github.tt432.whitemagic;

import com.google.common.collect.Queues;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.tt432.whitemagic.util.PoseStackDeque;
import net.minecraft.Util;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.openjdk.jmh.annotations.*;

import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * @author TT432
 */
public class PoseStackDequeTest {
    @State(Scope.Benchmark)
    public static class VanillaState {
        volatile Deque<PoseStack.Pose> poseStack = Util.make(Queues.newArrayDeque(), (p_85848_) -> {
            Matrix4f matrix4f = new Matrix4f();
            Matrix3f matrix3f = new Matrix3f();
            p_85848_.add(new PoseStack.Pose(matrix4f, matrix3f));
        });
    }

    @State(Scope.Benchmark)
    public static class ModState {
        volatile PoseStackDeque deque = new PoseStackDeque();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void vanillaTest(VanillaState state) {
        PoseStack.Pose posestack$pose = state.poseStack.getLast();
        state.poseStack.addLast(new PoseStack.Pose(new Matrix4f(posestack$pose.pose()), new Matrix3f(posestack$pose.normal())));

        state.poseStack.removeLast();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void modTest(ModState state) {
        state.deque.push(null);

        state.deque.pop();
    }
}
