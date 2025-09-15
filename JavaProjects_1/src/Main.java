import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte a = 5;
        byte b = 4;
        System.out.println(a + b);
        try (Scanner scanner = new Scanner(System.in)){
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(c + d);
        }
    }
}
