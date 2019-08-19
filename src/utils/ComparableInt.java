package utils;

public class ComparableInt implements Comparable<ComparableInt> {

    private int x;

    public ComparableInt(int x) {
        this.x = x;
    }

    @Override
    public int compareTo(ComparableInt o) {
        if (this.x == o.x)
            return 0;
        return this.x > o.x ? 1 : -1;
    }
}
