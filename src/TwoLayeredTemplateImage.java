import java.awt.*;

public class TwoLayeredTemplateImage extends Image {
    private final SingleTemplateImage bottomLayer;
    private final SingleTemplateImage topLayer;

    public TwoLayeredTemplateImage(String bottomTemplatePath, String topTemplatePath, Color bottomLayerInputRGB, Color topLayerInputRGB) {
        super(16, 16);
        bottomLayer = new SingleTemplateImage(bottomTemplatePath, bottomLayerInputRGB);
        topLayer = new SingleTemplateImage(topTemplatePath, topLayerInputRGB);
    }

    public void combine() {
        bottomLayer.iterateBottomTemplate();
        topLayer.iterateBottomTemplate();
        Graphics graphics = img.getGraphics();
        graphics.drawImage(bottomLayer.getBufferedImage(), 0, 0, null);
        graphics.drawImage(topLayer.getBufferedImage(), 0, 0, null);
        graphics.dispose();
    }
}
