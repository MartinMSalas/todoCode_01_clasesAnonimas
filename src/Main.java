import service.Messenger;
import service.Operator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

    new Vehicle(){

        public void run(){
            int passengers = 0;
            int speed = 0;
            IO.println("The vehicle is running at " + speed + " km/h with " + passengers + " passengers.");
        };
    }.run();

    // use of functional interface and lambda expression
    Messenger messenger= (message) -> {

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
}
