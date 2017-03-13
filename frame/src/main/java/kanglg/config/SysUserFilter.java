package kanglg.config;

import kanglg.auth.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Shiro 过滤器
 * Created by kanglg on 2017/3/11.
 */
@Component
public class SysUserFilter extends PathMatchingFilter {
    private final UserService userService;

    @Autowired
    public SysUserFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (username != null) {
            request.setAttribute(Constants.CURRENT_USER, userService.findUserByAccount(username));
        }
        return true;
    }
}
