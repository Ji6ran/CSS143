/**
 * Created by Jibran on 5/15/19.
 */
public class Driver {
    public static void main(String[] args) {
        int MAX_NUMBER_OF_FILES_TO_FIND = 4;

        String f = "Death Race For Love.zip";
        String path = "/Users/Jibran/Documents";

        FindFile find = new FindFile(MAX_NUMBER_OF_FILES_TO_FIND);

        try {
            find.directorySearch(f, path);
        }
        catch (FileException e) {
            System.out.println(find.toString());
        }
        catch(IllegalArgumentException d) {
            System.out.println("Error in passing arguments");
        }
    }
}
