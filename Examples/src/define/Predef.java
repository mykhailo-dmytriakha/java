package define;

public class Predef {
    public static void require(Boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void requier(Boolean condition) {
        require(condition, "");
    }
}
