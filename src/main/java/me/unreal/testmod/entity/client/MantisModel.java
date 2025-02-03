package me.unreal.testmod.entity.client;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.entity.custom.MantisEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class MantisModel<T extends MantisEntity> extends EntityModelLayers {

    public static final EntityModelLayer MANTIS = new EntityModelLayer(Identifier.of(TestMod.MOD_ID, "mantis"), "main");



    private final ModelPart root;
    private final ModelPart mantis;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart antenna1;
    private final ModelPart antenna2;
    private final ModelPart mouth1;
    private final ModelPart mouth2;
    private final ModelPart wing1;
    private final ModelPart wing2;
    private final ModelPart wing3;
    private final ModelPart wing4;
    private final ModelPart arm1;
    private final ModelPart arm1seg2;
    private final ModelPart arm1seg3;
    private final ModelPart arm2;
    private final ModelPart arm2seg2;
    private final ModelPart arm2seg3;
    private final ModelPart frontLeg1;
    private final ModelPart frontLeg1seg2;
    private final ModelPart frontLeg1seg3;
    private final ModelPart frontLeg2;
    private final ModelPart frontLeg2seg2;
    private final ModelPart frontLeg2seg3;
    private final ModelPart backLeg1;
    private final ModelPart backLeg1seg2;
    private final ModelPart backLeg1seg3;
    private final ModelPart backLeg2;
    private final ModelPart backLeg2seg2;
    private final ModelPart backLeg2seg3;

    public MantisModel(ModelPart part, Function<Identifier, RenderLayer> layerFactory, ModelPart root, ModelPart mantis,
                       ModelPart body, ModelPart head, ModelPart antenna1, ModelPart antenna2, ModelPart mouth1,
                       ModelPart mouth2, ModelPart wing1, ModelPart wing2, ModelPart wing3, ModelPart wing4,
                       ModelPart arm1, ModelPart arm1seg2, ModelPart arm1seg3, ModelPart arm2, ModelPart arm2seg2,
                       ModelPart arm2seg3, ModelPart frontLeg1, ModelPart frontLeg1seg2, ModelPart frontLeg1seg3,
                       ModelPart frontLeg2, ModelPart frontLeg2seg2, ModelPart frontLeg2seg3, ModelPart backLeg1,
                       ModelPart backLeg1seg2, ModelPart backLeg1seg3, ModelPart backLeg2, ModelPart backLeg2seg2,
                       ModelPart backLeg2seg3) {
        super(root, layerFactory);
        this.root = root.getChild("root");
        this.mantis = root.getChild("mantis");
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.antenna1 = root.getChild("antenna1");
        this.antenna2 = root.getChild("antenna2");
        this.mouth1 = root.getChild("mouth1");
        this.mouth2 = root.getChild("mouth2");
        this.wing1 = root.getChild("wing1");
        this.wing2 = root.getChild("wing2");
        this.wing3 = root.getChild("wing3");
        this.wing4 = root.getChild("wing4");
        this.arm1 = root.getChild("arm1");
        this.arm1seg2 = root.getChild("arm1seg2");
        this.arm1seg3 = root.getChild("arm1seg3");
        this.arm2 = root.getChild("arm2");
        this.arm2seg2 = root.getChild("arm2seg2");
        this.arm2seg3 = root.getChild("arm2seg3");
        this.frontLeg1 = root.getChild("frontLeg1");
        this.frontLeg1seg2 = root.getChild("frontLeg1seg2");
        this.frontLeg1seg3 = root.getChild("frontLeg1seg3");
        this.frontLeg2 = root.getChild("frontLeg2");
        this.frontLeg2seg2 = root.getChild("frontLeg2seg2");
        this.frontLeg2seg3 = root.getChild("frontLeg2seg3");
        this.backLeg1 = root.getChild("backLeg1");
        this.backLeg1seg2 = root.getChild("backLeg1seg2");
        this.backLeg1seg3 = root.getChild("backLeg1seg3");
        this.backLeg2 = root.getChild("backLeg2");
        this.backLeg2seg2 = root.getChild("backLeg2seg2");
        this.backLeg2seg3 = root.getChild("backLeg2seg3");
    }



    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData mantis = root.addChild("mantis", ModelPartBuilder.create(), ModelTransform.of(-0.5F, -3.0F, -28.0F, 0.3927F, 0.0F, 0.0F));

        ModelPartData body = mantis.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -1.0F, 8.75F, 5.0F, 2.0F, 25.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-3.5F, -2.0F, -51.25F, 7.0F, 4.0F, 60.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 26.25F));

        ModelPartData head = mantis.addChild("head", ModelPartBuilder.create().uv(31, 27).cuboid(-3.5F, -1.0F, 0.0F, 7.0F, 4.0F, 3.0F, new Dilation(0.0F))
                .uv(35, 20).cuboid(-2.5F, 3.0F, 0.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -13.0F, 60.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData antenna1 = head.addChild("antenna1", ModelPartBuilder.create().uv(56, 71).cuboid(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, -1.0F, 3.0F, 0.4363F, 0.0F, 0.0F));

        ModelPartData antenna2 = head.addChild("antenna2", ModelPartBuilder.create().uv(56, 71).cuboid(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -1.0F, 3.0F, 0.4363F, 0.0F, 0.0F));

        ModelPartData mouth1 = head.addChild("mouth1", ModelPartBuilder.create().uv(14, 0).cuboid(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, 5.0F, 1.0F));

        ModelPartData mouth2 = head.addChild("mouth2", ModelPartBuilder.create().uv(6, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, 5.0F, 1.0F));

        ModelPartData wing1 = mantis.addChild("wing1", ModelPartBuilder.create().uv(56, 0).cuboid(-3.5F, 0.0F, -60.0F, 7.0F, 0.0F, 60.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -14.04F, 35.0F));

        ModelPartData wing2 = mantis.addChild("wing2", ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-3.5F, 0.0F, -60.0F, 7.0F, 0.0F, 60.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -14.03F, 35.0F));

        ModelPartData wing3 = mantis.addChild("wing3", ModelPartBuilder.create().uv(28, 0).cuboid(-3.5F, 0.0F, -60.0F, 7.0F, 0.0F, 60.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -14.02F, 35.0F));

        ModelPartData wing4 = mantis.addChild("wing4", ModelPartBuilder.create().uv(28, 0).mirrored().cuboid(-3.5F, 0.0F, -60.0F, 7.0F, 0.0F, 60.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -14.01F, 35.0F));

        ModelPartData arm1 = mantis.addChild("arm1", ModelPartBuilder.create().uv(8, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 20.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, -11.0F, 51.0F));

        ModelPartData arm1seg2 = arm1.addChild("arm1seg2", ModelPartBuilder.create().uv(0, 64).cuboid(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 25.0F, new Dilation(0.0F))
                .uv(31, 62).cuboid(0.0F, 1.5F, -2.0F, 0.0F, 6.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 19.5F, 0.0F));

        ModelPartData arm1seg3 = arm1seg2.addChild("arm1seg3", ModelPartBuilder.create().uv(10, 27).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 20.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 24).cuboid(0.0F, 0.0F, -3.5F, 0.0F, 20.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, 21.5F));

        ModelPartData arm2 = mantis.addChild("arm2", ModelPartBuilder.create().uv(8, 0).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 20.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.5F, -11.0F, 51.0F));

        ModelPartData arm2seg2 = arm2.addChild("arm2seg2", ModelPartBuilder.create().uv(0, 64).mirrored().cuboid(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 25.0F, new Dilation(0.0F)).mirrored(false)
                .uv(31, 62).cuboid(0.0F, 1.5F, -2.0F, 0.0F, 6.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 19.5F, 0.0F));

        ModelPartData arm2seg3 = arm2seg2.addChild("arm2seg3", ModelPartBuilder.create().uv(10, 27).mirrored().cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 20.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(0, 25).cuboid(0.0F, 0.0F, -3.5F, 0.0F, 20.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, 21.5F));

        ModelPartData frontLeg1 = mantis.addChild("frontLeg1", ModelPartBuilder.create().uv(39, 34).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.5F, -10.0F, 27.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData frontLeg1seg2 = frontLeg1.addChild("frontLeg1seg2", ModelPartBuilder.create().uv(54, 94).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 18.0F, new Dilation(0.0F))
                .uv(36, 76).cuboid(0.0F, 0.5F, 0.0F, 0.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.5F, 0.0F, 0.3927F, -0.4363F, 0.0F));

        ModelPartData frontLeg1seg3 = frontLeg1seg2.addChild("frontLeg1seg3", ModelPartBuilder.create().uv(18, 27).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 18.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, 17.5F, 0.2618F, 0.0F, 0.0F));

        ModelPartData frontLeg2 = mantis.addChild("frontLeg2", ModelPartBuilder.create().uv(39, 34).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.5F, -10.0F, 27.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData frontLeg2seg2 = frontLeg2.addChild("frontLeg2seg2", ModelPartBuilder.create().uv(54, 94).mirrored().cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 18.0F, new Dilation(0.0F)).mirrored(false)
                .uv(36, 76).cuboid(0.0F, 0.5F, 0.0F, 0.0F, 5.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.5F, 0.0F, 0.3927F, 0.4363F, 0.0F));

        ModelPartData frontLeg2seg3 = frontLeg2seg2.addChild("frontLeg2seg3", ModelPartBuilder.create().uv(18, 27).mirrored().cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 18.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.5F, 17.5F, 0.2618F, 0.0F, 0.0F));

        ModelPartData backLeg1 = mantis.addChild("backLeg1", ModelPartBuilder.create().uv(35, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.5F, -10.0F, 20.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData backLeg1seg2 = backLeg1.addChild("backLeg1seg2", ModelPartBuilder.create().uv(83, 65).cuboid(-0.5F, -0.5F, -25.0F, 1.0F, 1.0F, 25.0F, new Dilation(0.0F))
                .uv(31, 45).cuboid(0.0F, 0.5F, -25.0F, 0.0F, 6.0F, 25.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.5F, 0.0F, 0.0F, 0.4363F, 0.5236F));

        ModelPartData backLeg1seg3 = backLeg1seg2.addChild("backLeg1seg3", ModelPartBuilder.create().uv(4, 97).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 35.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -24.5F));

        ModelPartData backLeg2 = mantis.addChild("backLeg2", ModelPartBuilder.create().uv(35, 0).mirrored().cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.5F, -10.0F, 20.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData backLeg2seg2 = backLeg2.addChild("backLeg2seg2", ModelPartBuilder.create().uv(83, 65).mirrored().cuboid(-0.5F, -0.5F, -25.0F, 1.0F, 1.0F, 25.0F, new Dilation(0.0F)).mirrored(false)
                .uv(31, 45).cuboid(0.0F, 0.5F, -25.0F, 0.0F, 6.0F, 25.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.5F, 0.0F, 0.0F, -0.4363F, -0.5236F));

        ModelPartData backLeg2seg3 = backLeg2seg2.addChild("backLeg2seg3", ModelPartBuilder.create().uv(4, 97).mirrored().cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 35.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.5F, -24.5F));
        return TexturedModelData.of(modelData, 256, 256);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay);
    }

}
