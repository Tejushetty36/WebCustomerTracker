package com.springdemo.DAOImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.DAO.CustomerDAO;
import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> listCustomers() {
		
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get results
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomerById(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomer(String name) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = null;
		
		if(name!= null && name.trim().length()>0) {
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name",Customer.class);
			
			theQuery.setParameter("name", "%" + name.toLowerCase() + "%");
		}
		else
		{
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> customerList = theQuery.getResultList();
		
		return customerList;
	}

}
