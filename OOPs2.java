public class OOPs2 {
    public static void main(String[] args) {
        // ---------- Tuna (Hybrid Inheritance via Fish → Animal) ----------
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

        // ---------- Shark (Hybrid Inheritance via Fish → Animal) ----------
        Shark shark = new Shark();
        shark.color = "Grey";
        shark.fins = 4;
        shark.species = "Great White";
        System.out.println("\nShark species: " + shark.species);
        shark.eat();
        shark.breathe();
        shark.swim();
        shark.attack();

        // ---------- Peacock (Hybrid via Bird → Animal) ----------
        Peacock peacock = new Peacock();
        peacock.color = "Blue-Green";
        peacock.tailLength = 5.2;
        System.out.println("\nPeacock color: " + peacock.color);
        System.out.println("Peacock tail length: " + peacock.tailLength + " feet");
        peacock.eat();
        peacock.breathe();
        peacock.fly();
        peacock.dance();

        // ---------- Human (Hybrid via Mammal → Animal) ----------
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
    }
}

// -------------------- Base Class --------------------
class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }
}

// -------------------- Single Inheritance --------------------
class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swims in water");
    }
}

// -------------------- Multilevel Inheritance --------------------
class Mammal extends Animal {
    int legs;

    void walk() {
        System.out.println("Walks on land");
    }
}

// -------------------- Hierarchical Inheritance --------------------
class Bird extends Animal {
    void fly() {
        System.out.println("flies in the sky");
    }
}

// -------------------- Hybrid Inheritance Classes --------------------

// 1. Tuna from Fish → Animal
class Tuna extends Fish {
    double weight;

    void hunt() {
        System.out.println("Tuna hunts small fish");
    }
}

// 2. Shark from Fish → Animal
class Shark extends Fish {
    String species;

    void attack() {
        System.out.println("Shark attacks swiftly");
    }
}

// 3. Peacock from Bird → Animal
class Peacock extends Bird {
    double tailLength;

    void dance() {
        System.out.println("Peacock dances beautifully");
    }
}

// 4. Human from Mammal → Animal
class Human extends Mammal {
    String name;
    int age;

    void think() {
        System.out.println("Human thinks logically");
    }
}
