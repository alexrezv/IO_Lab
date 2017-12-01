package Application.MainWindow;

import Application.FirstApplet.FirstAppletWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {

    private JButton bOne;
    private FirstAppletWindow faw;

    ButtonsListener(JButton bOne, FirstAppletWindow faw) {
        this.bOne = bOne;
        this.faw = faw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Sound Generator":
                System.err.println("Key One was clicked");
                if (faw == null) {
                    faw = new FirstAppletWindow();
                } else {
                    System.err.println("There is a faw!!");
                    faw.setVisible(true);
                }
                break;
            case "Two":
                System.err.println("Key Two was clicked");
                break;
            case "Three":
                System.err.println("Key Three was clicked");
                break;
            default:
                System.err.println("No key? wtf");
        }

    }
}
