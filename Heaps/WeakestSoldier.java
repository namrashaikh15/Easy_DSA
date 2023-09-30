/* 
 *                        Problem: Weakest Soldier
 *  We are given an m x n binary matrix of 1's(soldiers) and 0's(civilians)..
 *  the soldiers are positioned in front of the civilians. that is, all the 1's
 *  will appear to the left of all the 0's in each row.
 * 
 *  A row i is weaker than a row j if one of the following is true:
 *    -> The number of soldiers in row i is less then the number of
 *        soldiers in row j.
 *    -> Both rows have the same number of soldiers and i<j.
 *  Find the K weakest rows.
 * 
 *  m=4,n=4,k=2   ans = row0 & row2
 *  1000
 *  1111
 *  1000
 *  1000
 * 
 */

import java.util.PriorityQueue;

public class WeakestSoldier {

    static class Row implements Comparable<Row> {
        int soldiers;
        int index;

        Row(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override
        public int compareTo(Row row) {
            if (this.soldiers == row.soldiers) {
                return this.index - row.index;
            } else {
                return this.soldiers - row.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int k = 3;
        int matrix[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int soldiers = 0;
            for (int j = 0; j < m; j++) {
                soldiers = soldiers + matrix[i][j];
            }
            pq.add(new Row(soldiers, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("R" + pq.remove().index);
        }
    }
}

/*
 * Output:
 * R0
 * R2
 * R3
 */
*/

The provided Java program solves the problem of finding the K weakest rows in a binary matrix where each row contains soldiers (represented by 1's) and civilians (represented by 0's). Rows are considered weaker if they have fewer soldiers or if they have the same number of soldiers but appear earlier in the matrix. Here's a description of the program:

Row Class:

The Row class is a custom class created to store information about a row. It includes two fields: soldiers (the count of soldiers in the row) and index (the row's index in the matrix). The class also implements the Comparable interface, allowing rows to be compared based on the number of soldiers and row index.
Main Method:

The main method initializes the parameters for the problem, including the size of the matrix (n and m), the number of weakest rows to find (k), and the binary matrix itself (matrix).
PriorityQueue:

A PriorityQueue named pq is created to store instances of the Row class. The priority queue uses a custom comparator defined in the Row class, which ensures that rows with fewer soldiers are given higher priority. In case of a tie (rows with the same number of soldiers), the row with the lower index is prioritized.
Counting Soldiers:

The program iterates through each row of the matrix. For each row, it counts the number of soldiers by summing the elements in the row. This count, along with the row index, is used to create a Row object, which is then added to the priority queue.
Finding K Weakest Rows:

After adding all rows to the priority queue, the program extracts the K weakest rows by repeatedly removing the top element from the priority queue and printing its index. This process ensures that the weakest rows (with fewer soldiers and lower indices) are processed first.
Output:
The program correctly finds the K weakest rows based on the given criteria and prints their indices. In the provided example, the matrix contains 4 rows, and the program is tasked with finding the 3 weakest rows. The output reflects the indices of the weakest rows:

Copy code
R0
R2
R3
In this case, rows 0, 2, and 3 are considered the weakest, and their indices are printed in ascending order
    */
