package Application.MainWindow;

import Application.FirstApplet.FirstAppletWindow;

import javax.swing.*;

import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        super("I/O Lab");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setIconImage();

        //frame decoration
        //setDefaultLookAndFeelDecorated(true);
        //getRootPane().setWindowDecorationStyle(FRAME);

        Container contents = getContentPane();
        GridLayout gridLayout = new GridLayout(3,1,10,10);
        contents.setLayout(gridLayout);

        JButton bOne = new JButton("Sound Generator");
        JButton bTwo = new JButton("Two");
        JButton bThree = new JButton("Three");

        FirstAppletWindow faw = null;

        ButtonsListener buttonsListener = new ButtonsListener(bOne, faw);

        bOne.addActionListener(buttonsListener);
        bTwo.addActionListener(buttonsListener);
        bThree.addActionListener(buttonsListener);

        contents.add(bOne);
        contents.add(bTwo);
        contents.add(bThree);

        setContentPane(contents);
        pack();

        setSize(200,250);
        setMinimumSize(new Dimension(150, 200));
        setMaximizedBounds(new Rectangle(250, 300));

        setVisible(true);
    }
}
