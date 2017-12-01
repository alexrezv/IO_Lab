package Application.MainWindow;

import Application.FirstApplet.FirstAppletWindow;
import Application.SecondApplet.SecondAppletWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {

    private FirstAppletWindow faw;
    private SecondAppletWindow saw;

    ButtonsListener(FirstAppletWindow faw, SecondAppletWindow saw) {
        this.faw = faw;
        this.saw = saw;
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
                if (saw == null) {
                    saw = new SecondAppletWindow();
                } else {
                    System.err.println("There is a saw!!");
                    faw.setVisible(true);
                }
                break;
            case "Three":
                System.err.println("Key Three was clicked");
                break;
            default:
                System.err.println("No key? wtf");
        }

    }
}
