package zero.common.base.controller;

import zero.common.base.session.OpsSession;

/**
 * @author ningcheng
 * @date 2018/1/8
 */
public class BaseController {

    protected String getOper() {
        return OpsSession.getUser().getId();
    }
}
