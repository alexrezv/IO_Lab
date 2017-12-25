package Application.FirstApplet;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FirstAppletButtonsListener implements ActionListener {

    private JSpinner hz;
    private JSpinner duration;
    private JSpinner volume;
    private JToggleButton ifHarmonic;

    private Thread soundGeneratorThread;

    FirstAppletButtonsListener(JSpinner hz, JSpinner duration, JSpinner volume, JToggleButton ifHarmonic) {
        this.hz = hz;
        this.duration = duration;
        this.volume = volume;
        this.ifHarmonic = ifHarmonic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Play":
                if (soundGeneratorThread != null && soundGeneratorThread.isAlive()) {
                    System.err.println("SoundGenerator is alive");
                } else {
                    System.err.println("SoundGenerator isn't alive, starting");
                    soundGeneratorThread = new Thread(() -> {
                        try {
                            SoundGenerator.generateTone((int) hz.getValue(),
                                    (int) duration.getValue(),
                                    (int) volume.getValue(),
                                    ifHarmonic.isSelected());
                        } catch (LineUnavailableException e1) {
                            e1.printStackTrace();
                        }
                        System.err.println("SoundGenerator stopped");
                    });
                    soundGeneratorThread.start();
                    System.err.println("PLay command");
                }
                break;
            case "Stop":
                if (soundGeneratorThread != null && soundGeneratorThread.isAlive()) {
                    System.err.println("SoundGenerator is alive, try to stop");
                    while (soundGeneratorThread.isAlive()) {
                        soundGeneratorThread.interrupt();
                    }
                }
                break;
            default:
                System.err.println(e.getActionCommand());
        }

    }
}
