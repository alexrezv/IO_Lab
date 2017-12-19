package Application.ThirdApplet;

import javax.swing.*;
import java.awt.*;

public class ThirdAppletPanel extends JPanel {
    public ThirdAppletPanel() {
        JColorChooser srcColor = new JColorChooser();
        srcColor.setPreviewPanel(new JPanel());
        JColorChooser resultColor = new JColorChooser();
        resultColor.setPreviewPanel(new JPanel());

        JButton openFileBtn = new JButton("Open file");
        openFileBtn.setPreferredSize(new Dimension(100,50));
        JButton changeColorBtn = new JButton("Change color");
        changeColorBtn.setPreferredSize(new Dimension(200,50));
        JButton saveFileBtn = new JButton("Save file");
        saveFileBtn.setPreferredSize(new Dimension(100,50));

        JToolBar jtb = new JToolBar();
        jtb.setBackground(Color.lightGray);
        jtb.setLayout(new GridBagLayout());
        GridBagConstraints jtbC = new GridBagConstraints();
        jtbC.weightx = 0.1;
        jtbC.weighty = 0.5;
        jtbC.gridx = 0;
        jtbC.gridy = 0;
        jtb.add(openFileBtn, jtbC);
        jtbC.weightx = 0.3;
        jtbC.weighty = 0.5;
        jtbC.gridx = 0;
        jtbC.gridy = 1;
        jtb.add(srcColor, jtbC);
        jtbC.weightx = 0.3;
        jtbC.weighty = 0.5;
        jtbC.gridx = 0;
        jtbC.gridy = 2;
        jtb.add(resultColor, jtbC);
        //jtbC.fill = 2;
        jtbC.weightx = 0.1;
        jtbC.weighty = 0.5;
        jtbC.gridx = 0;
        jtbC.gridy = 3;
        jtb.add(changeColorBtn, jtbC);
        jtbC.weightx = 0.1;
        jtbC.weighty = 0.5;
        jtbC.gridx = 0;
        jtbC.gridy = 4;
        jtb.add(saveFileBtn, jtbC);
        jtb.setFloatable(false);
        //jtb.setPreferredSize(new Dimension(500,400));

        ImagePanel imagePanel =  new ImagePanel("./data/java_logo.jpg");
        imagePanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        imagePanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        //picLabel.setIcon(new ImageIcon("./data/java_logo.jpg"));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.05;
        c.weighty = 0.7;
        c.gridx = 0;
        c.gridy = 0;
        add(jtb, c);
        c.weightx = 0.95;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        add(imagePanel, c);

        ThirdPanelListener tpl = new ThirdPanelListener(srcColor, resultColor, imagePanel);
        openFileBtn.addActionListener(tpl);
        changeColorBtn.addActionListener(tpl);
        saveFileBtn.addActionListener(tpl);
    }
}
