/**
 * This class models a school which has 100 lockers and 100 students. Initially, the first student, which is denoted
 *  as S1, opens every locker. The second student, S2 respectively, begins with the second locker, which is denoted
 *  L2, and closes every other locker. S3 begins with the third locker and changes every third locker (closes if it was
 *  open, and opens if it was closed) . . . until S100 changes L100
 *
 * @author Mohammad Abdulhussain
 *
 */

import java.util.Arrays;

public class SchoolLockers
{
    public static void main(String[] args) {
        String[] lockers = new String[100];

        // Close all the lockers in the method
        studentClosedLockers(lockers);

        // Invoke the studentLockerChanges method
        studentLockerChanges(lockers);

        // Display all open lock numbers in the output
        display(lockers);
    }

    /**
     * studentLockersOpen returns true if l is the string "OPEN", otherwise it returns false
     *
     */
    public static boolean studentLockersOpen(String l) {
        return l.equals("OPEN");
    }

    /**
     * studentClosedLockers fills the array with the string "CLOSED"
     * Arrays.fill is a method in .Arrays class that assigns the data type to each value in the array. An if statement
     * can also substitute this method
     */

    public static void studentClosedLockers(String[] lockers) {
        Arrays.fill(lockers, "CLOSED");
    }

    /**
     * studentLockerChanges changes the string in each element from "CLOSED" to "OPEN" or Vice versa depending on
     * whether the student is S1 . . . to S100, and L1 . . . to L100
     */

    public static void studentLockerChanges(String[] lockers) {
        int start = 0; // Locker student begins with S1

        for (int s = 1; s <= lockers.length; s++) {
            for (int l = 0; l < lockers.length; l += s) {
                if (studentLockersOpen(lockers[l]))
                    lockers[l] = "CLOSED";
                else
                    lockers[l] = "OPEN";
            }
            start++;
        }
    }

    /**
     * displays all open locker numbers separated by a row for each answer
     */

    public static void display(String[] lockers) {
        for (int i = 0; i < lockers.length; i++) {
            if (studentLockersOpen(lockers[i])) {
                System.out.println("Locker " + (i + 1) + " is open " +
                        "\n");
            }
        }
        System.out.println();
    }
}
