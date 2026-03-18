import entity.Car;
import service.Messenger;
import service.Operator;
import service.QuadFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
public class Main {// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));

        // overriding the makeSound method of the Animal class using an anonymous inner class
        Animal dog = new Animal() {
            @Override
            public void makeSound() {
                IO.println("Woof!");
            }
        };

        IO.println("Welcome to Animal Dog!");
        dog.makeSound();

        new Vehicle() {

            public void run() {
                int passengers = 0;
                int speed = 0;
                IO.println("The vehicle is running at " + speed + " km/h with " + passengers + " passengers.");
            }

            ;
        }.run();

        // use of functional interface and lambda expression
        Messenger messenger = (message) -> {

            IO.println("Welcome to the lambda expression baby ! " + message);

        };


        messenger.sendMessage("This is a message sent using the Messenger functional interface.");

        // Anonymous inner class implementing the Operator interface
        Operator additive = new Operator() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        int result = additive.operate(5, 3);
        IO.println("The result of the addition is: " + result);

        // with lambda expression
        Operator lambdaAdditive = (a, b) -> a + b;

        int lambdaResult = lambdaAdditive.operate(50, 13);
        IO.println("The result of the addition is: " + lambdaResult);

        // Method reference example
        // with static method reference
        Function<Integer, String> toString = String::valueOf;
        String resultString = toString.apply(123);
        IO.println("The result of the method reference is: " + resultString);

        // with instance method reference
        Dog freya = new Dog();
        Runnable dogBark = freya::makeSound;
        dogBark.run();

        // with constructor reference
        QuadFunction<String, Integer, String, String, Dog> dogConstructor = Dog::new;

        Dog anotherDog = dogConstructor.apply("Buddy", 5, "golden", "Golden Retriever");
        IO.println("Created a new dog: " + anotherDog.getName() + ", Age: " + anotherDog.getAge() + ", Breed: "
                + anotherDog.getBreed() + ", Color: " + anotherDog.getColor());

        // Reference to an instance method of an arbitrary object of a particular type
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new Dog("Rex", 3, "brown", "Labrador"));
        animals.add(new Dog("Atila", 3, "brown", "Labrador"));
        animals.add(new Dog("Cleopatra", 3, "brown", "Labrador"));
        animals.add(new Dog("Bella", 2, "black", "Poodle"));
        animals.add(new Cat());

        animals.forEach(Animal::makeSound);

        List<String> animalNames = new ArrayList<>();
        animals.forEach(animal -> {
            if (animal instanceof Dog) {
                animalNames.add(((Dog) animal).getName());
            } else if (animal instanceof Cat) {
                animalNames.add("Cat");
            }
        });

        // animalNames.forEach(System.out::println);
        animalNames.stream().forEach(System.out::println);

        List<String> country = Arrays.asList("Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela");

        country.stream()
                .filter(paises -> paises.toLowerCase().contains("a"))
                .forEach(System.out::println);


        // Load and arraylist with 11 cars
        List<Car> cars = createCars();

        IO.println("Cars created: " + cars);

        IO.println("Cars sorted by price");
        cars.stream().sorted(Comparator.comparingDouble(Car::getPrice)).forEach(System.out::println);


        IO.println("Cars filtered by price");
        cars.stream().filter(car ->  car.getPrice() <= 23000).forEach(System.out::println);

        IO.println("Cars of brand Chevrolet Or Volkswagen");
        cars.stream().filter(car -> car.getBrand().equalsIgnoreCase("Chevrolet") || car.getBrand()
                .equalsIgnoreCase("Volkswagen")).forEach(System.out::println);

        IO.println("Cars with model that contains letter 'a'");
        cars.stream().filter(car -> car.getModel().toLowerCase().contains("a")).forEach(System.out::println);

        IO.println("Cars sorted by Brand and price");
        cars.stream().sorted(Comparator.comparing(Car::getBrand).thenComparing(Car::getPrice))
                .forEach(System.out::println);

        IO.println("Cars sorted by price from highest to lowest");
        cars.stream().sorted(Comparator.comparingDouble(Car::getPrice).reversed()).forEach(System.out::println);

    }

    public static List<Car> createCars() {
        return List.of(
                new Car("Volkswagen", "Amarok", 25000),
                new Car("Volkswagen", "Taos", 32000),
                new Car("Chevrolet", "Onix", 22000),
                new Car("Chevrolet", "Tracker", 30000),
                new Car("Fiat", "Cronos", 21000),
                new Car("Fiat", "Pulse", 24000),
                new Car("Toyota", "Corolla", 28000),
                new Car("Toyota", "Yaris", 23000),
                new Car("Renault", "Stepway", 20000),
                new Car("Renault", "Duster", 27000),
                new Car("Nissan", "Versa", 25000)
        );
    }

}