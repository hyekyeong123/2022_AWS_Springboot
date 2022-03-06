package com.codingcat.config.auth;

import com.codingcat.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        // 파라미터에 @LoginUser가 붙어있는지 확인
        boolean isLoginUserAnnotation = parameter
                .getParameterAnnotation(LoginUser.class) != null;

        // 파라미터 클래스 타입이 SessionUser.class인지 확인
        boolean isUserClass = SessionUser
                .class.equals(parameter.getParameterType());

        return isLoginUserAnnotation && isUserClass;
    }

    // 세션에서 객체 가져오기
    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) throws Exception {
         return httpSession.getAttribute("user");
    }
}