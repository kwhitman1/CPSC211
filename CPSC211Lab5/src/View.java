
import javax.swing.*;
import java.io.File;
import java.util.List;

public class View {
    private JFrame frame;

    public View() {
        frame = new JFrame("Robot Board Solvability Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
    }

    public File selectDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt"));
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public void displayResults(List<String> results) {
        StringBuilder message = new StringBuilder("Results:\n\n");
        for (String result : results) {
            message.append(result).append("\n");
        }
        JOptionPane.showMessageDialog(frame, message.toString(), "Solvability Results", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void show() {
        frame.setVisible(true);
    }
}

