package part3.exercise;

import part3.MyArrayList;

public class Q9<AnyType> extends MyArrayList<AnyType> {

    Q9() {
        super();
    }

    /**
     * 时间复杂度为 O(n)
     * 都是添加到末端，所以不需要移动元素，ArrayList 可以随机访问所以添加的时间复杂度是 O(1)
     *
     * @param items
     */
    public void addALl(Iterable<? extends AnyType> items) {
        for (AnyType item : items)
            add(item);
    }
}
