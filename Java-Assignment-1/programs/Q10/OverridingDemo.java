class Animal {
    void sound() { System.out.println("Animal makes a sound"); }
    void eat() { System.out.println("Animal eats"); }
}
class Dog extends Animal {
    @Override
    void sound() {
        super.sound();                         // calls the superclass version
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    @Override
    void sound() { System.out.println("Cat meows"); }
}
public class OverridingDemo {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound();
        a = new Dog();                         // superclass reference, subclass object
        a.sound();
        a = new Cat();
        a.sound();
        a.eat();                               // not overridden: superclass version runs
    }
}
