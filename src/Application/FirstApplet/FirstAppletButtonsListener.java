package Application.FirstApplet;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstAppletButtonsListener implements ActionListener {

    private Thread soundGeneratorThread;

    FirstAppletButtonsListener(Thread soundGeneratorThread) {
        this.soundGeneratorThread = soundGeneratorThread;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Создание потока
        //Этот метод будет выполняться в побочном потоке

        if (soundGeneratorThread.isAlive()) {
            System.err.println("sg is alive");
        } else {
            System.err.println("sg isn't alive");
        }

        switch (e.getActionCommand()) {
            case "Play":
                soundGeneratorThread.start();
                System.err.println("PLay command");
                break;
            case "Stop":
                System.err.println("Stop command");
                soundGeneratorThread.stop();
                break;
            default:
                System.err.println(e.getActionCommand());
        }

    }
}
