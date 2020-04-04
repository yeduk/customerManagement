package customerManagment.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import customerManagment.entities.Customer;
import customerManagment.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping("/custList")
	public String listAllCustomers(Model custModel) {

		List<Customer> custList = service.listAllCustomer();
		custModel.addAttribute("customers", custList);
		custList.forEach(cust -> System.out.println(cust));

		return "customer-list";
	}

	@GetMapping("/regForm")
	public String displayForm(Model custModel) {
		Customer customer = new Customer();
		custModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@RequestMapping("/regCustomer")

	public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
			Model msg) {

		if (bindingResult.hasErrors()) {

			System.out.println("errorrrrr");

			return "customer-form";
		} else {
			service.saveCustomer(customer);
			msg.addAttribute("msg", "customer " + customer.getFirstName() + " added with id " + customer.getId());
			return "customer-form";
		}
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") int id) {
		service.deleteCustomer(id);

		return "redirect:custList";
	}

	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("id") int id, Model custModel) {
		Customer customer = service.getCustomer(id);
		custModel.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("val") String val, Model custModel) {
		List<Customer> searchList = service.getCustomerbyNameOrId(val);
		custModel.addAttribute("customers", searchList);
		return "customer-list";
	}

	@InitBinder
	public static void doPreProcessing(WebDataBinder wdb) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		wdb.registerCustomEditor(String.class, ste);

	}

//	@InitBinder
//	public void dateFormatter(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//	}

}
