package MiscJava;

public abstract class Nested implements TwoMethods {
    class Node {
        int data;

        public Node() {
            System.out.println("New node was created!");
        }
    }

    public static void main(String[] args) {
        // Nested n = new Nested();
        // Node node = n.new Node();
        // n
        System.out.println("Compiles");

    }

    public void hello() {
        System.out.println("Hello from Nested");
        System.out.println("An abstract class does not need to implement all of an interface's methods.");
    }
}

interface TwoMethods {

    void hello();

    void bye();
}