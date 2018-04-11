import sun.dc.path.PathException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        try {
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);

            firstDocIn = fc.getSelectedFile();
            secondDocIn = fc.getSelectedFile();

            String firstDocName = firstDocIn.toString();
            String secondDocName = secondDocIn.toString();

            Path resourcesDir = Paths.get("/TextCompare/resources/");

        }catch(FileNotFoundException e) {
            System.err.print("Error finding file!\n");
            System.err.print("Please restart the program to try again.");
        }
        catch(PathException p) {
            System.err.print("Path to resources folder is invalid.");
            //unlikely this error will be thrown until the program
            //is completely finished and tested on a new machine
        }
    }

    public boolean isEqual() {

    }
}
