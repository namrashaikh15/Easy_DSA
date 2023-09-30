
/*
 *    @Level Order Treversal
 */

import java.util.*;
import java.util.LinkedList;

public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        tree.levelOrder(root);

    }
}

/*
 * Output:
 * 1
 * 2 3
 * 4 5 6
 */
*/Node Class: This class defines the structure of a binary tree node. Each node has an integer data value, a left child, and a right child.

BinaryTree Class: This class contains methods related to binary trees.

buildTree Function: This function is used to construct a binary tree from an input array of integers. It follows a recursive approach. It reads the next element from the array and, if it is not -1 (indicating a null node), creates a new node with that value and recursively calls itself to create the left and right subtrees.

levelOrder Function: This function performs a level-order traversal of the binary tree using a queue. It starts with the root node, adds it to the queue, and processes nodes level by level. It prints each node's data as it is removed from the queue. To mark the end of each level, it inserts a null into the queue, and when a null is encountered, a new line is printed to separate levels.

main Function: The main method initializes an array of integers representing a binary tree structure. It then creates an instance of the BinaryTree class, constructs the binary tree using the buildTree function, and finally calls the levelOrder function to perform a level-order traversal and print the nodes in level-order.

Output:
The program demonstrates the level-order traversal of a binary tree. It prints the nodes of the binary tree in a format where each level of nodes is on a separate line, as shown in the provided output.
