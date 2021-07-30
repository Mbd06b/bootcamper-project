package com.organization.mvcproject.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.app.model.ReviewImpl;
@Controller
public class ReviewController {
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
		return new ModelAndView("review", "command", new ReviewImpl());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(ReviewImpl review, ModelMap model) {
		if (review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
		return new ModelAndView("result", "submittedReview", review);
	}
}

