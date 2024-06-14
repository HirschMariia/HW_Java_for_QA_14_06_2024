import java.io.File;
import java.util.Scanner;

public class DeleteDirectory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory to delete: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if(directory.exists()){
            deleteDirectory(directory);
            System.out.println("Directory deleted successfully.");
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    public static void deleteDirectory(File directory){
        File[] files = directory.listFiles();

        if(files != null){
            for(File file : files){
                if(file.isDirectory()){
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }

        directory.delete();
    }
}

