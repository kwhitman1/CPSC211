import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public void displayDescription(String description) {
        System.out.println(description);
    }

    public void displayMenu(String[] options) {
        System.out.println("What would you like to do?");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ": " + options[i]);
        }
        System.out.println((options.length + 1) + ": Save Game");
    }

    public int getMenuChoice(int optionsCount) {
        while (true) {
            System.out.print("Type the number for the action you would like to take: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= optionsCount + 1) return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    public boolean promptForLoad() {
        System.out.print("Load a saved game? (y/n): ");
        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }
}

