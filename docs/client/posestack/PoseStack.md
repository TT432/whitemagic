# PoseStack

---

PoseStack 的 push 性能主要受限于对象的新增。

类列表：

- [MixinPoseStack](/src/main/java/io/github/tt432/whitemagic/mixin/MixinPoseStack.java)
- [PoseStackDeque](/src/main/java/io/github/tt432/whitemagic/util/PoseStackDeque.java)

本工作通过修改 `PoseStack` 中 `poseStack` 的实现方式，换用 joml 库中自带的 `Matrix3fStack` 与 `Matrix4fStack`，减少了新增对象的开销，并减少了 GC 系统的压力。

[基准测试](/src/jmh/java/io/github/tt432/whitemagic/PoseStackDequeTest.java)结果：

| Benchmark               | Mode | Cnt | Score | Error  | Units |
|-------------------------|------|-----|-------|--------|-------|
| PoseStackDequeTest.modTest  | avgt |  25 | 19.013 | ±1.247 | ns/op |
| PoseStackDequeTest.vanillaTest | avgt |  25 | 38.984 | ±31.426| ns/op |
