package io.github.tt432.whitemagic.util;

import com.mojang.blaze3d.vertex.PoseStack;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3fStack;
import org.joml.Matrix4fStack;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author TT432
 */
public class PoseStackDeque implements Deque<PoseStack.Pose> {
    final Matrix3fStack m3stack = new Matrix3fStack(20);
    final Matrix4fStack m4stack = new Matrix4fStack(20);
    final PoseStack.Pose pose = new PoseStack.Pose(
            m4stack,
            m3stack
    );
    int pointer;

    public PoseStackDeque() {
        push(null);
    }

    @Override
    public void clear() {
        m3stack.clear();
        m4stack.clear();
    }

    @Override
    public PoseStack.Pose getLast() {
        return pose;
    }

    @Override
    public void push(PoseStack.Pose pose) {
        m3stack.pushMatrix();
        m4stack.pushMatrix();

        pointer++;
    }

    @Override
    public PoseStack.Pose pop() {
        m3stack.popMatrix();
        m4stack.popMatrix();

        pointer--;
        return pose;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public PoseStack.Pose removeLast() {
        return pop();
    }

    // ----- not impl yet below -----

    @Override
    public void addFirst(PoseStack.Pose pose) {

    }

    @Override
    public void addLast(PoseStack.Pose pose) {

    }

    @Override
    public boolean offerFirst(PoseStack.Pose pose) {
        return false;
    }

    @Override
    public boolean offerLast(PoseStack.Pose pose) {
        return false;
    }

    @Override
    public PoseStack.Pose removeFirst() {
        return null;
    }

    @Override
    public PoseStack.Pose pollFirst() {
        return null;
    }

    @Override
    public PoseStack.Pose pollLast() {
        return null;
    }

    @Override
    public PoseStack.Pose getFirst() {
        return null;
    }

    @Override
    public PoseStack.Pose peekFirst() {
        return null;
    }

    @Override
    public PoseStack.Pose peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(PoseStack.Pose pose) {
        return false;
    }

    @Override
    public boolean offer(PoseStack.Pose pose) {
        return false;
    }

    @Override
    public PoseStack.Pose remove() {
        return null;
    }

    @Override
    public PoseStack.Pose poll() {
        return null;
    }

    @Override
    public PoseStack.Pose element() {
        return null;
    }

    @Override
    public PoseStack.Pose peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends PoseStack.Pose> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<PoseStack.Pose> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @NotNull
    @Override
    public Iterator<PoseStack.Pose> descendingIterator() {
        return null;
    }
}
