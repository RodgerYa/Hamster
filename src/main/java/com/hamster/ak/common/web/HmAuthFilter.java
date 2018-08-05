package com.hamster.ak.common.web;

import com.google.common.collect.Sets;
import com.hamster.ak.common.exception.HmException;
import com.hamster.ak.api.ThreadLocalUser;
import com.hamster.ak.api.Token;
import com.hamster.ak.api.TokenService;
import com.hamster.ak.api.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@WebFilter
@Component
public class HmAuthFilter extends OncePerRequestFilter {

    private Set<String> checkedUrl = Sets.newHashSet();

    @Autowired
    private TokenService tokenService;

    @PostConstruct
    public void postConstruct() {
        checkedUrl.add("/user/login");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws IOException, ServletException {
        String url = httpServletRequest.getRequestURI();

        if (!checkedUrl.contains(url)) {
            String tokenStr = httpServletRequest.getHeader("token").trim();
            if (StringUtils.isEmpty(tokenStr)) {
                logger.error("请求header 不存在 token");
                return;
            }

            Token token = null;
            try {
                token = tokenService.decodeToken(tokenStr);
                Optional.ofNullable(token).orElseThrow(() -> new HmException("token 解析失败"));
            } catch (Exception e) {
                // todo 闫文博 根据decodeToken 方法的实现 catch 不同的exception 进行分类返回错误码
            }

            User user = User.builder().name(token.getUserName()).id(token.getUserId()).build();

            ThreadLocalUser.setUser(user);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
