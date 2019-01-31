package org.jagjeet.omtbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jagjeet.omtbs.model.Theatre;
import org.jagjeet.omtbs.model.Ticket;
import org.jagjeet.omtbs.model.User;
import org.jagjeet.omtbs.services.OmtbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OmtbsController {

	@Autowired
	private OmtbsService service;

	@RequestMapping(value = "doRegister", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user, ModelMap model, HttpServletRequest request) {
		if (user != null) {
			if (service.getUser(user)) {
				System.out.println("already a user");
			} else {

				int result = service.saveUser(user);
				request.setAttribute("StatusMessage", "User Saved Successfully");
				model.addAttribute("User added is: " + result);
				return "register";
			}
		}

		return "register";

	}

	@RequestMapping(value = "doLogin", method = RequestMethod.GET)
	public String doLogin(@ModelAttribute("user") User user, ModelMap model, HttpServletRequest request) {

		if (user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user); // setting session
			return "adminMenu";
		} else {

			int res = service.check(user);

			if (res == 0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				return "userMenu"; // redirecting to User menu
			} else {
				return "index";
			}
		}
	}

	@RequestMapping(value = "addMovie", method = RequestMethod.POST)
	public String addMovie(@ModelAttribute("theatre") Theatre theatre, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			return "adminMenu";
		}

		int result = service.saveMovie(theatre);
		request.setAttribute("StatusMessage", "Movie Added Successfully");
		model.addAttribute("Movie added is: " + result);
		return "aftersave";
	}

	@PostMapping("/editMovie")
	public ModelAndView updateMovie(@PathVariable int movieId, ModelMap model) {
		int result = service.edit(movieId);
		if (result > 0) {
			ModelAndView mv = new ModelAndView("success_update");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("failure_update");
			return mv;
		}
	}

	@PostMapping("/deleteMovie")
	public ModelAndView deleteMovie(@PathVariable int movieId, ModelMap model) {
		int result = service.remove(movieId);
		if (result > 0) {
			ModelAndView mv = new ModelAndView("success_delete");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("failure_delete");
			return mv;
		}
	}

	@RequestMapping("/showMovie")
	public String showMovie(ModelMap model) {
		List<Theatre> theatre = service.Theatre();
		model.addAttribute("movies", theatre);
		return "displayMovies";
	}

	@RequestMapping(value = "saveTicket", method = RequestMethod.POST)
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket, ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("theatre") == null) {
			return "userMenu";
		}

		int result = service.saveTicket(ticket);
		request.setAttribute("StatusMessage", "Ticket Saved Successfully");
		model.addAttribute("Ticket added is: " + result);
		return "aftersave";
	}
}
