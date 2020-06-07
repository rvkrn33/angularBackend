package org.sambasoft.controllers;

import java.util.List;

import org.sambasoft.entities.TransactionsDtls;
import org.sambasoft.repositories.TransactionsDtlsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class TransactionsDtlsController {
	@Autowired
	private TransactionsDtlsRepository transactionsDtlsRepository;

	@GetMapping("/trans")
	public List<TransactionsDtls> getUsers() {
		return transactionsDtlsRepository.findAll();
	}
	 @GetMapping("/tran/{id}")
	 public TransactionsDtls getTransDtls(@PathVariable Long id) { 
		 // return new ResponseEntity(HttpStatus.OK);
		return  transactionsDtlsRepository.findById(id).get();
		
		}
	 

	@DeleteMapping("/tran/{id}")
	public boolean deleteTran(@PathVariable Long id) {
		transactionsDtlsRepository.deleteById(id);
		return true;
	}

	@PutMapping("/tran")
	public TransactionsDtls updateTran(@RequestBody TransactionsDtls tran) {
		
		return transactionsDtlsRepository.save(tran);
	}

	@RequestMapping(value="/",method = RequestMethod.GET)
	@PostMapping("/tran")
	public TransactionsDtls createTran(@RequestBody TransactionsDtls tran) {
		return transactionsDtlsRepository.save(tran);
	}

}
