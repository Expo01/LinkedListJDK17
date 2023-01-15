import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

//        LinkedList<String> placesToVisit = new LinkedList<>(); can specify type collection like this, or as 'var'

        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra"); //how are we adding at an index if LinkedList don't have indexes?
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

        gettingElements(placesToVisit);

        printItinerary3(placesToVisit);

    }

    private static void addMoreElements(LinkedList<String> list) {

        list.addFirst("Darwin"); //items added as a list
        list.addLast("Hobart");
        // Queue methods- appears to be FIFO construct (first in last out)
        list.offer("Melbourne"); //items added as a que
        list.offerFirst("Brisbane"); //items added as double ended que
        list.offerLast("Toowoomba");
        // Stack Methods - appears to be a LIFO construct (last in first out)
        list.push("Alice Springs"); // items added as stack (equivalent of addFirst or offerFirst Que construct)

    }

    private static void removeElements(LinkedList<String> list) {

        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove(); // removes first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst(); // removes first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast(); // removes last element
        System.out.println(s3 + " was removed");
        // Queue/Deque poll methods
        String p1 = list.poll();  // removes first element
        System.out.println(p1 + " was removed");
        String p2 = list.pollFirst();  // removes first element
        System.out.println(p2 + " was removed");
        String p3 = list.pollLast();  // removes last element
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop();  // removes first element
        System.out.println(p4 + " was removed");

    }

    private static void gettingElements(LinkedList<String> list) {

        System.out.println("Retrieved Element = " + list.get(4));

        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " +
                list.lastIndexOf("Melbourne"));
        // Queue retrieval method
        System.out.println("Element from element() = " + list.element());
        // Stack retrieval methods
        System.out.println("Element from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list) { //regular for loop

        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list) { //enhanced for loop

        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst(); //problem here is start location will print twice which is limiting factor
        // of the advanced for loop is it goes through every element from the very first to the very last
        for (String town : list) {
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list) {

        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1); // ListIterator used where I can specify the index
        // where iteration will begin
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
    }
}