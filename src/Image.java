import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

public class Image {
    int height;
    int width;
    BufferedImage img;

    public Image(int height, int width) {
        this.height = height;
        this.width = width;
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    protected int[] getARGB(int x) {
        int[] rgb = new int[4];
        rgb[0] = (x >> 24) & 0xff;  // alpha
        rgb[1] = (x >> 16) & 0xff;  // red
        rgb[2] = (x >> 8) & 0xff;   // green
        rgb[3] = x & 0xff;          // blue
        return rgb;
    }

    protected int[] blend(int[] originalPixelRGB, Color inputColor) {
        int[] newARGB = {
                originalPixelRGB[0], // sets the alpha to whatever the alpha of the template pixel is
                inputColor.getRed() + originalPixelRGB[1] / 2, // red
                inputColor.getGreen() + originalPixelRGB[2] / 2, // green
                inputColor.getBlue() + originalPixelRGB[3] / 2  // blue
                // simply calculates the average
        };
        if (newARGB[1] > 255) { newARGB[1] = 255;}
        if (newARGB[2] > 255) { newARGB[2] = 255;}
        if (newARGB[3] > 255) { newARGB[3] = 255;} //if it's more than 255 just clamp it
        return newARGB;
        // so yeah pretty sketchy
    }

    public BufferedImage getBufferedImage() {
        return img;
    }

    public void save(String path, String fileName) {
        try (FileOutputStream finalImage = new FileOutputStream(path + fileName + ".png")) {
            ImageIO.write(this.img, "png", finalImage);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
