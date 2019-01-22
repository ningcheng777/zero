package zero.common.singleton;

public class DLCSingleton {

    private DLCSingleton() {

    }

    private volatile static DLCSingleton INSTANCE;

    public static final DLCSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DLCSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DLCSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
