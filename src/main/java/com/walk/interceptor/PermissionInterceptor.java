package com.walk.interceptor;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws IOException {
		
		// 요청 url path를 꺼낸다.
		String uri = request.getRequestURI();
		//log.info("[&&&&&&&& preHandle] uri:{}", uri);  -- clone push test
		
		// request에서 로그인 여부를 꺼낸다
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 비로그인 && '/post'로 접속 => 로그인 페이지로 이동, 컨트롤러 수행 방지
		if (userId == null && uri.startsWith("/post")) {
			response.sendRedirect("/user/sign-in-view");
			return false;  // 원래 요청주소에 대한 컨트롤러 수행 X
		}
		
		// 로그인 && '/user'로 접속 => 글목록 페이지로 이동, 컨트롤러 수행 방지
		if (userId != null && uri.startsWith("/user")) {
			response.sendRedirect("/post/post-list-view");
			return false;  // 원래 요청주소에 대한 컨트롤러 수행 X
		}
		
		return true;  // true일때 컨트롤러 수행
	}
}
