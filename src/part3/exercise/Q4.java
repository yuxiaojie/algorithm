package part3.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Q4 {

    public static <AnyType extends Comparable<? super AnyType>> List<AnyType>  intersection(List<AnyType> l1, List<AnyType> l2) {

        List<AnyType> result = new ArrayList<>();
        AnyType curr1 = null, curr2 = null;
        Iterator<AnyType> it1 = l1.iterator();
        Iterator<AnyType> it2 = l2.iterator();

        while (true) {

            if (curr1 == null)
                if (it1.hasNext())
                    curr1 = it1.next();
                else
                    break;

            if (curr2 == null)
                if (it2.hasNext())
                    curr2 = it2.next();
                else
                    break;

            if (curr1.compareTo(curr2) > 0) {
                curr2 = null;
            } else if (curr1.compareTo(curr2) < 0) {
                curr1 = null;
            } else {
                result.add(curr1);
                curr1 = null;
                curr2 = null;
            }
        }

        return result;
    }

    public static void main(String[] args) {


        List<Integer> l1 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 19);
        List<Integer> l2 = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);

        System.out.println(intersection(l1, l2));
    }
}
