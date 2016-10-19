package edu.mum.quiz.app.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.mum.quiz.domain.User;
import edu.mum.quiz.service.security.interfaces.UserService;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(ExecuteTimeInterceptor.class);
	@Autowired
	UserService userService;

	// before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);

		return true;
	}

	// after the handler is executed
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {

		long startTime = (Long) request.getAttribute("startTime");

		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;
		try {
			User user = userService.getLoggedInUser();
			mv.addObject("user", user);
		} catch (Exception ex) {
		}
		// modified the exisitng modelAndView
		// mv.getModel().put("executeTime",executeTime);

		// log it
		// if(logger.isDebugEnabled()){
		logger.info("[" + handler + "] executeTime : " + executeTime + "ms");
		// }
	}
}