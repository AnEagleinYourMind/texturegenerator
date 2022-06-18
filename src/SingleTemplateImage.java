import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class SingleTemplateImage extends Image {
    BufferedImage bottomTemplate;
    Color inputRGB;

    public SingleTemplateImage(String path, Color inputRGB) {
        super(16, 16);
        this.inputRGB = inputRGB;

        try (InputStream templateFile = this.getClass().getClassLoader().getResourceAsStream(path)) {
            if (templateFile != null) {
                bottomTemplate = ImageIO.read(templateFile);
            }
        } catch (IOException | NullPointerException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void iterateBottomTemplate() {
        for (int i = 0; i <= height - 1; i++) {
            for (int j = 0; j <= width - 1; j++) {
                int[] bottomTemplateARGB = getARGB(bottomTemplate.getRGB(i, j));
                int[] newARGB = blend(bottomTemplateARGB, inputRGB);
                int newHex = (newARGB[0] << 24) | (newARGB[1] << 16) | (newARGB[2] << 8) | newARGB[3];
                img.setRGB(i, j, newHex);
            }
        }
    }
}
