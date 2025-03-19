import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    // Implementation of Array
        String[] subjects = new String[4];
        subjects[0] = "Arabic";
        subjects[1] = "Math";
        subjects[2] = "English";
        subjects[3] = "Science";

        Integer grades[] = {80,95,99,85};

    // Arrays Before Update
        System.out.println(subjects[2]);

        System.out.println("Subjects and Grades");
        for(int i = 0; i < grades.length; i++){
            System.out.println(subjects[i] + " : " + grades[i] + "%");
        }
    // Update Array Element
        subjects[1] = "Social";
        //Search
        for(int i = 0; i < grades.length; i++){
            if(grades[i] == 95) {
                grades[i] = 90;
                System.out.println("array element at index " + i + " Updated");
            }
        }


        System.out.println("Subjects and Grades");
        for(int i = 0; i < grades.length; i++){
            System.out.println(subjects[i] + " : " + grades[i] + "%");
            // "Not The best practice because arrays may be different in size"
        }
        System.out.println("-----------------------------------------------------------");

    //Implementation of  ArrayList (Dynamic Array)

        ArrayList<String> employees = new ArrayList<>();
        employees.add("Ahmed");
        employees.add("Mohamed");
        employees.add("Mostafa");
        employees.add("Omar");

        ArrayList<Integer> salaries = new ArrayList<>();
        salaries.add(1000);
        salaries.add(1500);
        salaries.add(2000);
        salaries.add(2500);

        System.out.println(employees);
        System.out.println(salaries);
        System.out.println("Employee name  at index 2: " + employees.get(2));

    // Update
        employees.set(2,"Amr");
        System.out.println(employees);
        System.out.println("Employee name  at index 2 after Update: " + employees.get(2));

        salaries.set(2,3000);
        System.out.println("salary at index 2 after Update: " + salaries.get(2));
        System.out.println(salaries);

    //Delete
        //print before delete
        System.out.println(employees);
        System.out.println(salaries);
        //delete
        employees.remove(3);
        salaries.remove(3);
        //print after delete
        System.out.println(employees);
        System.out.println(salaries);

        System.out.println("Employee and Salary");
        for (int i = 0; i < employees.size(); i++) {
            System.out.print(employees.get(i) + " : " + salaries.get(i) + '\n');
            // "Not The best practice because arrays may be different in size"
        }
        System.out.println("-----------------------------------------------------------");
    // Implementation Of LinkedList

        LinkedList<String> matches = new LinkedList<String>();
        //Add
        matches.add("Al Ahli");
        matches.add("Pyramids");
        matches.add("Zamalek");

        System.out.println(matches);
        //Add at specific index
        matches.add(2,"Al Masry");
        System.out.println(matches);
        //get element from specific index
        System.out.println(matches.get(3));
        //get element from First and Last indexes
        System.out.println("LinkedList First Elements : " + matches.getFirst());
        System.out.println("LinkedList Last Elements : " + matches.getLast());
        //Update
        matches.set(3,"ZED FC");
        System.out.println(matches);
        //Add at first & last index
        matches.addFirst("Real Madrid");
        matches.addLast("Wadi Degla");
        System.out.println(matches);

        //Remove
        matches.remove(4);
        System.out.println(matches);
        matches.removeFirst();
        System.out.println(matches);
        matches.removeLast();
        System.out.println(matches);

        System.out.println("Clubs in matches List are: ");
        for(int i = 0; i< matches.size(); i++){
            System.out.println(matches.get(i));
        }

        System.out.println("-----------------------------------------------------------");
    // Implementation of Stack

        Stack<String> shelf = new Stack<>();
    // ADD
        shelf.push("cup");
        shelf.push("plate");
        shelf.push("knife");

        System.out.println(shelf);

        System.out.println("Top Element of the stack is : " + shelf.peek());
    //Delete
        System.out.println("Removed element is : " + shelf.pop());
        System.out.println(shelf);


        shelf.push("spoon");
    //Search
        System.out.println("Stack Element Plate at Index  : " + shelf.search("plate"));

        System.out.println("Is Stack Empty : " + shelf.isEmpty());

        System.out.println("Stack Element at index 2 is : " + shelf.elementAt(2));

        System.out.println("-----------------------------------------------------------");

    // Implementation of Queue
        Queue<String> studentsQueue = new LinkedList<>();

        //Add
        studentsQueue.add("Sara");
        studentsQueue.add("Farah");
        studentsQueue.add("Salma");
        studentsQueue.add("Amira");

        System.out.println(studentsQueue);
        System.out.println("First Student in the Queue is : " + studentsQueue.peek());

        //Delete
        studentsQueue.poll();
        //studentsQueue.remove();
        /*The remove and poll methods differ in their behavior only when the queue is empty.
        Under these circumstances, remove throws NoSuchElementException , while poll returns null.*/

        System.out.println("First Student in the Queue after Dequeue is : " + studentsQueue.peek());
        System.out.println(studentsQueue);

        System.out.println("-----------------------------------------------------------");

    // Implementation of Map

        Map<String, Integer> currenciesToEgp = new HashMap<>();
        //Add
        currenciesToEgp.put("USD",50);
        currenciesToEgp.put("Euro",55);
        currenciesToEgp.put("SAR",14);

        System.out.println(currenciesToEgp);

        //Select
        System.out.println("1 USD equals : " + currenciesToEgp.get("USD") + "  EGP.");

        if(!currenciesToEgp.containsKey("AED")){
            currenciesToEgp.put("AED", 14);
        }

        System.out.println("Map contains value = 14 ? => " + currenciesToEgp.containsValue(14));

        System.out.println(currenciesToEgp);

        //Delete

        currenciesToEgp.remove("AED");
        System.out.println("Map after deletion " + currenciesToEgp);


    }
}