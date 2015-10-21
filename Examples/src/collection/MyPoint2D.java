package collection;

/**
 * Created by mdmytiaha on 21-Oct-15.
 */
public class MyPoint2D implements Comparable<MyPoint2D>{
    private final int x;
    private final int y;

    public MyPoint2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "MyPoint2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPoint2D myPoint2D = (MyPoint2D) o;

        if (x != myPoint2D.x) return false;
        return y == myPoint2D.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public int compareTo(MyPoint2D that) {
        if((this.x - that.x) != 0 ) {
            return this.x - that.x;
        }else {
            return this.y - that.y;
        }
    }
}
