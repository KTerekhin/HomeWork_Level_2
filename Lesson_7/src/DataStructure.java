public class DataStructure {

    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {
        TwoLinkedList list = new TwoLinkedList();
        list.addFirst("1");
        list.addLast("2");
        list.addFirst("3");
        list.addLast("4");
        list.addFirst("5");
        list.displayList();
        System.out.println("Size: " + list.size());
        System.out.println("Removing: value 8");
        System.out.println("Removed? - " + list.remove("8"));
        System.out.print("New ");
        list.displayList();
        System.out.println("New size: " + list.size());

        System.out.println("Removing: value 8");
        System.out.println("Removed? - " + list.remove("8"));
        System.out.println("Removing: value 1");
        System.out.println("Removed? - " + list.remove("1"));
        System.out.print("New ");
        list.displayList();
        System.out.println("New size: " + list.size());

        System.out.println("Removing: value 8");
        System.out.println("Removed? - " + list.remove("8"));
        System.out.println("Removing: value 4");
        System.out.println("Removed? - " + list.remove("4"));
        System.out.print("New ");
        list.displayList();
        System.out.println("New size: " + list.size());

        System.out.println("Removing: value 8");
        System.out.println("Removed? - " + list.remove("8"));
        System.out.println("Removing: value 5");
        System.out.println("Removed? - " + list.remove("5"));
        System.out.print("New ");
        list.displayList();
        System.out.println("New size: " + list.size());
        System.out.println("Removing: value 8");
        System.out.println("Removed? - " + list.remove("8"));
        System.out.println("Removing: value 5");
        System.out.println("Removed? - " + list.remove("3"));
        System.out.print("New ");
        list.displayList();
        System.out.println("New size: " + list.size());
        System.out.println("Removing: value 8");
        System.out.println("Removed? - " + list.remove("8"));
        System.out.println("Removing: value 5");
        System.out.println("Removed? - " + list.remove("2"));
        System.out.print("New ");
        list.displayList();
        System.out.println("New size: " + list.size());
    }
}
