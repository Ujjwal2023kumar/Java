public class OOPs1 {
    public static void main(String[] args) {
        // Pen object usage
        Pen p1 = new Pen(); // created a pen object called p1
        p1.setColor("Blue");
        p1.setTip(5);
        System.out.println("Pen Color: " + p1.getColor());
        System.out.println("Pen Tip Size: " + p1.getTip());

        // BankAccount usage
        BankAccount myAcc = new BankAccount();
        myAcc.username = "Ujjwal Kumar";
        System.out.println("Bank Username: " + myAcc.username);
        myAcc.setPassword("12345678");

        // Student s1
        Student s1 = new Student();
        s1.name = "Ujjwal";
        s1.roll = 5;
        s1.password = "12345678";
        s1.marks[0] = 98;
        s1.marks[1] = 99;
        s1.marks[2] = 100;

        // Student s2
        Student s2 = new Student("Ujjwal");
        s2.password = "xyz";
        System.out.println("\nStudent s2 Info:");
        System.out.println("Name: " + s2.name);
        System.out.println("Password: " + s2.password);
        for (int i = 0; i < 3; i++) {
            System.out.println("Mark " + (i + 1) + ": " + s2.marks[i]); // default 0
        }

        // Student s3
        Student s3 = new Student(10);
        s3.name = "Amit";
        s3.password = "s3pass";
        s3.marks[0] = 80;
        s3.marks[1] = 85;
        s3.marks[2] = 90;
        System.out.println("\nStudent s3 Info:");
        System.out.println("Name: " + s3.name);
        System.out.println("Roll: " + s3.roll);
        System.out.println("Password: " + s3.password);
        for (int i = 0; i < 3; i++) {
            System.out.println("Mark " + (i + 1) + ": " + s3.marks[i]);
        }

        // Student s4 (deep copy of s1)
        Student s4 = new Student(s1);
        System.out.println("\nStudent s4 Info (Copied from s1):");
        System.out.println("Name: " + s4.name);
        System.out.println("Roll: " + s4.roll);
        System.out.println("Password: " + s4.password);
        for (int i = 0; i < 3; i++) {
            System.out.println("Mark " + (i + 1) + ": " + s4.marks[i]);
        }

        // Modify s1 marks to demonstrate deep copy
        s1.marks[0] = 50;
        System.out.println("\nAfter modifying s1.marks[0] to 50:");
        System.out.println("s1.marks[0]: " + s1.marks[0]);
        System.out.println("s4.marks[0] (should remain unchanged if deep copy): " + s4.marks[0]);
    }
}

class Pen {
    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String newColor) {
        this.color = newColor;
    }

    void setTip(int newTip) {
        this.tip = newTip;
    }
}

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }
}

class Student {
    String name;
    int roll;
    String password;
    int[] marks;

    // Default constructor
    Student() {
        marks = new int[3];
        System.out.println("Default Constructor is called.");
    }

    // Constructor with name
    Student(String name) {
        this.name = name;
        marks = new int[3]; // initialize array
    }

    // Constructor with roll
    Student(int roll) {
        this.roll = roll;
        marks = new int[3]; // initialize array
    }

    // Deep copy constructor
    Student(Student s1) {
        this.name = s1.name;
        this.roll = s1.roll;
        this.password = s1.password;
        this.marks = new int[3];
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }
}
