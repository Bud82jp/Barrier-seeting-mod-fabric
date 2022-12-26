// Import the necessary classes
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

// Create a new block renderer class
public class BarrierBlockRenderer extends BlockEntityRenderer<BarrierBlockEntity> {

  // Override the render method
  @Override
  public void render(BarrierBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
    // Get the block and its model
    Block block = blockEntity.getCachedState().getBlock();
    BakedModel model = blockRenderManager.getModel(blockEntity.getCachedState());

    // Set the block's color and brightness
    float red = 1.0f;
    float green = 1.0f;
    float blue = 1.0f;
    int brightness = 15728880;

    // Render the block
    matrices.push();
    matrices.translate(0.5, 0.5, 0.5);
    matrices.scale(1.0f, -1.0f, -1.0f);
    matrices.translate(0.0, -1.0, 0.0);
    blockRenderManager.getModelRenderer().render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getSolid()), blockEntity.getCachedState(), model, red, green, blue, brightness);
    matrices.pop();
  }
}
