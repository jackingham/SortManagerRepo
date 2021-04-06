package com.sparta.jack.sort;

import com.sparta.jack.exceptions.ChildNotFoundException;
import com.sparta.jack.interfaces.BinaryTree;


public class BinaryTreeSort implements BinaryTree {

    int numberOfElements = 0;
    Node root;

    public int getRootElement() {
        return root.value;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void addElements(int[] elements) {
        int currentElement = 0;
        for (int i : elements) {
            addElement(elements[currentElement++]);
        }
    }

    public void addElement(int element) {
            root = insertNode(root, element);
            numberOfElements++;

        }

    private Node insertNode(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }
        else if (value < currentNode.value) {
            currentNode.left = insertNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = insertNode(currentNode.right, value);
        } else {
            return currentNode;
        }
        return currentNode;
    }

    public boolean findElement(int value) {
        try {
            if (findNodeFromValue(root, value) != null) {
                return true;
            }
        } catch (ChildNotFoundException e) {
            return false;
        }
        return false;
    }


    private Node findNodeFromValue(Node root, int element) throws ChildNotFoundException {
        if (element == root.value) {
            return root;
        }
        try {
            return element < root.value ? findNodeFromValue(root.left, element) : findNodeFromValue(root.right, element);
        } catch (NullPointerException e) {
            throw new ChildNotFoundException("Element not in tree");
        }
    }

    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNodeFromValue(root, element);
        try {
            return node.left.value;
        } catch (NullPointerException e) {
            throw new ChildNotFoundException("No left child");
        }
    }


    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNodeFromValue(root, element);
        try {
            return node.right.value;
        } catch (NullPointerException e) {
            throw new ChildNotFoundException("No right child");
        }

    }

    int ascendingElementIndex;
    int[] ascendingArray;

    public int[] getSortedTreeAsc() {
        ascendingArray = new int[getNumberOfElements()];
        ascendingElementIndex = 0;
        traverseAsc(root);
        return ascendingArray;
    }

    private void traverseAsc(Node node){
        if (node != null) {
            traverseAsc(node.left);
            ascendingArray[ascendingElementIndex++] = node.value;
            traverseAsc(node.right);
        }

    }

    int descendingElementIndex;
    int[] descendingArray;

    public int[] getSortedTreeDesc() {
        descendingArray = new int[getNumberOfElements()];
        descendingElementIndex = 0;
        traverseDesc(root);
        return descendingArray;
    }

    private void traverseDesc(Node node){
        if (node != null) {
            traverseDesc(node.right);
            descendingArray[descendingElementIndex++] = node.value;
            traverseDesc(node.left);
        }

    }


    public class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

}



