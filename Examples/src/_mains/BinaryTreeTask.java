package _mains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * @author by Mykhailo on 8/1/2018.
 */
public class BinaryTreeTask {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        Collections.addAll(input, 5, 6, 3, 4, 1, 2, 8, 11, 7, 9, 10);
        int value1 = 7;
        int value2 = 1;
        BinaryTree binaryTree = createBinaryTree(input);
        int numberOfEdges = binaryTree.getNumberOfEdgesBetweenNodes(value1, value2);
        System.out.println(numberOfEdges);
    }

    private static BinaryTree createBinaryTree(ArrayList<Integer> input) {
        BinaryTree binaryTree = new BinaryTree(new Node(input.get(0), ""));
        for (int i = 1; i < input.size(); i++) {
            binaryTree.addNode(input.get(i));
        }
        return binaryTree;
    }
}

class BinaryTree {
    private Node root;

    BinaryTree(Node node) {
        root = node;
        root.rootPath = "";
    }

    public void addNode(int value) {
        addNodeRecursively(value, root, root.rootPath);
    }

    private Node addNodeRecursively(int value, Node currentNode, String rootPath) {
        if (currentNode == null) {
            return new Node(value, rootPath);
        }

        if (value < currentNode.value) {
            currentNode.leftNode = addNodeRecursively(value, currentNode.leftNode, currentNode.rootPath + "l");
        } else {
            currentNode.rightNode = addNodeRecursively(value, currentNode.rightNode, currentNode.rootPath + "r");
        }
        return currentNode;
    }

    public int getNumberOfEdgesBetweenNodes(int value1, int value2) {
        Node node1 = findNode(value1);
        Node node2 = findNode(value2);
        if (Objects.isNull(node1) || Objects.isNull(node2)) {
            return -1;
        }
        String rootPath1 = node1.rootPath;
        String rootPath2 = node2.rootPath;
        while (rootPath1.charAt(0) == rootPath2.charAt(0)) {
            rootPath1 = rootPath1.substring(1);
            rootPath2 = rootPath2.substring(1);
        }
        return (rootPath1 + rootPath2).length();
    }

    public Node findNode(int value) {
        return findNodeRecursively(root, value);
    }

    private Node findNodeRecursively(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.value == value) {
            return currentNode;
        }

        if (value < currentNode.value) {
            return findNodeRecursively(currentNode.leftNode, value);
        } else {
            return findNodeRecursively(currentNode.rightNode, value);
        }
    }
}

class Node {
    Node leftNode;
    Node rightNode;
    int value;
    String rootPath;

    Node(int value, String rootPath) {

        this.value = value;
        this.rootPath = rootPath;
        leftNode = rightNode = null;
    }
}
