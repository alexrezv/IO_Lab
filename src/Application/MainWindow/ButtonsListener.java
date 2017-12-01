package Application.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Application.FirstApplet.FirstAppletWindow.getFirstAppletInstance;

public class ButtonsListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "One":
                System.err.println("Key One was clicked");
                getFirstAppletInstance();
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
