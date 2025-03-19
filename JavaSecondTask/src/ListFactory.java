import java.util.*;

public class ListFactory {
    // Factory method to return an instance of a List type
    public static List<?> getList(String listType) {
        if (listType.equalsIgnoreCase("arraylist")) {
            return new ArrayList<>();
        } else if (listType.equalsIgnoreCase("linkedlist")) {
            return new LinkedList<>();
        } else if (listType.equalsIgnoreCase("vector")) {
            return new Vector<>();
        } else if (listType.equalsIgnoreCase("stack")) {
            return new Stack<>();
        }
        return null; // Return null if the input type is invalid
    }
}
