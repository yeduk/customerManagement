package customerManagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customerManagment.entities.Customer;
import customerManagment.repository.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> listAllCustomer() {

		return customerDAO.listAllCustomer();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);

	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);

	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);

	}

	@Override
	@Transactional
	public List<Customer> getCustomerbyNameOrId(String val) {

		return customerDAO.getCustomerbyNameOrId(val);

	}

}
