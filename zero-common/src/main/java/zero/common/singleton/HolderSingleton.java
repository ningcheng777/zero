package zero.common.singleton;

public class HolderSingleton {

    private HolderSingleton() {

    }

    private static class Holder {
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public final static HolderSingleton getInstance() {
        return Holder.INSTANCE;
    }

}
