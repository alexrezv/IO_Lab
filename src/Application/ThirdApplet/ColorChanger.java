package Application.ThirdApplet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorChanger {
    public static BufferedImage changeColor(BufferedImage image, Color srcColor, Color resultColor) {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if (image.getRGB(i, j) == srcColor.getRGB()) {
                    image.setRGB(i, j, resultColor.getRGB());
                }
            }
        }
        return image;
    }
}
