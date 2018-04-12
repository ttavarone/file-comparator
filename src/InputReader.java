
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
        firstDocName = "";
        secondDocName = "";
    }

    /**
     * Gets files and places them in the resources folder
     */
    private void getFiles() {
        try {
            JFileChooser fc = new JFileChooser();

            int returnVal = fc.showOpenDialog(null);
            firstDocIn = fc.getSelectedFile();
            if (returnVal == JFileChooser.CANCEL_OPTION ||
                    returnVal == JFileChooser.ERROR_OPTION) {
                throw new FileNotSelectedException();
            }

            returnVal = fc.showOpenDialog(null);
            secondDocIn = fc.getSelectedFile();
            if (returnVal == JFileChooser.CANCEL_OPTION ||
                    returnVal == JFileChooser.ERROR_OPTION) {
                throw new FileNotSelectedException();
            }

            firstDocName = firstDocIn.toString();
            secondDocName = secondDocIn.toString();

        } catch (FileNotSelectedException fs) {
            System.err.print("No file was selected.");
        } catch (HeadlessException h) {
            System.err.print("Headless Exception... Look it up.");
        }
    }

    private void getFileInfo(File in, Scanner sc){
        int wordCount = 0;
        int lineCount = 0;
        int charCount = 0;

        while(sc.hasNext()){
            wordCount++;
            sc.next();
        }

        while(sc.hasNextLine()){
            lineCount++;
            sc.nextLine();
        }

        while(sc.hasNextByte()){
            charCount++;
            sc.nextByte();
        }
    }

    public boolean isEqual() {
        try {

            sc1 = new Scanner(firstDocIn);


        } catch (FileNotFoundException e) {
            System.err.print("Input file is not available.");
        }
        return false;
    }

    class FileNotSelectedException extends Exception {
        private FileNotSelectedException() {
            super();
        }
    }
}
