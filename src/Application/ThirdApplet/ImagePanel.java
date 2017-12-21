package Application.ThirdApplet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    ImagePanel(String filename) {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException ex) {
            // handle exception...
            ex.printStackTrace();
        }
    }

    public ImagePanel(File imageFile) {
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException ex) {
            // handle exception...
            ex.printStackTrace();
        }
    }

    public void setImage(File imageFile) {
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException ex) {
            // handle exception...
            ex.printStackTrace();
        }
        repaint();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }


}