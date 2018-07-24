package com.shubham.projectmanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerForNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "404-Page Not Found");
		mv.addObject("errorTitle", "404-Page Not Found");
		mv.addObject("errorDescription", "The Page You Are Looking For Doesn't Exist..");
		return mv;
	}
	/*For generalized Exception*/
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerForException(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "Error-Page Not Found");
		mv.addObject("errorTitle", "Error-Page Not Found");
		mv.addObject("errorDescription", ex.toString());
		return mv;
	}
}
