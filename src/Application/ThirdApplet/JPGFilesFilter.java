package Application.ThirdApplet;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class JPGFilesFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) return true;
        return (f.getName().endsWith(".jpg"));
    }

    @Override
    public String getDescription() {
        return "Image files (*.jpg)";
    }
}
