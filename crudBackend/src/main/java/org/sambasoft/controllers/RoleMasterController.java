package org.sambasoft.controllers;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sambasoft.entities.RoleMaster;
import org.sambasoft.repositories.RoleMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class RoleMasterController {

	private static final Logger LOGGER = LogManager.getLogger(RoleMasterController.class);

	@Autowired
	private RoleMasterRepository roleMasterRepository;

	@GetMapping("/roleMasters")
	public List<RoleMaster> getRoleMasters() {
		return roleMasterRepository.findAll();
	}

	@GetMapping("/roleMasters/{id}")
	public RoleMaster getRoleMaster(@PathVariable Long id) {
		return roleMasterRepository.findById(id).get();
	}

	@DeleteMapping("/roleMaster/{id}")
	public boolean deleteRoleMaster(@PathVariable Long id) {
		roleMasterRepository.deleteById(id);
		return true;
	}

	@PutMapping("/roleMaster")
	public RoleMaster updateUser(@RequestBody RoleMaster roleMaster) {
		return roleMasterRepository.save(roleMaster);
	}

	@PostMapping("/roleMaster")
	public RoleMaster createRoleMaster(@RequestBody RoleMaster roleMaster) {
		
		LOGGER.info("getRoleUserType ---> "+roleMaster.getRoleUserType());
		RoleMaster roleObj=roleMasterRepository.findRoleMasterByRoleUserType(roleMaster.getRoleUserType());
		
		if(roleObj==null)
		{
			LOGGER.info("New Object ");
			return roleMasterRepository.save(roleMaster);
		}
		else
		{
			LOGGER.info("update  Object "+roleObj.getRoleId());
			System.out.println("####################################################################   "+roleObj.getRoleId() +" >>> "+roleObj.getRoleUserType());
			roleMaster.setRoleId(roleObj.getRoleId());
			updateUser(roleMaster);
			
			return roleMaster;
		}
	}

}
