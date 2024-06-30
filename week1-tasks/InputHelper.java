import java.util.Scanner;

public class InputHelper {
    private Scanner scanner = new Scanner(System.in);

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
