import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }

        Cat cat = new Cat("gg",1);
        System.out.println(cat.getAge());

    }
}