import sun.dc.path.PathException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputReader {
    private static final Throwable FileNotSelectedException = null;
    private Scanner sc1;
    private Scanner sc2;
    private File firstDocIn;
    private File secondDocIn;
    private String firstDocName;
    private String secondDocName;

    public InputReader() {
        sc1 = null;
        sc2 = null;
        firstDocIn = null;
        secondDocIn = null;
        firstDocName = new String();
        secondDocName = new String();
    }

    /**
     * Gets files and places them in the resources folder
     */
    public void getFiles() {
        try {
            JFileChooser fc = new JFileChooser();

            int returnVal = fc.showOpenDialog(null);
            firstDocIn = fc.getSelectedFile();
            if(returnVal == JFileChooser.CANCEL_OPTION ||
            returnVal == JFileChooser.ERROR_OPTION) {
                throw new FileNotSelectedException();
            }

            returnVal = fc.showOpenDialog(null);
            secondDocIn = fc.getSelectedFile();
            if(returnVal == JFileChooser.CANCEL_OPTION ||
                    returnVal == JFileChooser.ERROR_OPTION) {
                throw new FileNotSelectedException();
            }

            firstDocName = firstDocIn.toString();
            secondDocName = secondDocIn.toString();

            Path resourcesDir = Paths.get("/TextCompare/resources/");

            String path = resourcesDir.toString();
            path.concat(File.separator+firstDocName);
            firstDocIn = new File(path);

            String path2 = resourcesDir.toString();
            path2.concat(File.separator+secondDocName);
            secondDocIn = new File(path2);


        } catch (FileNotSelectedException fs) {
            System.err.print("No file was selected.")

        } catch (FileNotFoundException e) {
            System.err.print("Error finding file!\n");
            System.err.print("Please restart the program to try again.");
        } catch (PathException p) {
            System.err.print("Path to resources folder is invalid.");
            //unlikely this error will be thrown until the program
            //is completely finished and tested on a new device
        } catch (HeadlessException h) {
            System.err.print("Headless Exception... Look it up.")
        }
    }

}

    public boolean isEqual() {

    }

    class FileNotSelectedException extends Exception {
    public FileNotSelectedException() {
        super();
    }
}
}
