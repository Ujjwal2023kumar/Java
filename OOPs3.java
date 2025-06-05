public class OOPs3 {
    public static void main(String[] args) {
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
    }
}

class Mammal{
    void eat(){
        System.out.println("Eats anything");
    }
}
class Deer extends Mammal{
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

// Abstract Class
abstract class Animal{
    String color;
    Animal(){
        color = "brown";
    }
    void eat(){
        System.out.println("Animal eats");
    }
    abstract void walk();
}

class Horse extends Animal{
    void changeColor(){
        color = "dark brown";
    }
    void walk(){
        System.out.println("Horse walks on 4 legs");
    }
}

class Chicken extends Animal{
    void changeColor(){
        color = "yellow";
    }
    void walk(){
        System.out.println("Horse walks on 2 legs");
    }
}
