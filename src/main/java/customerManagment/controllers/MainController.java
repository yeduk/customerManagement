package customerManagment.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import customerManagment.entities.Manager;

@Controller
public class MainController {

	@Autowired
	SessionFactory factory;

	@RequestMapping("/index")
	public String displayIndex() {
		return "index";
	}

	@RequestMapping("/")
	public String displaylogin() {
		
		return "login";
	}

	@PostMapping("/validManager")
	@Transactional
	public String validateManager(@RequestParam("id") String id,@RequestParam("pwd") String pwd ,Model msg) {

		Session sess = factory.getCurrentSession();
		Manager m = null;
		try {
			int cid = Integer.parseInt(id);
			m = sess.get(Manager.class, cid );
			if (m.getPwd().equals(pwd))
				return "redirect:regForm";
			else {
				msg.addAttribute("msg"," Invalid credentials ");
				return "login";
			}
		} catch (Exception e) {
			msg.addAttribute("msg"," Invalid credentials ");
			return "login";
		}

		
	}


}
