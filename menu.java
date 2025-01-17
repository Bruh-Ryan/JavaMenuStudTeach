import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        System.out.println("Hi, welcome to the Student and Teacher DBMS!");
        Scanner in = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nMain Menu: \n1. Student Menu \n 2. Teacher Menu \n3. Exit");
            System.out.print("Enter your choice: ");

            int option = in.nextInt();

            switch (option) {
                case 1:
                    Student i = new Student();
                    System.out.println("\nyou chose student");
                    i.studentMainMenu(); // Call Student's menu logic
                    break;

                case 2:
                    Teacher j = new Teacher();
                    System.out.println("\nyou chose teacher");
                    j.teacherMainMenu(); // Call Teacher's menu logic
                    break;

                case 3:
                    System.out.println("Exiting the application");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        in.close();
    }
}