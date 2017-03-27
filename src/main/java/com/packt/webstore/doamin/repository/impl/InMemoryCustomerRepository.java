package com.packt.webstore.doamin.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

	private List<Customer> listOfCustomers = new ArrayList<>();
	
	public InMemoryCustomerRepository(){
		Customer piotr = new Customer("pikej", "Piotr", "Kwit");
		Customer wojciech = new Customer("wojkrzych", "Wojciech", "Krzysiek");
		Customer damian = new Customer("weneryczny_20cm", "Damian", "Wiejak");
		listOfCustomers.add(piotr);
		listOfCustomers.add(wojciech);
		listOfCustomers.add(damian);
	}
	@Override
	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}

}
