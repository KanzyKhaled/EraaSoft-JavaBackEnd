import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.employee.model.Employee;
import com.student.model.Student;

public class StreamTaskMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
		
		List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
		
		List<List<String>> nestedWords = Arrays.asList(
			    Arrays.asList("Java", "Stream"),
			    Arrays.asList("API", "Lambda"),
			    Arrays.asList("FlatMap", "Map")
			);
		
		List<Student> students = Arrays.asList(
			    new Student("Ali", "IT", 85),
			    new Student("Mona", "CS", 92),
			    new Student("Ahmed", "IT", 60),
			    new Student("Sara", "CS", 70),
			    new Student("Omar", "IS", 45),
			    new Student("Laila", "IS", 78)
			);
		
		List<Employee> employees = Arrays.asList(
			    new Employee("Ali", 30, "HR", 5000),
			    new Employee("Mona", 25, "IT", 7000),
			    new Employee("Ahmed", 30, "HR", 5500),
			    new Employee("Sara", 27, "IT", 7200),
			    new Employee("Omar", 40, "Finance", 8000),
			    new Employee("Laila", 35, "Finance", 8200)
			);
	
	
	//------ 🔹 Basic Stream Operations -------------
	//------ Filter even numbers from a list of integers.

		Function<List<Integer>,List<Integer>> ListOfEvenNumbers = nums -> nums.stream()
																  .filter( num -> num % 2 == 0).collect(Collectors.toList());
		List<Integer> evenNumbers = ListOfEvenNumbers.apply(numbers);
		System.out.println("Even Numbers List : " + evenNumbers);
		

	//------ Find names starting with a specific letter from a list of strings.
		
		Function<List<String>,List<String>> ListOfNamesStartsWithA = namesList -> namesList.stream()
																	.filter(name -> name != null && name.startsWith("A")).collect(Collectors.toList());
		
		List<String> namesStartsWithA = 	ListOfNamesStartsWithA.apply(names);
		System.out.println("List Of Names Starts With Letter A : " + namesStartsWithA);
		
	//------ Convert all strings to uppercase using stream.
		
		 Function<List<String>, List<String>> toUpperCaseAll = list -> list.stream() 
				  												 .filter(Objects::nonNull)
													             .map(String::toUpperCase)
													             .collect(Collectors.toList());
		 List<String> uppercasedNames = toUpperCaseAll.apply(names);
	     System.out.println("Uppercased names: " + uppercasedNames);

   //------ Sort a list of integers in descending order using streams.
	     
	     Function<List<Integer>,List<Integer>> numbersInDescOrder = nums -> nums.stream()
													    		 .sorted(Comparator.reverseOrder())
													             .collect(Collectors.toList());

	     System.out.println("Numbers Sorted in descending order: " + numbersInDescOrder.apply(numbers));

   //------ Remove duplicate elements from a list using distinct().
	     
	     Function<List<Integer>, List<Integer>> removeDuplicates = nums -> nums.stream()
													             .distinct()
													             .collect(Collectors.toList());

         List<Integer> uniqueNumbers = removeDuplicates.apply(numbers);
         System.out.println("Unique Numbers : " + uniqueNumbers);


   //------ 🔹 Intermediate Stream Tasks -------------      
   //------ Count the number of strings longer than 5 characters.
         
         Function<List<String>, Long> strLongerThanFiveChars = listOfStr -> listOfStr.stream().filter(name -> name != null && name.length() > 5).count();
         Long countOfStrLongerThanFiveChars = strLongerThanFiveChars.apply(names);
         System.out.println("Count of Strings Longer Than 5 Characters is: " + countOfStrLongerThanFiveChars);
          
   //------ Find the first element in a stream that matches a given condition.
         
         Predicate<String> startsWithA = name -> name != null && name.startsWith("A");

         String firstMatch = null;
         for (String name : names) {
             if (startsWithA.test(name)) {
                 firstMatch = name;
                 break; // Stop at the first match
             }
         }

         System.out.println("Names starting with 'A': " + firstMatch);
     
   //------ Check if any number is divisible by 5 in a list.
         
         Predicate<Integer> divisibleByFive  = num -> num % 5 == 0;
         boolean anyDivisible = false;
         for (Integer num : numbers) {
             if (divisibleByFive.test(num)) {
                 anyDivisible = true;
                 break;
             }
         }

         System.out.println("Any number divisible by 5? " + anyDivisible);
         
   //------ Collect elements into a Set instead of a List.
         Set<String> setOfNames = names.stream()
				                 .filter(Objects::nonNull)
				                 .collect(Collectors.toSet());
         System.out.println("Names into Set : " + setOfNames);
         
         //------Solution 2 -----
         Function<List<Integer>,Set<Integer>> collectElementsFromListToSet = elements -> elements.stream()
															        		 .filter(Objects::nonNull)
															                 .collect(Collectors.toSet());

         Set<Integer> setOfNumbers = collectElementsFromListToSet.apply(numbers);
         System.out.println("Numbers into Set : " + setOfNumbers);

   //------ Skip the first 3 elements and return the rest.
         
         List<String> remaining = names.stream()
				                 .skip(3)
				                 .collect(Collectors.toList());
         
         System.out.println("After skipping first 3: " + remaining);

         
   //------ Calculate the sum of a list of integers using reduce.

         int sum1 = numbers.stream()
                 .reduce(0, (a, b) -> a + b);
         System.out.println("Sum 1 of numbers: " + sum1);

		// Or using method reference
		 int sum2 = numbers.stream().reduce(0, Integer::sum);
		
		System.out.println("Sum 2 of numbers: " + sum2);

   //------ Find the maximum and minimum value in a list.
		
        Function<List<Integer>, String> minMaxSummary = list -> {
            if (list == null || list.isEmpty()) return "List is empty or null.";

            int min = list.stream().min(Integer::compareTo).orElseThrow();
            int max = list.stream().max(Integer::compareTo).orElseThrow();

            return "Minimum: " + min + ", Maximum: " + max;
        };

        String result = minMaxSummary.apply(numbers);
        System.out.println(result);

   //------ Calculate the average of a list of doubles.
        
        List<Double> doubleNumbers = Arrays.asList(3.5, 7.5, 4.3, 4.7, 5.1);

        double average = doubleNumbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0); // fallback if list is empty

        System.out.println("Average: " + average);
        
   //------ Multiply all integers in a list together using reduce.

        int multiply = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println("Multiply of all numbers: " + multiply);

   //------ Count how many numbers are positive in a list.
        
        Function<List<Integer>, Long> positiveNumbers = nums -> nums.stream().filter(num -> num  > 0).count();
        Long countOfPositiveNumbers = positiveNumbers.apply(numbers);
        System.out.println("Count of Positive Numbers is : " + countOfPositiveNumbers);
        
        
   //------ 🔹 Collectors & Grouping -------------    
   //------  Group a list of students by their department.
        Map<String, List<Student>> studentsGroupedByDepartment = students.stream()
        														 .collect(Collectors.groupingBy(Student::getDepartment));
        	
           
        		studentsGroupedByDepartment.forEach((dept, list) -> {
                System.out.println(dept + ":");
                list.forEach(s -> System.out.println(" - " + s.getName() + " (Grade: " + s.getGrade() + ")"));
            });

   //------ Partition a list of numbers into even and odd using partitioningBy.
            
       Map<Boolean,List<Integer>> partitionedNums = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
       System.out.println("Even Numbers:");
       partitionedNums.get(true).forEach(num -> System.out.println(num));

       System.out.println("Odd Numbers:");
       partitionedNums.get(false).forEach(num -> System.out.println(num));

   //------ Create a comma-separated string from a list of strings.
       
       String commaSeprStr = names.stream()
    		   				.filter(Objects::nonNull)
                            .collect(Collectors.joining(","));

       System.out.println("Comma-separated String : " + commaSeprStr);

   //------ Group employees by age and count how many per age.
       
      Map<Integer, Long> emplpoyeesGroupedByAge = employees.stream()
    		  									.collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));

      emplpoyeesGroupedByAge.forEach((age, count) ->
              System.out.println("Age " + age + ": " + count + " employee(s)")
          );

   //------ Find the average salary per department in a list of employees.

      Map<String, Double> avgSalaryByDept = employees.stream()
              .collect(Collectors.groupingBy(
                  Employee::getDepartment,
                  Collectors.averagingDouble(Employee::getSalary)
              ));

          avgSalaryByDept.forEach((dept, avg) ->
              System.out.println(dept + " → Average Salary: " + avg));

   //------ Flatten a list of lists into a single list.
          List<List<String>> nestedList = Arrays.asList(
                  Arrays.asList("Ali", "Mona"),
                  Arrays.asList("Omar", "Kanzy"),
                  Arrays.asList("Kareem", "Laila")
              );

              List<String> flat = nestedList.stream()
                                        .flatMap(List::stream)
                                        .collect(Collectors.toList());

              System.out.println("Flattened list: " + flat);

   //------ Extract all unique characters from a list of words.
              
      Set<Character> uniqueChars = names.stream()
              .filter(Objects::nonNull)
              .flatMap(word -> word.chars().mapToObj(c -> (char) c))
              .collect(Collectors.toSet());

          System.out.println("Unique characters: " + uniqueChars);

   //------ Filter a list of Optionals and collect non-empty values.
                  
      List<Optional<String>> optionals = Arrays.asList(
              Optional.empty(),
              Optional.of("Ali"),
              Optional.empty(),
              Optional.of("Omar")
          );

          List<String> nonEmpty = optionals.stream()
                                           .filter(Optional::isPresent)
                                           .map(Optional::get)
                                           .collect(Collectors.toList());

          System.out.println("Non-empty values: " + nonEmpty);

        
   //------ Map a list of strings to their lengths.
              
      Map<String, Integer> nameLengthMap = names.stream()
							              .filter(Objects::nonNull)
							              .collect(Collectors.toMap(
							                  name -> name,
							                  String::length
							              ));

          nameLengthMap.forEach((name, length) ->
              System.out.println(name + " → Length: " + length));

   //------ Return a list of uppercased words that start with “A”.

      List<String> upperCaseWords = names.stream()
						          .filter(Objects::nonNull)
						          .filter(word -> word.toLowerCase().startsWith("a"))
						          .map(String::toUpperCase)
						          .collect(Collectors.toList());

          System.out.println("Uppercased words starting with 'A': " + upperCaseWords);


    //------- Find the second highest number in a list.
      
      Optional<Integer> secondHighest = numbers.stream()
              .distinct()
              .sorted(Comparator.reverseOrder())
              .skip(1)
              .findFirst();

          secondHighest.ifPresentOrElse(
              val -> System.out.println("Second highest: " + val),
              () -> System.out.println("No second highest value found.")
          );

   //------- Find duplicate elements in a list of integers.
          
      Set<Integer> seen = new HashSet<>();
      Set<Integer> duplicates = numbers.stream()
          .filter(n -> !seen.add(n)) 
          .collect(Collectors.toSet());

      System.out.println("Duplicates: " + duplicates);

   //------- Remove null or empty strings from a list using stream.
      List<String> cleaned = names.stream()
              .filter(Objects::nonNull)              
              .filter(s -> !s.trim().isEmpty())    
              .collect(Collectors.toList());

          System.out.println("Cleaned list: " + cleaned);


   //------- Partition students into pass/fail groups based on grade.
          
	  Map<Boolean, List<Student>> partitioned = students.stream()
	          .collect(Collectors.partitioningBy(s -> s.getGrade() >= 60));
	
	      System.out.println(" Passed Students:");
	      partitioned.get(true).forEach(s ->
	          System.out.println(" - " + s.getName() + " (" + s.getGrade() + ")"));
	
	      System.out.println(" Failed Students:");
	      partitioned.get(false).forEach(s ->
	          System.out.println(" - " + s.getName() + " (" + s.getGrade() + ")"));

        
	}
}
