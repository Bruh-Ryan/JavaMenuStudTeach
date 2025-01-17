import java.util.ArrayList;
import java.util.Scanner;

public class Student extends menu{
    private String name;
    private char[] grades;
    private String[] subjectNames;
    private int rollNo;

    // Constructor
    public Student() {
        // Initialize fields to default values
        this.name = "";
        this.rollNo = 0;
        this.subjectNames = new String[5];
        this.grades = new char[5];
    }
    public Student(String name, int rollNo, String[] subjectNames, char[] grades) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjectNames = subjectNames;
        this.grades = grades;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(String[] subjectNames) {
        this.subjectNames = subjectNames;
    }

    public void setGrades(char[] grades) {
        this.grades = grades;
    }

    // Override toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Roll No: ").append(rollNo).append("\n");
        sb.append("Subjects and Grades:\n");
        for (int i = 0; i < subjectNames.length; i++) {
            sb.append(subjectNames[i]).append(": ").append(grades[i]).append("\n");
        }
        return sb.toString();
    }

    // Main menu
    public void studentMainMenu() {

        System.out.println("student menu:::: ");

        Scanner scan = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        boolean whale = true;

        while (whale) {
            System.out.println("\nchoose an option:\n 1. create student DBMS\n 2. view student DBMS\n3. update student DBMS\n4. delete student DBMS\n 5. exit");
            System.out.print("choose one! : ");
            int option = scan.nextInt();

            switch (option) {
                case 1: // Create
                    System.out.print("How many students do you want to add? ");
                    int add = scan.nextInt();

                    for (int n = 0; n < add; n++) {
                        scan.nextLine(); // Consume newline
                        System.out.print("Enter name: ");
                        String name = scan.nextLine();
                        System.out.print("Enter roll number: ");
                        int rollNo = scan.nextInt();
                        scan.nextLine(); // Consume newline

                        String[] subjectNames = new String[5];
                        char[] grades = new char[5];

                        System.out.println("Enter the subjects and grades (5 each):");
                        for (int j = 0; j < 5; j++) {
                            System.out.print("Subject " + (j + 1) + ": ");
                            subjectNames[j] = scan.nextLine();
                            System.out.print("Grade for " + subjectNames[j] + ": ");
                            grades[j] = scan.next().charAt(0);
                            scan.nextLine(); // Consume newline
                        }

                        studentList.add(new Student(name, rollNo, subjectNames, grades));
                    }
                    System.out.println("Students added successfully!");
                    break;

                case 2: // View
                    if (studentList.isEmpty()) {
                        System.out.println("No students in the DBMS.");
                    } else {
                        System.out.println("\nStudent List:");
                        for (Student stud : studentList) {
                            System.out.println(stud);
                        }
                    }
                    break;

                case 3: // Update
                    scan.nextLine(); // Consume newline
                    System.out.print("Enter the name of the student to update: ");
                    String findStud = scan.nextLine();

                    boolean found = false;
                    for (Student stud : studentList) {
                        if (stud.getName().equalsIgnoreCase(findStud)) {
                            found = true;
                            System.out.println("What would you like to update?\n1. Subjects\n2. Grades");
                            int subOption = scan.nextInt();
                            scan.nextLine(); // Consume newline

                            if (subOption == 1) {
                                String[] newSubjects = new String[5];
                                System.out.println("Enter new subjects:");
                                for (int j = 0; j < 5; j++) {
                                    System.out.print("Subject " + (j + 1) + ": ");
                                    newSubjects[j] = scan.nextLine();
                                }
                                stud.setSubjects(newSubjects);
                            } else if (subOption == 2) {
                                char[] newGrades = new char[5];
                                System.out.println("Enter new grades:");
                                for (int j = 0; j < 5; j++) {
                                    System.out.print("Grade for subject " + (j + 1) + ": ");
                                    newGrades[j] = scan.next().charAt(0);
                                    scan.nextLine(); // Consume newline
                                }
                                stud.setGrades(newGrades);
                            }
                            System.out.println("Student updated successfully!");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4: // Delete
                    scan.nextLine(); // Consume newline
                    System.out.print("Enter the name of the student to delete: ");
                    String deleteStud = scan.nextLine();

                    found = false;
                    for (Student stud : studentList) {
                        if (stud.getName().equalsIgnoreCase(deleteStud)) {
                            studentList.remove(stud);
                            System.out.println("Student removed successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5: // Exit
                    whale = false;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
    }
  
}