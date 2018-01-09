package zero.common.base.filter;

import zero.common.base.session.OpsSession;
import zero.common.base.session.OpsUser;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ningcheng
 * @date 2017/11/22
 */
public class OpsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        OpsUser user = new OpsUser();
        String userId = String.valueOf(request.getAttribute("opsid"));
        if (userId != null) {
            user.setId(userId);
        }
        OpsSession.setUser(user);
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
