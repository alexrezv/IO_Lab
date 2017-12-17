package Application.MainWindow;

import Application.FirstApplet.FirstAppletPanel;
import Application.SecondApplet.SecondAppletPanel;
import Application.ThirdApplet.ThirdAppletPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        super("I/O Lab");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane mainPane = new JTabbedPane(
                JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

        JPanel soundGeneratorTab = new FirstAppletPanel();
        mainPane.addTab("Sound Generator", soundGeneratorTab);

        JPanel drawShapesTab = new SecondAppletPanel();
        mainPane.addTab("Draw Shapes", drawShapesTab);

        JPanel changeColorsTab = new ThirdAppletPanel();
        mainPane.addTab("Change Colors", changeColorsTab);

        getContentPane().setLayout(new GridLayout());
        getContentPane().add(mainPane);
        setMinimumSize(new Dimension(300, 250));
        setSize(300, 250);
        setVisible(true);
    }
}
