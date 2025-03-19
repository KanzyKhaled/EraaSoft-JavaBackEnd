public class Dog implements Animal{
    private String name = "";
    private int age = 0;

    public Dog(){             // will be private in singletone example

    }
    private static Dog dog;
    public static Dog getInstance() {
        if (dog == null) {
            dog = new Dog();
        }
        return dog;
    }

    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats bones");
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
}
