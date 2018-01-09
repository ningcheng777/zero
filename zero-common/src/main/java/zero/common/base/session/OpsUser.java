package zero.common.base.session;

/**
 * @author ningcheng
 * @date 2017/11/23
 */
public class OpsUser {

    private static final String DEFAULT_ID = "-";

    private String id;

    public OpsUser() {
        this.id = DEFAULT_ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
