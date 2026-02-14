package UWI;
	import java.util.Scanner;

	class Student {
	    int id;
	    String name;
	    int age;
	    String department;
	    float marks;

	    public Student(int id, String name, int age, String department, float marks) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.department = department;
	        this.marks = marks;
	    }

	    public void display() {
	        System.out.println("ID: " + id +", Name: " + name +", Age: " + age + ", Department: " + department +", Marks: " + marks);
	    }
	}

	public class StudentRecordManagement {

	    static Scanner scanner = new Scanner(System.in);
	    static Student[] students = new Student[100]; 
	    static int studentCount = 0; 

	    public static void main(String[] args) {

	        int choice;

	        do {
	            showMenu();
	            choice = getIntInput("Enter your choice: ");

	            switch (choice) {
	                case 1:
	                    addStudent();
	                    break;
	                case 2:
	                    displayStudents();
	                    break;
	                case 3:
	                    searchStudentById();
	                    break;
	                case 4:
	                    calculateAverageMarks();
	                    break;
	                case 5:
	                    System.out.println("Exiting system. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please select 1-5.");
	            }

	            System.out.println();

	        } while (choice != 5);

	        scanner.close();
	    }

	    static void showMenu() {
	        System.out.println("STUDENT RECORD MANAGEMENT SYSTEM");
	        System.out.println("1. Add Student");
	        System.out.println("2. Display All Students");
	        System.out.println("3. Search Student by ID");
	        System.out.println("4. Calculate Average Marks");
	        System.out.println("5. Exit");
	    }

	    static void addStudent() {

	        if (studentCount >= students.length) {
	            System.out.println("Student limit reached!");
	            return;
	        }

	        int id = getIntInput("Enter ID: ");

	        if (findStudentIndexById(id) != -1) {
	            System.out.println("Student with this ID already exists.");
	            return;
	        }

	        System.out.print("Enter Name: ");
	        String name = scanner.nextLine();

	        int age = getIntInput("Enter Age: ");

	        System.out.print("Enter Department: ");
	        String department = scanner.nextLine();

	        float marks = getFloatInput("Enter Marks: ");

	        students[studentCount] = new Student(id, name, age, department, marks);
	        studentCount++;

	        System.out.println("Student added successfully.");
	    }

	    static void displayStudents() {

	        if (studentCount == 0) {
	            System.out.println("No student records found.");
	            return;
	        }

	        System.out.println("----- Student Records -----");

	        for (int i = 0; i < studentCount; i++) {
	            students[i].display();
	        }
	    }

	    static void searchStudentById() {

	        int id = getIntInput("Enter ID to search: ");

	        int index = findStudentIndexById(id);

	        if (index == -1) {
	            System.out.println("Student not found.");
	        } else {
	            System.out.println("Student Found:");
	            students[index].display();
	        }
	    }

	    static void calculateAverageMarks() {

	        if (studentCount == 0) {
	            System.out.println("No students available to calculate average.");
	            return;
	        }

	        float total = 0;

	        for (int i = 0; i < studentCount; i++) {
	            total += students[i].marks;
	        }

	        float average = total / studentCount;

	        System.out.println("Average Marks of all students: " + average);
	    }

	    static int findStudentIndexById(int id) {

	        for (int i = 0; i < studentCount; i++) {
	            if (students[i].id == id) {
	                return i;
	            }
	        }

	        return -1;
	    }

	    static int getIntInput(String message) {

	        while (true) {
	            try {
	                System.out.print(message);
	                return Integer.parseInt(scanner.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Enter a valid integer.");
	            }
	        }
	    }

	    static float getFloatInput(String message) {

	        while (true) {
	            try {
	                System.out.print(message);
	                return Float.parseFloat(scanner.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Enter a valid number.");
	            }
	        }
	    }
	}
