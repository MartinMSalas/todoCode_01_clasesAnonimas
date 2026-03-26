import entity.Car;
import entity.Client;
import service.Messenger;
import service.Operator;
import service.QuadFunction;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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


        Optional<String> stringNull = Optional.ofNullable(null);
        Optional<String> stringNull2 = Optional.empty();


        List<Optional<String>> stringList = Arrays.asList(stringNull, stringNull2);
        stringList.stream().forEach(str -> {

                str.ifPresentOrElse(
                        value -> IO.println("Value is present: " + value),
                        () -> IO.println("Value is null")
                );

        });

        List<Client> clients = createClients();

        //search for a specific client

        IO.println("Clients created: ");

        clients.stream().forEach(client -> {
                    if (client.getAddress() == null) {
                        client.setAddress("Not address");
                    };
                    IO.println(client);
                }
            );

        int clientId = 2;
        IO.println("Find client with id: " + clientId );

        Optional<Client> foundClient = searchForClientByClientId(clients,clientId);

        foundClient.ifPresentOrElse(
                (value)
                        -> {
                            System.out.println("Client with id: " +clientId + " exists: ");
                            IO.println(value);
                    },
                ()
                        -> { System.out.println("Client not found"); });


        List<Client> clients2 = createClients();
        Optional<Client> foundClient2 = searchForClientByClientId(clients2,clientId);
        foundClient2.ifPresentOrElse(
                (client) -> {
                    IO.println("Client with id: " +clientId + " exists: ");
                    IO.println(createSanitizedClient(client));
                },
                () -> {
                    IO.println("Client with id: " +clientId + " not found");
                });


        IO.println("Clients list: " );
        clients.stream().forEach(IO::println);


        IO.println("Clients sorted: ");

        clients.stream().sorted(Comparator.comparing(Client::getLastName).reversed()) .forEach(System.out::println);

        clients.stream().forEach(IO::println);
        // toList of filtered Cars
        List<Car> filteredCars = cars.stream().filter(car -> car.getPrice() <=25000)
                .sorted(Comparator.comparing(Car::getPrice).reversed()).toList();

        filteredCars.stream().forEach(System.out::println);


        List<String> duplicateCountries = Arrays.asList("Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela","Argentina", "Brazil", "Chile", "Colombia", "Ecuador", "Peru",
                "Uruguay", "Venezuela");

        duplicateCountries.stream().forEach(System.out::println);

        IO.println("--------------------------------");
        IO.println("Unique countries names");
        IO.println("--------------------------------");
        Set<String> uniqueCountries = duplicateCountries.stream().map(String::toUpperCase).collect(Collectors.toSet());

        uniqueCountries.stream().forEach(System.out::println);

        String unitedCountries = uniqueCountries.stream().collect(Collectors.joining(" | "));
        IO.println("United countries names: " + unitedCountries);

        //long countedCountries = uniqueCountries.stream().filter(innerCountry -> innerCountry.contains("L")).count();
        long countedCountries = uniqueCountries.stream().filter(innerCountry -> innerCountry.contains("L")).count();
        IO.println("United countries names: " + countedCountries);

        // Collectors.partitioningBy()

        List<Integer> ages = List.of(11,11,44,33,22,121,4,12,5,32,32,1,2,3,4,5,6,7,11,2,33,52,61);
        Map<Boolean, List<Integer>> partitionedAge = ages.stream().collect(Collectors.partitioningBy(age -> age > 18));
        IO.println("Partitioned Ages: " + partitionedAge);

    }

    private Client createSanitizedClient(Client client) {
        Client newClient = client;
        newClient.setAddress(
                Optional.ofNullable(client.getAddress())
                        .orElse("Not address")
        );
        return newClient;
    };
    private Optional<Client> searchForClientByClientId(List<Client> clients, Integer clientId) {
        return clients.stream().filter(client -> Objects.equals(client.getClientId(), clientId)).findFirst();
    };
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

    public static List<Client> createClients() {
        return List.of(
                new Client(1,"Pepita","La Pistolera","Desierto"),
                new Client(2,"Poncio","Pilato",null),
                new Client(3, "Diogenes", "of Siracusa", "Siracusa")
        );
    }



}