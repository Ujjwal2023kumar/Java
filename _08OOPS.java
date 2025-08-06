public class _8OOPS {
    public static void main(String[] args) {
        // Pen object usage
        Pen p1 = new Pen(); // created a pen object called p1
        p1.setColor("Blue");
        p1.setTip(5);
        System.out.println("Pen Color: " + p1.getColor());
        System.out.println("Pen Tip Size: " + p1.getTip());

        // BankAccount usage
        //BankAccount myAcc = new BankAccount();
        // myAcc.username = "Ujjwal Kumar";
        // System.out.println("Bank Username: " + myAcc.username);
        // myAcc.setPassword("12345678");

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

        Tuna tuna = new Tuna();
        tuna.color = "Silver";
        tuna.fins = 2;
        tuna.weight = 15.5;
        System.out.println("Tuna color: " + tuna.color);
        System.out.println("Tuna weight: " + tuna.weight + " kg");
        tuna.eat();
        tuna.breathe();
        tuna.swim();
        tuna.hunt();

        Shark shark = new Shark();
        shark.color = "Grey";
        shark.fins = 4;
        shark.species = "Great White";
        System.out.println("\nShark species: " + shark.species);
        shark.eat();
        shark.breathe();
        shark.swim();
        shark.attack();

        Peacock peacock = new Peacock();
        peacock.color = "Blue-Green";
        peacock.tailLength = 5.2;
        System.out.println("\nPeacock color: " + peacock.color);
        System.out.println("Peacock tail length: " + peacock.tailLength + " feet");
        peacock.eat();
        peacock.breathe();
        peacock.fly();
        peacock.dance();

        Human human = new Human();
        human.color = "Brown";
        human.legs = 2;
        human.name = "Alice";
        human.age = 30;
        System.out.println("\nHuman name: " + human.name);
        System.out.println("Human age: " + human.age);
        human.eat();
        human.breathe();
        human.walk();
        human.think();

        // OOPs3
        Calculator cal = new Calculator();
        System.out.println(cal.sum(1, 2));
        System.out.println(cal.sum((float)1.5,(float)2.5));
        System.out.println(cal.sum(1, 2, 3));

        Deer d = new Deer();
        d.eat();

        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);

        Chicken c = new Chicken();
        c.eat();
        c.walk();

        // OOPs4
        Queen q = new Queen();
        King k = new King();
        Rook r = new Rook();
        q.moves();
        k.moves();
        r.moves();
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

// class BankAccount {
//     public String username;
//     private String password;

//     public void setPassword(String pwd) {
//         password = pwd;
//     }
// }

class Student {
    String name;
    int roll;
    String password;
    int[] marks;

    static String schoolName;

    void setName(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }

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

class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }
}

class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swims in water");
    }
}

class Mammal extends Animal {
    int legs;

    void walk() {
        System.out.println("Walks on land");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("flies in the sky");
    }
}

class Tuna extends Fish {
    double weight;

    void hunt() {
        System.out.println("Tuna hunts small fish");
    }
}

class Shark extends Fish {
    String species;

    void attack() {
        System.out.println("Shark attacks swiftly");
    }
}

class Peacock extends Bird {
    double tailLength;

    void dance() {
        System.out.println("Peacock dances beautifully");
    }
}

class Human extends Mammal {
    String name;
    int age;

    void think() {
        System.out.println("Human thinks logically");
    }
}

class Deer extends Mammal {
    void eat(){
        System.out.println("Eats grass");
    }
}

class Calculator{
    int sum(int a, int b){
        return a+b;
    }
    float sum(float a, float b){
        return a+b;
    }
    int sum(int a, int b, int c){
        return a+b+c;
    }
}

abstract class AbstractAnimal{
    String color;
    AbstractAnimal(){
        color = "brown";
    }
    void eat(){
        System.out.println("Animal eats");
    }
    abstract void walk();
}

class Horse extends AbstractAnimal{
    void changeColor(){
        color = "dark brown";
    }
    void walk(){
        System.out.println("Horse walks on 4 legs");
    }
}

class Chicken extends AbstractAnimal{
    void changeColor(){
        color = "yellow";
    }
    void walk(){
        System.out.println("Horse walks on 2 legs");
    }
}

interface ChessPlayer{
    void moves();
}
class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal by 1 step");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right");
    }
}

class Bike{
    Bike(){
        System.out.println("Bike Constructor is called");
    }
}
class RoyalEnfield extends Bike{
    RoyalEnfield(){
        super();
        System.out.println("Royal Enfield Constructor is called");
    }
}
