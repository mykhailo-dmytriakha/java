package _leetCode.linkedlist;

/*
You are given a Double Link List with one pointer of each node pointing to the next node just like in a single link list.
The second pointer however CAN point to any node in the list and not just the previous node.
Now write a program in O(n) time to duplicate this list. That is, write a program which will create a copy of this list.
https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
 */

import java.util.HashMap;
import java.util.Map;

public class CopyRandomLinkedList {
    public static void main(String[] args) {
        Node root = createRandomLinkedList();
        print(root);
        System.out.println("---------------------------------------");
        Node copiedList = copy(root);
        print(copiedList);
    }

    static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            Node random = temp.randomNode;
            Node next = temp.nextNode;
            int randomData = (random != null) ? random.value : -1;
            int nextData = (next != null) ? next.value : -1;
            System.out.println("Data = " + temp.value +
                               ", Next data = " + nextData +
                               ", Random data = " + randomData);
            temp = temp.nextNode;
        }
    }

    private static Node copy(Node root) {
        if (root == null) {
            return null;
        }
        Node head = root;

        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node newNode = new Node();
            newNode.value = head.value;
            map.put(head, newNode);
            head = head.nextNode;
        }

        head = root;
        while (head != null) {
            Node newNode = map.get(head);
            newNode.nextNode = map.get(head.nextNode);
            newNode.randomNode = map.get(head.randomNode);
            head = head.nextNode;
        }

        return map.get(root);
    }

    private static Node createRandomLinkedList() {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node4.value = 4;
        node5.value = 5;

        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;
        node5.nextNode = null;

        node1.randomNode = node3;
        node2.randomNode = node1;
        node3.randomNode = node5;
        node4.randomNode = node3;
        node5.randomNode = node2;
        return node1;
    }

}

class Node {
    int value;
    Node nextNode;
    Node randomNode;

    public boolean hasNext() {
        return nextNode != null;
    }
}
