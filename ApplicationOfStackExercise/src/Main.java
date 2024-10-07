import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.go();   
    }

    public void go() {
        
    	MatchBraces matchbraces = new MatchBraces();
        JFileChooser chooser = new JFileChooser();
        int returnval = chooser.showOpenDialog(null);

        if (returnval == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (Scanner scanner = new Scanner(file)) {
                matchbraces.check(scanner);
            } catch (Exception e) {
                System.out.println("File Reading Error: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}