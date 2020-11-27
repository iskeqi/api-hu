package com.keqi.apihu.core.interceptor;

import com.keqi.apihu.core.common.Auth;
import com.keqi.apihu.core.common.LoginUserBO;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.core.pojo.CommonConstant;
import com.keqi.apihu.core.util.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全拦截器(进行accessToken的鉴权等)
 *
 * @author keqi
 */
@Component("securityInterceptor")
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();

        String projectIdStr = request.getHeader(CommonConstant.PROJECT_ID);
        String accessToken = request.getHeader(CommonConstant.ACCESS_TOKEN);

        // 通过 header 中的 accessToken 属性来获取当前登录用户信息
        LoginUserBO loginUserBO = JWTUtil.resolveToken(accessToken);
        if (StringUtils.isEmpty(accessToken) || loginUserBO == null) {
            throw new BusinessException("当前操作用户未登录");
        }
        loginUserBO.setProjectId(StringUtils.isEmpty(projectIdStr) ? null : Long.valueOf(projectIdStr));
        // 设置当前操作用户信息到当前线程对象中
        Auth.setLoginUserBO(loginUserBO);


        if (requestURI.startsWith("/pj/") || requestURI.startsWith(contextPath + "/pj/")) {
            // 设置当前请求操作的项目ID（如果 URI 是以 /contextPath/pj/ 或者是以 /pj/ 开头的，那么必须要包含 projectId）
            if (StringUtils.isEmpty(projectIdStr)) {
                throw new BusinessException("非法操作");
            }
        }

        return true;
    }

}
