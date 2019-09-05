package part3.exercise;

import part3.MyLinkedList;

import java.util.Iterator;

public class Q3<AnyType> extends MyLinkedList<AnyType> {

    public boolean contains(AnyType x) {

        Iterator<AnyType> it = iterator();
        while (it.hasNext()) {
            AnyType curr = it.next();
            if (curr.equals(x))
                return true;
        }
        return false;
    }
}
