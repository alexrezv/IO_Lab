package Application.SecondApplet;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionListener;

public class SecondAppletWindow extends JFrame {
    public SecondAppletWindow() {
        super("Draw Shapes");
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
        JSpinner startXSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 5));
        JLabel startYLabel = new JLabel("Start Y");
        JSpinner startYSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 5));
        JLabel heightLabel = new JLabel("Height");
        JSpinner heightSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 5));
        JLabel widthLabel = new JLabel("Width");
        JSpinner widthSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 5));
        JButton drawButton = new JButton("Draw");
        JButton clearButton = new JButton("Clear");

        JToolBar controlsPanel = new JToolBar();
        controlsPanel.setBackground(Color.lightGray);
        GridLayout controlsPanelLayout = new GridLayout(7, 2, 0, 10);
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
        controlsPanel.setPreferredSize(new Dimension(250, 450));
        //controlsPanel.setMaximumSize(new Dimension(200,250));

        ShapesPanel shapesPanel = new ShapesPanel();
        shapesPanel.setBorder(new BorderUIResource.LineBorderUIResource(Color.black, 2));
        shapesPanel.setPreferredSize(new Dimension(500, 500));

        //adding elements to the main panel
        Container contents = getContentPane();
        GridLayout contentsLayout = new GridLayout(1, 2);
        contents.setLayout(contentsLayout);
        contents.add(shapesPanel);
        contents.add(controlsPanel);
        setContentPane(contents);
        pack();

        setSize(1000, 1000);
        //setResizable(false);

        setVisible(true);

        ActionListener controlsPanelListener = new ControlsPanelListener(figureSpinner, colorList,
                startXSpinner, startYSpinner, heightSpinner, widthSpinner, shapesPanel);
        drawButton.addActionListener(controlsPanelListener);
        clearButton.addActionListener(controlsPanelListener);

    }
}
