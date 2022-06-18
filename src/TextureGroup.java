import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public abstract class TextureGroup {
    public String typeName, path;

    public abstract void generateTextures();

    public void createColorInfo(Color[] colors) {
        try (FileWriter writer = new FileWriter(path + "color_info.txt", true)) {
            StringBuilder infoLine = new StringBuilder("Color info for material " + typeName + ": ");
            for (Color c : colors) {
                String RGBString = "[" + c.getRed() + " " + c.getGreen() + " " + c.getBlue() + "]";
                infoLine.append(RGBString);
                infoLine.append(", ");
            }
            infoLine.append("\r\n");
            writer.write(infoLine.toString());
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
