/**
 * Created by Jibran on 5/15/19.
 */
import java.io.*;

public class FindFile {

    private int count;
    private String[] files;
    private int max;

    public FindFile(int maxFiles) {
        this.max = maxFiles;
        this.files = new String[maxFiles];
        this.count = 0;
    }

    public void directorySearch(String name, String dirName) {
        File file = new File(dirName);

        if (!(file.exists())) {
            throw new IllegalArgumentException();
        }
        File[] numFiles = new File(dirName).listFiles();
        for(File fil : numFiles) {
            if (fil.getName().equals(name)) {
                files[count] = file.getAbsolutePath();
                this.count++;
            }
            else if (this.count == this.max) {

                throw new FileException();
            }
            else if (fil.isDirectory() == true) {

                directorySearch(name,fil.getAbsolutePath());
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    public String[] getFiles() {
        return this.files;
    }

    public int getMax() {
        return this.max;
    }

    public String toString() {
        String check = "";
        if (this.getCount() != 0) {
            for (int i = 0; i < this.getFiles().length; i++) {
                check = "\n " + this.getFiles()[i];
            }
        }
        else {
            check = "No file found";
        }

        return check;
    }
}
