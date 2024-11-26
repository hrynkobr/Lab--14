import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileScan {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(new File("src"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            inspectFile(selectedFile);
        } else {
            System.out.println("No file chosen.");
        }
    }

    private static void inspectFile(File file) {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // Echo the line
                lineCount++;
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
            }
            printSummary(file.getName(), lineCount, wordCount, charCount);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
        }
    }

    private static void printSummary(String fileName, int lines, int words, int characters) {
        System.out.println("\nSummary Report:");
        System.out.println("File Name: " + fileName);
        System.out.println("Number of Lines: " + lines);
        System.out.println("Number of Words: " + words);
        System.out.println("Number of Characters: " + characters);
    }
}
