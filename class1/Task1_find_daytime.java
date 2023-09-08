import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Task1_find_daytime {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        if (hour >= 5 && hour < 12) {
            System.out.printf("Good morning, %s\n", name);
        } else if (hour >= 12 && hour < 18) {
            System.out.printf("Good afternoon, %s\n", name);
        } else if (hour >= 18 && hour < 23) {
            System.out.printf("Good evening, %s\n", name);
        } else {
            System.out.printf("Good night, %s\n", name);
        }
    }
}