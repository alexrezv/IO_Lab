package Application.ThirdApplet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ThirdPanelListener implements ActionListener {

    private JColorChooser srcColor;
    private JColorChooser resultColor;
    private ImagePanel imagePanel;

    ThirdPanelListener(JColorChooser srcColor, JColorChooser resultColor, ImagePanel imagePanel) {
        this.srcColor = srcColor;
        this.resultColor = resultColor;
        this.imagePanel = imagePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Open file":
                System.err.println("open file");
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose a picture to edit");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.addChoosableFileFilter(new JPGFilesFilter());
                int res = fileChooser.showOpenDialog(new JFrame());
                if (res == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fileChooser.getSelectedFile().getName());
                    imagePanel.setImage(fileChooser.getSelectedFile());
                }

                break;
            case "Change color":
                //System.err.println("change color" + srcColor.getColor().getRGB());
                BufferedImage newImage = ColorChanger.changeColor(imagePanel.getImage(), srcColor.getColor(), resultColor.getColor());
                imagePanel.setImage(newImage);

                break;
            case "Save file":
                System.err.println("save file");
                File savedImage = new File("./savedImage.png");
                try {
                    ImageIO.write(imagePanel.getImage(), "png", savedImage);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                break;
            default:
                System.err.println("No action specified at ControlsPanelListener.actionPerformed()");
                break;
        }

    }
}
