import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {
    private Scanner sc1;
    private Scanner sc2;
    private File firstDocIn;
    private File secondDocIn;

    public InputReader() {
        sc1 = null;
        sc2 = null;
        firstDocIn = null;
        secondDocIn = null;
    }

    public void getFiles() {
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);

        firstDocIn = fc.getSelectedFile();
        secondDocIn = fc.getSelectedFile();
    }

    public boolean isEqual() {

    }
}
