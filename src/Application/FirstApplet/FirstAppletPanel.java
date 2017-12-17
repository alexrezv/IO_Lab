package Application.FirstApplet;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;

public final class FirstAppletPanel extends JPanel {

    public FirstAppletPanel() {
        add(new InnerPanel());

        setVisible(true);
    }

    private class InnerPanel extends JPanel {
        InnerPanel() {
            GridLayout gridLayout = new GridLayout(5, 2, 10, 10);
            setLayout(gridLayout);

            //frequency controls
            JLabel freqLabel = new JLabel("Base frequency");
            JSpinner freqSpinner = new JSpinner(new SpinnerNumberModel(1000, 1, 24000, 100));
            add(freqLabel);
            add(freqSpinner);

            //duration controls
            JLabel durationLabel = new JLabel("Duration (msec)");
            JSpinner durationSpinner = new JSpinner(new SpinnerNumberModel(1000, 500, 10000, 100));
            add(durationLabel);
            add(durationSpinner);

            //volume controls
            JLabel volLabel = new JLabel("Volume (0-100)");
            JSpinner volSpinner = new JSpinner(new SpinnerNumberModel(50, 0, 100, 1));
            add(volLabel);
            add(volSpinner);

            //harmonic controls
            JLabel harmonicLabel = new JLabel("Add harmonic?");
            add(harmonicLabel);
            JPanel harmonicPanel = new JPanel(new GridLayout(1, 2, 10, 10));
            ButtonGroup harmonicButtonGroup = new ButtonGroup();

            JToggleButton yesHarmonicBtn = new JToggleButton("Yes");
            yesHarmonicBtn.setName("yes");
            harmonicPanel.add(yesHarmonicBtn);
            harmonicButtonGroup.add(yesHarmonicBtn);

            JToggleButton noHarmonicBtn = new JToggleButton("No");
            yesHarmonicBtn.setName("no");
            harmonicPanel.add(noHarmonicBtn);
            harmonicButtonGroup.add(noHarmonicBtn);

            add(harmonicPanel);

            //playback controls
            JButton playBtn = new JButton("Play");
            playBtn.setName("play");
            JButton stopBtn = new JButton("Stop");
            stopBtn.setName("stop");

            Thread soundGeneratorThread = new Thread(() -> {
                try {
                    SoundGenerator.generateTone((int) freqSpinner.getValue(),
                            (int) durationSpinner.getValue(),
                            (int) volSpinner.getValue(),
                            yesHarmonicBtn.isSelected());
                } catch (LineUnavailableException e1) {
                    e1.printStackTrace();
                }
                System.err.println("sg stopped");
            });

            FirstAppletButtonsListener fabl = new FirstAppletButtonsListener(soundGeneratorThread);
            playBtn.addActionListener(fabl);
            stopBtn.addActionListener(fabl);

            add(playBtn);
            add(stopBtn);
            setMaximumSize(new Dimension(200,200));
        }
    }
}
