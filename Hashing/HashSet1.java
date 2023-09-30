import java.util.HashSet;

public class HashSet1 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(2);
        hs.add(3);
        System.out.println(hs);
        hs.remove(3);
        System.out.println(hs);
        System.out.println(hs.contains(3));
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());
    }
}

/*
 * Output:
 * [1, 2, 3]
 * [1, 2]
 * false
 * 2
 * false
 */
*/HashSet Initialization:

A HashSet named hs of type Integer is created.
Adding Elements to the HashSet:

The program adds the integers 1, 2, and 3 to the HashSet hs.
Note that HashSet does not allow duplicate elements, so even if 2 and 3 are added multiple times, they will be stored only once in the HashSet.
Printing the HashSet:

After adding elements, the program prints the contents of the HashSet using System.out.println(hs). The output shows the unique elements stored in the HashSet.
Removing an Element:

The program removes the integer 3 from the HashSet using hs.remove(3). This operation removes the element 3 from the HashSet.
Checking for an Element:

The program checks whether the HashSet contains the integer 3 using hs.contains(3). Since 3 was removed earlier, this operation returns false, indicating that the element is not present in the HashSet.
Getting the Size:

The program prints the size of the HashSet using hs.size(). At this point, the HashSet contains two elements (1 and 2), so the output is 2.
Checking if the HashSet is Empty:

The program checks if the HashSet is empty using hs.isEmpty(). Since the HashSet contains elements, this operation returns false, indicating that the HashSet is not empty.
Output:
The program demonstrates the behavior of a HashSet when adding, removing, and checking for elements. The output matches the operations described above:

csharp
Copy code
[1, 2, 3]
[1, 2]
false
2
false
The first line shows the initial state of the HashSet with elements 1, 2, and 3. After removing 3, the HashSet contains only 1 and 2. The program correctly reports that 3 is not present in the HashSet, the size is 2, and the HashSet is not empty.






