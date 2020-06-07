package com.grokonez.springrest.h2.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grokonez.springrest.h2.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}
