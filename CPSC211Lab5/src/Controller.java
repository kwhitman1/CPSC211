
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final View view;
    
    public Controller(View view) {
        this.view = view;
    }

    public void start() {
        view.show();

        
        File directory = view.selectDirectory();

        if (directory == null) {
            view.displayError("No directory selected. Please select a directory to proceed.");
            return;
        }

        
        List<String> results = new ArrayList<>();
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            view.displayError("No .txt files found in the selected directory.");
            return;
        }

        for (File file : files) {
            try {
                String result = processFile(file);
                results.add(file.getName() + ": " + result);
            } catch (IOException e) {
                results.add(file.getName() + ": Error processing file");
            }
        }

        view.displayResults(results);
    }

    private String processFile(File file) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(file.getPath()));
        Model model = Model.fromInputData(lines);

        return model.isSolvable() ? "Solvable" : "Not Solvable";
    }
}

