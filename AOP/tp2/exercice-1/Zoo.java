import java.util.ArrayList;
import java.util.List;

// Q1: Create a class Animal [cite: 9]
class Animal {
    protected String name; // [cite: 12
    protected int age;     // [cite: 13]
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // A method talk() that returns a generic noise [cite: 14]
    public String talk() {
        return "some animal noise";
    }
    @Override
    public String toString() {
        return "Animal{name='" + name + "', age=" + age + "}";
    }
}

// Q2: Create a class Dog that inherits from Animal [cite: 15]
class Dog extends Animal {
    private String race; // Add an additional attribute race [cite: 18]

    public Dog(String name, int age, String race) {
        super(name, age);
        this.race = race;
    }

    // override the method talk() to return "Wouf!" [cite: 19]
    @Override
    public String talk() {
        return "Wouf!";
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', race='" + race + "', age=" + age + "}";
    }
}

// Q3: Create a class Cat that inherits from Animal [cite: 20]
class Cat extends Animal {
    private String color; // Add a color attribute [cite: 20]

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    // override the talk() method to return "Meow!" [cite: 22]
    @Override
    public String talk() {
        return "Meow!";
    }

    @Override
    public String toString() {
        return "Cat{name='" + name + "', color='" + color + "', age=" + age + "}";
    }
}

public class Zoo {
    // Q6: Implement a function that returns the number of dogs [cite: 26]
    public static int countDogs(List<Animal> animals) {
        int count = 0;
        for (Animal animal : animals) {
            // In Java, you can use instanceof [cite: 27]
            if (animal instanceof Dog) {
                count++;
            }
        }
        return count;
    }

    // Q4: Main method to create, display, and make animals talk [cite: 23]
    public static void main(String[] args) {
        // Q5: Create a list containing several Animal, Dog, and Cat objects [cite: 24]
        List<Animal> zoo = new ArrayList<>();

        zoo.add(new Animal("GenericBlob", 5));
        // Some objects must be of type Animal but instantiated as Dog or Cat [cite: 25]
        zoo.add(new Dog("Buddy", 3, "Golden Retriever"));
        zoo.add(new Cat("Whiskers", 2, "Black"));
        zoo.add(new Dog("Rex", 7, "German Shepherd"));

        System.out.println("--- Zoo Sounds & Info ---");
        for (Animal a : zoo) {
            System.out.println(a.toString() + " says: " + a.talk());
        }

        System.out.println("\n--- Statistics ---");
        System.out.println("Total Dogs found: " + countDogs(zoo));
    }
}
