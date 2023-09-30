import java.util.*;

public class build_AVL_Trees {
    static class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right) + 1);
        x.height = Math.max(height(x.left), height(x.right) + 1);

        // Return new root
        return x;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Duplicate keys not allowed
        }
        // update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get root's balance factor
        int bf = getBalance(root);

        // left left case
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Right Right case
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Left Right Case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right left Case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; // returned if AVL balanced
    }

    // Left rotate subtree rooted with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // perform rotation
        y.left = x;
        x.right = T2;

        // update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    public static void levelOrder(Node root) {
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

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        levelOrder(root);
    }
}

/*
 * Output:
 * 40
 * 20 50
 * 10 30
 * 25
 */
/*The provided Java code implements an AVL Tree (Adelson-Velsky and Landis Tree), a self-balancing binary search tree. AVL Trees ensure that the tree remains balanced after insertions and deletions, which helps maintain efficient search and retrieval operations. Here's a description of how the code works:

Node Class: The code defines an inner class called Node, which represents a node in the AVL tree. Each node has an integer value (data), a height (height), and references to its left and right children (left and right). The height of a node is the length of the longest path from that node to a leaf.

Static Variables: The code includes a static variable root to represent the root of the AVL tree.

Height and Balance Factor Functions:

height(Node root): This function calculates and returns the height of a given node. If the node is null, it returns 0.
getBalance(Node root): This function calculates and returns the balance factor of a node. The balance factor is the difference between the height of the left subtree and the height of the right subtree.
Rotation Functions:

rightRotate(Node y): This function performs a right rotation on a given node y. It is used to balance the tree when the left subtree is taller than the right subtree.
leftRotate(Node x): This function performs a left rotation on a given node x. It is used to balance the tree when the right subtree is taller than the left subtree.
Insertion Function (insert):

The insert function recursively inserts a new node with a given key into the AVL tree.
It calculates and updates the height of each node during the insertion process.
It also checks the balance factor of each node and performs rotations as needed to maintain AVL tree properties.
Level Order Traversal (levelOrder):

The levelOrder function performs a level-order traversal of the AVL tree and prints the nodes at each level.
It uses a queue to traverse the tree level by level and prints the nodes accordingly.
Main Function:

In the main function, a sample AVL tree is created by inserting the values 10, 20, 30, 40, 50, and 25 into the tree.
The levelOrder function is then called to print the tree in level order.
Output:

The expected output, as indicated in the code comments, is a level-order traversal of the AVL tree. The tree is balanced, and the output shows the nodes arranged by their levels.
Overall, this code demonstrates the construction and insertion into an AVL tree, with rotations to maintain balance when necessary, and then displays the tree in a level-order fashion to showcase its structure.*/
