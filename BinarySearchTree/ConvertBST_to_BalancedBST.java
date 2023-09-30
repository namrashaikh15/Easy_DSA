import java.util.*;
/*
 *   Convert BST to Balanced BST
 */

public class ConvertBST_to_BalancedBST {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
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

    public static Node buildBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data > data) {
            root.left = buildBST(root.left, data);
        } else {
            root.right = buildBST(root.right, data);
        }
        return root;
    }

    public static void sortedArray(ArrayList<Integer> arr, Node root) {
        if (root == null) {
            return;
        }
        sortedArray(arr, root.left);
        arr.add(root.data);
        sortedArray(arr, root.right);
    }

    public static Node balancedBST(ArrayList<Integer> arr, int si, int ei) {
        int mid = si + (ei - si) / 2;
        if (si > ei) {
            return null;
        }
        Node root = new Node(arr.get(mid));
        root.left = balancedBST(arr, si, mid - 1);
        root.right = balancedBST(arr, mid + 1, ei);
        return root;
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static Node convertBST_to_balancedBST(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();

        sortedArray(arr, root);

        // printArray(arr);
        return balancedBST(arr, 0, arr.size() - 1);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = { 8, 6, 10, 5, 11, 3, 12 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = buildBST(root, arr[i]);
        }
        // inOrder(root);
        levelOrder(root);
        System.out.println();
        root = convertBST_to_balancedBST(root);
        // inOrder(root);
        levelOrder(root);
    }
}

/*
 * Output:
 * 8
 * 6 10
 * 5 11
 * 3 12
 * 
 * 8
 * 5 11
 * 3 6 10 12
 * 
 */
*/Node Class: This class defines the structure of a binary tree node. Each node has an integer data value, a left child, and a right child.

levelOrder Function: This function is used to print the BST in level-order (also known as breadth-first traversal). It uses a queue to traverse the tree level by level and prints the nodes at each level, separating them with line breaks.

buildBST Function: This function is used to build a BST. It takes an existing root node and an integer value as input and recursively inserts the value into the BST based on the BST property (left subtree contains values less than the node, right subtree contains values greater than the node).

sortedArray Function: This function performs an in-order traversal of the BST and populates an ArrayList with the node values in sorted order.

balancedBST Function: This function takes a sorted ArrayList and constructs a balanced BST from it. It calculates the middle index of the array and uses the value at that index as the root of the current subtree. It then recursively constructs the left and right subtrees from the portions of the array to the left and right of the middle index.

convertBST_to_balancedBST Function: This function serves as the main driver for the conversion process. It first creates an ArrayList by performing an in-order traversal of the original BST. Then, it calls the balancedBST function to construct a balanced BST using the sorted values.

inOrder Function: This function performs an in-order traversal of a tree and prints its nodes in sorted order.

main Function: The main method initializes an array of integers and constructs an initial BST by inserting the array elements into it. It then prints the original BST in level-order, converts it to a balanced BST using the convertBST_to_balancedBST function, and finally prints the balanced BST in level-order.

Output:
The program demonstrates the conversion of an unbalanced BST into a balanced BST. It first prints the original unbalanced BST in level-order and then prints the balanced BST in level-order, showing the difference in the structure of the trees.





Regenerate
