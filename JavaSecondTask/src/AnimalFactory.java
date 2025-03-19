public class AnimalFactory {
    // Factory method to return an instance based on type
    public static Animal getAnimal(String animalType) {
        if (animalType.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (animalType.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null; // Return null if the input type is not found
    }
}