package Application.SecondApplet;

import javax.swing.*;
import java.awt.*;

public class SecondAppletWindow extends JFrame {
    public SecondAppletWindow() {
        super("Second Applet");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Container contents = getContentPane();

        GridLayout gridLayout1 = new GridLayout(1,2,10,10);
        contents.setLayout(gridLayout1);
        GridLayout gridLayout2 = new GridLayout(6,2,10,10);

        String[] figureList = {"Rectangle", "Oval"};
        JLabel figureLabel = new JLabel("Figure");
        JSpinner figureSpinner = new JSpinner(new SpinnerListModel(figureList));
        JLabel startXLabel = new JLabel("Start X");
        JSpinner startXSpinner = new JSpinner(new SpinnerNumberModel(0,0,200,5));
        JLabel startYLabel = new JLabel("Start Y");
        JSpinner startYSpinner = new JSpinner(new SpinnerNumberModel(0,0,200,5));
        JLabel heightLabel = new JLabel("Height");
        JSpinner heightSpinner = new JSpinner(new SpinnerNumberModel(0,0,200,5));
        JLabel widthLabel = new JLabel("Width");
        JSpinner widthSpinner = new JSpinner(new SpinnerNumberModel(0,0,200,5));
        JButton drawButton = new JButton("Draw");
        JButton clearButton = new JButton("Clear");

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(gridLayout2);
        settingsPanel.add(figureLabel);
        settingsPanel.add(figureSpinner);
        settingsPanel.add(startXLabel);
        settingsPanel.add(startXSpinner);
        settingsPanel.add(startYLabel);
        settingsPanel.add(startYSpinner);
        settingsPanel.add(heightLabel);
        settingsPanel.add(heightSpinner);
        settingsPanel.add(widthLabel);
        settingsPanel.add(widthSpinner);
        settingsPanel.add(drawButton);
        settingsPanel.add(clearButton);
        settingsPanel.setMaximumSize(new Dimension(100, 100));
        settingsPanel.setSize(100, 100);
        contents.add(settingsPanel);

        JPanel canvasPanel = new JPanel();
        contents.add(canvasPanel);

        setContentPane(contents);
        pack();

        setSize(500,500);
        setResizable(false);

        setVisible(true);

    }
}
