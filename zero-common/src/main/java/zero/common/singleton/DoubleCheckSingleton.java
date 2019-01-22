package zero.common.singleton;

public class DoubleCheckSingleton {

    private DoubleCheckSingleton() {

    }

    private volatile static DoubleCheckSingleton INSTANCE;

    public static final DoubleCheckSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
