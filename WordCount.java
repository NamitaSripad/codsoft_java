import java.util.Scanner;
import java.io.File;

public class WordCount {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text or file path: ");// for file path drag and drop any java file in this folder for easy input
            String input = scanner.nextLine();
            String content = "";

            if (input.length() > 0) {
                try {
                    if (new File(input).exists()) {
                        content = new String(java.nio.file.Files.readAllBytes(new File(input).toPath()));
                    } else {
                        content = input;
                    }
                } catch (Exception e) {
                    System.out.println("Error reading file. Please try again.");
                    return;
                }

                String[] words = content.split("[\\s,;.!?]+");
                int count = 0;

                for (String word : words) {
                    if (!word.isEmpty()) {
                        count++;
                    }
                }

                System.out.println("Total word count: " + count);
            } else {
                System.out.println("Invalid input!!! Please try again.");
            }
        }
    }
}
