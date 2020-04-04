package customerManagment.repository;

import java.util.List;

import customerManagment.entities.Customer;

public interface CustomerDAO {
	
	public List<Customer> listAllCustomer();

	public void saveCustomer(Customer customer);

	public void deleteCustomer(int id);

	public Customer getCustomer(int id);

	public List<Customer> getCustomerbyNameOrId(String valw);


}
