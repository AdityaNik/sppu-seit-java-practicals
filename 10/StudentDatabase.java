import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String studentId;
    String name;
    String rollNo;
    String className;
    String marks;
    String address;

    public Student(String studentId, String name, String rollNo, String className, String marks, String address) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
        this.marks = marks;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", className='" + className + '\'' +
                ", marks='" + marks + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

public class StudentDatabase {
    private final String FILE_PATH = "student_database.txt";

    public void createDatabase() {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter Student ID: ");
            String studentId = scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Roll Number: ");
            String rollNo = scanner.nextLine();

            System.out.print("Enter Class: ");
            String className = scanner.nextLine();

            System.out.print("Enter Marks: ");
            String marks = scanner.nextLine();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            Student student = new Student(studentId, name, rollNo, className, marks, address);
            students.add(student);
            System.out.println();
        }

        try {
            File myObj = new File(FILE_PATH);
            if (myObj.createNewFile()) {
                FileWriter writer = new FileWriter(FILE_PATH);
                for (Student student : students) {
                    writer.write(student.studentId + "," + student.name + "," + student.rollNo + "," +
                            student.className + "," + student.marks + "," + student.address + "\n");
                }
                writer.close();
                System.out.println("Database created successfully.");
            } else {
                FileWriter writer = new FileWriter(FILE_PATH, true);
                for (Student student : students) {
                    writer.write(student.studentId + "," + student.name + "," + student.rollNo + "," +
                            student.className + "," + student.marks + "," + student.address + "\n");
                }
                System.out.println("Database created successfully.");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            System.out.println("\nStudent Database:");
            System.out.println(
                    "+------------+----------------------+------------------+-------+------------+----------------------+");
            System.out.printf("| %-11s | %-20s | %-16s | %-5s | %-10s | %-20s |\n", "Student ID", "Name", "Roll Number",
                    "Class", "Marks", "Address");
            System.out.println(
                    "+------------+----------------------+------------------+-------+------------+----------------------+");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.printf("| %-11s | %-20s | %-16s | %-5s | %-10s | %-20s |\n", data[0], data[1], data[2],
                        data[3], data[4], data[5]);
            }

            System.out.println(
                    "+------------+----------------------+------------------+-------+------------+----------------------+");
        } catch (IOException e) {
            System.out.println("Database does not exist. Please create a database first.");
        }
    }

    public void deleteRecords() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            PrintWriter writer = new PrintWriter(new FileWriter("temp.txt", true));
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the Student ID to delete: ");
            String studentIdToDelete = scanner.nextLine();

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equals(studentIdToDelete)) {
                    writer.println(line);
                } else {
                    found = true;
                }
            }

            // Close the resources
            reader.close();
            writer.close();

            // Move the temporary file to the original file if a record was deleted
            File originalFile = new File(FILE_PATH);
            File tempFile = new File("temp.txt");

            try {
                Files.move(tempFile.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Record(s) deleted successfully.");
                tempFile.delete();
            } catch (IOException e) {
                System.out.println("Failed to update the database: " + e.getMessage());
                // Optionally, print the stack trace for further debugging
                // e.printStackTrace();
            }

            // Print a message if the record was not found
            if (!found) {
                System.out.println("Record not found with Student ID " + studentIdToDelete);
            }
        } catch (IOException e) {
            System.out.println("Database does not exist. Please create a database first.");
        }
    }

    public void updateRecord() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
                PrintWriter writer = new PrintWriter("temp.txt")) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the Student ID to update: ");
            String studentIdToUpdate = scanner.nextLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(studentIdToUpdate)) {
                    System.out.println("\nExisting Student Record:");
                    System.out.println(new Student(data[0], data[1], data[2], data[3], data[4], data[5]));

                    System.out.print("\nEnter the new values (comma-separated): ");
                    String newValues = scanner.nextLine();
                    writer.println(newValues);
                } else {
                    writer.println(line);
                }
            }
            reader.close();
            writer.close();

            // Rename the temp file to the original file
            // Move the temporary file to the original file if a record was deleted
            File originalFile = new File(FILE_PATH);
            File tempFile = new File("temp.txt");

            try {
                Files.move(tempFile.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Record updated successfully.");
                tempFile.delete();
            } catch (IOException e) {
                System.out.println("Failed to update the database: " + e.getMessage());
                // Optionally, print the stack trace for further debugging
                // e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Database does not exist. Please create a database first.");
        }
    }

    public void searchRecord() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the Student ID to search: ");
            String studentIdToSearch = scanner.nextLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(studentIdToSearch)) {
                    System.out.println("\nStudent Record Found:");
                    System.out.println(new Student(data[0], data[1], data[2], data[3], data[4], data[5]));
                    return;
                }
            }
            System.out.println("Record not found with Student ID " + studentIdToSearch);
        } catch (IOException e) {
            System.out.println("Database does not exist. Please create a database first.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase db = new StudentDatabase();

        while (true) {
            System.out.println("\n\nStudent Database Management System");
            System.out.println("1. Insert Students Data");
            System.out.println("2. Display Records");
            System.out.println("3. Delete Records");
            System.out.println("4. Update Record");
            System.out.println("5. Search Record");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice (1-6): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    db.createDatabase();
                    break;
                case "2":
                    db.displayDatabase();
                    break;
                case "3":
                    db.deleteRecords();
                    break;
                case "4":
                    db.updateRecord();
                    break;
                case "5":
                    db.searchRecord();
                    break;
                case "6":
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}