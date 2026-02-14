import java.util.*;

public class StudentManager {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1.Add  2.View  3.Update  4.Delete  5.Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
switch (choice) {
    case 1:
        addStudent();
        break;

    case 2:
        viewStudents();
        break;

    case 3:
        updateStudent();
        break;

    case 4:
        deleteStudent();
        break;

    case 5:
        System.out.println("Program Closed");
        return;

    default:
        System.out.println("Invalid choice");
}

        }
    }

    static void addStudent() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student Added");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records");
            return;
        }
        students.forEach(System.out::println);
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine();
                System.out.print("New name: ");
                s.setName(sc.nextLine());
                System.out.print("New marks: ");
                s.setMarks(sc.nextDouble());
                System.out.println("Updated");
                return;
            }
        }
        System.out.println("Student not found");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        students.removeIf(s -> s.getId() == id);
        System.out.println("Deleted if existed");
    }
}