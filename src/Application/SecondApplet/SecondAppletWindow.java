package Application.SecondApplet;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class SecondAppletWindow extends JFrame {
    public SecondAppletWindow() {
        super("Second Applet");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] figureList = {"Rectangle", "Oval"};
        JLabel figureLabel = new JLabel("Figure");
        JSpinner figureSpinner = new JSpinner(new SpinnerListModel(figureList));
        String[] colorsList = {"black", "blue", "cyan", "darkGray", "gray", "green", "lightGray", "magenta", "orange",
                "pink", "red", "white", "yellow"};
        JLabel colorLabel = new JLabel("Color");
        JScrollPane colorScrollPane = new JScrollPane();
        JList<String> colorList = new JList<>(colorsList);
        colorScrollPane.setViewportView(colorList);
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

        JPanel controlsPanel = new JPanel();
        controlsPanel.setBackground(Color.lightGray);
        GridLayout controlsPanelLayout = new GridLayout(7,2,10,10);
        controlsPanel.setLayout(controlsPanelLayout);
        controlsPanel.add(figureLabel);
        controlsPanel.add(figureSpinner);
        controlsPanel.add(colorLabel);
        controlsPanel.add(colorScrollPane);
        controlsPanel.add(startXLabel);
        controlsPanel.add(startXSpinner);
        controlsPanel.add(startYLabel);
        controlsPanel.add(startYSpinner);
        controlsPanel.add(heightLabel);
        controlsPanel.add(heightSpinner);
        controlsPanel.add(widthLabel);
        controlsPanel.add(widthSpinner);
        controlsPanel.add(drawButton);
        controlsPanel.add(clearButton);
        controlsPanel.setPreferredSize(new Dimension(200,300));


        JPanel canvasPanel = new JPanel();
        canvasPanel.setBackground(Color.white);
        canvasPanel.setBorder(new BorderUIResource.LineBorderUIResource(Color.black, 2));
        canvasPanel.setPreferredSize(new Dimension(500,500));

        //adding elements to the main panel
        Container contents = getContentPane();
        GridLayout contentsLayout = new GridLayout(1,2);
        contents.setLayout(contentsLayout);
        contents.add(controlsPanel);
        contents.add(canvasPanel);
        setContentPane(contents);
        pack();

        setSize(750,500);
        setResizable(false);

        setVisible(true);

    }
}
