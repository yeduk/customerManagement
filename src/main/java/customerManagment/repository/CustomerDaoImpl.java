package customerManagment.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import customerManagment.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	@Autowired
	SessionFactory factory;

	@Override
	public List<Customer> listAllCustomer() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> custList = query.getResultList();
		// custList.forEach(cust->System.out.println(cust));
		return custList;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(customer);

	}

	@Override
	public void deleteCustomer(int id) {
		Session session = factory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		

	}

	@Override
	public Customer getCustomer(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Customer.class, id);
		
	}

	@Override
	public List<Customer> getCustomerbyNameOrId(String val) {
		Session session = factory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer where firstName like '"+val+"%' or lastName like '"+val+"%' or concat(firstName,lastName) like '"+val+"%'  or id='"+val+"' order by id");
		List<Customer> custList = query.getResultList();
		return custList;
	}



}
