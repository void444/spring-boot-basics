package com.example.democlass.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.democlass.dao.StudentDAO;
import com.example.democlass.dao.UserRepository;
import com.example.democlass.dto.User;


@Controller
public class DemoController {

@Autowired private StudentDAO studentDao;
@Autowired private UserRepository userRepo;
@GetMapping("/servicecheck")
public String serviceCheck(HttpServletRequest req,Model model) {
	String data = studentDao.getData();
	model.addAttribute("DATA",data);
	return "servicecheck";
	
}
@PostMapping("/adduserdb")
public String addUserDb(HttpServletRequest req,Model model) {
	System.out.println("Add User Called....");
	User u = new User();
	u.setName(req.getParameter("name"));
	u.setEmail(req.getParameter("email"));
	userRepo.save(u);
	return "adduser";
}

@PostMapping("/edituserdb")
public String editUserDb(HttpServletRequest req,Model model) {
	User u = new User();
	u.setId(Integer.parseInt(req.getParameter("id")));
	u.setName(req.getParameter("name"));
	u.setEmail(req.getParameter("email"));
	userRepo.save(u);
	return "redirect:users";
}






   @GetMapping("/adduser")
   public String addUser(HttpServletRequest req,Model model)
   {
	   return "adduser";
   }
	@GetMapping("/demo")
	public String demo(HttpServletRequest req,Model model) {
		System.out.println("this is demo controller!");
		String name="data from controller";
		model.addAttribute("NAME",name);
		HttpSession session = req.getSession();
		Cookie cooks[] = req.getCookies();
		return "demo";
	}
	@GetMapping("/input")
	public String input(HttpServletRequest req,Model model) {
		return "input";
	}
	@PostMapping("/inputdb")
	public String inputdb(HttpServletRequest req,Model model) {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
	    model.addAttribute("NAME",name);
	    model.addAttribute("EMAIL",email);
	    model.addAttribute("isadmin",false);
	    List <String> data =new ArrayList<String>();
	    data.add("java");
	    data.add("C++");
	    model.addAttribute("data",data);
	    return "show";
	}
	
	@GetMapping("/users")
	public String showUsers(HttpServletRequest req,Model model) {
		Iterable data=userRepo.findAll();
	    model.addAttribute("data",data);
	    return "users";
	}
	@GetMapping("/userdelete")
	public ModelAndView deleteUser(HttpServletRequest req,Model model) {
		User obj=new User();
		obj.setId(Integer.parseInt(req.getParameter("id")));
		userRepo.delete(obj);
		//Iterable data=userRepo.findAll();
	    //model.addAttribute("data",data);
	    //return "users";
		return new ModelAndView("redirect:users");
	}
	
	@GetMapping("/useredit")
	public String editUser(HttpServletRequest req,Model model) {
		User obj=userRepo.findById(Integer.parseInt(req.getParameter("id"))).get();
		model.addAttribute("user",obj);
		return "edituser";
	}
	
}
