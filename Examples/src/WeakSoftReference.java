import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakSoftReference {

    public static void main(String[] args) throws InterruptedException {
        List<SoftReference<byte[]>> list = new ArrayList<>();
        while (true) {
            System.out.println();
            for (SoftReference<byte[]> ref : list) {
                System.out.print(ref.get() == null ? "*" : "E");
            }
            list.add(new SoftReference<>(new byte[10_000_000]));
            Thread.sleep(100);
        }
    }
}
