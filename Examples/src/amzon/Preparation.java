package amzon;

public class Preparation {
    public static void main(String[] args) {
        Node rootNode = new Node(7);
        rootNode.addValue(4);
        rootNode.addValue(5);
        rootNode.addValue(5);
        rootNode.addValue(10);
        rootNode.addValue(2);
        rootNode.addValue(5);
        rootNode.addValue(9);
        rootNode.isValueExist(9);
    }
}

class Node {
    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public void addValue(int value) {
        if (this.value != value) {
            if (value > this.value) {
                if (rightNode == null) {
                    rightNode = new Node(value);
                } else {
                    rightNode.addValue(value);
                }
            } else {
                if (leftNode == null) {
                    leftNode = new Node(value);
                } else {
                    leftNode.addValue(value);
                }
            }

        }
    }

    public boolean isValueExist(int i) {
        if (value == i) {
            return true;
        } else if (i > value) {
            if (rightNode == null) {
                return false;
            } else {
                return rightNode.isValueExist(i);
            }
        } else {
            if (leftNode == null) {
                return false;
            } else {
                return leftNode.isValueExist(i);
            }
        }
    }
}
