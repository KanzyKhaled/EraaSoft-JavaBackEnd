import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Key Differences Between List and Set
        /*
        List:                                       Set:
              - Maintain Order Insertion                - Does not guarantee order
              - Allow Duplicates                        - Does not allow duplicate elements
              - Can Access Elements using Index         - No index-based access
         */
        //List
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Apple"); // Duplicates are allowed

        System.out.println("List Elements: " + list);
        System.out.println("Element at index 1: " + list.get(1)); // Access by index

        //Set
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); // Duplicate, won't be added

        System.out.println("Set Elements: " + set);

        //--------------------------------------------------------------
        // Key Differences Between LinkedHashSet and HashSet
        /*
          LinkedHashSet:                             HashSet:
              - Maintain Order Insertion                - Does not guarantee order
              - Output Order May Vary                   - Output Maintains Order
        */

        //LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Mango");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Apple"); // Duplicate, won't be added

        System.out.println("LinkedHashSet Elements: " + linkedHashSet);


        //HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Mango");
        hashSet.add("Orange");
        hashSet.add("Apple"); // Duplicate, won't be added

        System.out.println("HashSet Elements: " + hashSet);

        //--------------------------------------------------------------
        // Key Differences Between Vector and ArrayList
        /*
          ArrayList :                                         Vector:
              - Faster because it's not synchronized                - Slower due to synchronization overhead
              - Increases size by 50% when full                     - Doubles its size when full
              - Used in single-threaded environments                - Used in multi-threaded environments
        */
        //ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Mango");
        arrayList.add("Orange");

        System.out.println("ArrayList Elements: " + arrayList);

        //Vector
        List<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Mango");
        vector.add("Orange");

        System.out.println("Vector Elements: " + vector);

        // Key Differences Between PriorityQueue  and ArrayDeque
        /*
          PriorityQueue :                                                 ArrayDeque :
              - Elements are ordered based on priority                               - Maintains insertion order
              - Used when you need automatic sorting based on priority               - Used as a stack (LIFO) or queue (FIFO)

        */

        //PriorityQueue

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-Heap by default (The smallest element is always removed first )
        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);

        System.out.println("PriorityQueue Elements (Sorted Automatically): ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // Retrieves and removes elements in priority order
        }

        //ArrayDeque
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Queue behavior (FIFO)
        deque.offer("Apple");
        deque.offer("Banana");
        deque.offer("Mango");

        System.out.println("ArrayDeque as Queue: " + deque);
        System.out.println("Removed (FIFO): " + deque.poll());

        // Stack behavior (LIFO)
        deque.push("Orange");
        deque.push("Grapes");

        System.out.println("ArrayDeque as Stack: " + deque);
        System.out.println("Removed (LIFO): " + deque.pop());

        //------------------------------------------------------------------
        //Singletone Example

        Dog myDog1 = Dog.getInstance();
        myDog1.makeSound();
        myDog1.eat();
        myDog1.setName("Roky");

        System.out.println("my Dog1 name is " + myDog1.getName());

        Dog myDog2 = Dog.getInstance();
        System.out.println("my Dog2 name is " + myDog2.getName());
        // Check if both objects are the same instance
        System.out.println("Are myDog1 and myDog2 the same? " + (myDog1 == myDog2));

        //------------------------------------------------------------------
        //Factory Pattern Example
        Animal myDog = AnimalFactory.getAnimal("dog");
        myDog.makeSound();
        myDog.eat();

        Animal myCat = AnimalFactory.getAnimal("cat");
        myCat.makeSound();
        myCat.eat();

        //------------------------------------------------------------------
        //Factory Pattern Example on List Classes
        // Get an ArrayList instance
        List<?> arrayList1 = ListFactory.getList("arraylist");
        System.out.println("Created instance of: " + arrayList1.getClass().getSimpleName());

        // Get a LinkedList instance
        List<?> linkedList1 = ListFactory.getList("linkedlist");
        System.out.println("Created instance of: " + linkedList1.getClass().getSimpleName());

        // Get a Vector instance
        List<?> vector1 = ListFactory.getList("vector");
        System.out.println("Created instance of: " + vector1.getClass().getSimpleName());

        // Get a Stack instance
        List<?> stack1 = ListFactory.getList("stack");
        System.out.println("Created instance of: " + stack1.getClass().getSimpleName());

    }
}