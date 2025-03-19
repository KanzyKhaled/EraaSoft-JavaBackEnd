public class Cat implements Animal{
    private String name = "";
    private int age = 0;

    public Cat(){           // will be private in singletone example

    }

    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow! Meow!");
    }

    @Override
    public void eat() {
        System.out.println("Cat eats fish.");
    }

}
