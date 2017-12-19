package Application.ThirdApplet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
                    imagePanel = new ImagePanel(fileChooser.getSelectedFile());
                    imagePanel.revalidate(); //ADD THIS AS WELL
                    imagePanel.repaint();  //ADD THIS AS WELL
                }

                break;
            case "Change color":
                System.err.println("change color" + srcColor.getColor().toString());

                break;
            case "Save file":
                System.err.println("save file");

                break;
            default:
                System.err.println("No action specified at ControlsPanelListener.actionPerformed()");
                break;
        }

    }
}
