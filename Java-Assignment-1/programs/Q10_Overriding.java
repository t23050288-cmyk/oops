class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
public class Q10_Overriding {
    public static void main(String[] args) {
        Animal a = new Dog();     // run-time polymorphism
        a.sound();
        a = new Cat();
        a.sound();
    }
}
