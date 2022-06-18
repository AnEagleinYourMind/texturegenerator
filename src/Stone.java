import java.awt.*;

public class Stone extends TextureGroup {
    private final Color color;

    public Stone(String name, String path, Color color) {
        typeName = name;
        this.path = path;
        this.color = color;
    }

    public void generateTextures() {
        SingleTemplateImage bricks = new SingleTemplateImage("bricks.png", color);
        bricks.iterateBottomTemplate();
        bricks.save(path, typeName + "_bricks");

        SingleTemplateImage cobblestone = new SingleTemplateImage("cobblestone.png", color);
        cobblestone.iterateBottomTemplate();
        cobblestone.save(path, typeName + "_cobblestone");

        SingleTemplateImage gravel = new SingleTemplateImage("gravel.png", color);
        gravel.iterateBottomTemplate();
        gravel.save(path, typeName + "_gravel");

        // make a rock item and misc items like gregory technologies
    }
}
