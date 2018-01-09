package zero.common.base.session;

/**
 * @author ningcheng
 * @date 2017/11/23
 */
public class OpsSession {

    private static ThreadLocal<OpsUser> local = new ThreadLocal<OpsUser>();

    public static void setUser(OpsUser user) {
        local.set(user);
    }

    public static OpsUser getUser() {
        return local.get();
    }
}
