package Application.FirstApplet;

import javax.sound.sampled.LineUnavailableException;

public class runnableSG implements Runnable {
    private int a;
    private int b;
    private int c;
    private boolean d;
    runnableSG(int a, int b, int c, boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public void run() {
        try {
            SoundGenerator.generateTone(a,b,c,d);
        } catch (LineUnavailableException e1) {
            e1.printStackTrace();
        }
    }
}
