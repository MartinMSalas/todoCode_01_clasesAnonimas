/*
 * Author: M
 * Date: 13-Mar-26
 * Project Name: Clases Anonimas
 * Description: beExcellent
 */
public class Dog implements Animal{

    private String name;
    private int age;
    private String color;
    private String breed;

    public Dog() {
    }

    public Dog(String name, int age, String color, String breed) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        IO.println("The dog has been sounded. Woof!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
