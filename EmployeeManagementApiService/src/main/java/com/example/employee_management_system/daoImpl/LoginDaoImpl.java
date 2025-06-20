package com.example.employee_management_system.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management_system.dao.LoginDao;
import com.example.employee_management_system.entity.UsersEntity;
import com.example.employee_management_system.pojo.LoginPojo;
import com.example.employee_management_system.pojo.ResponsePojo;
import com.example.employee_management_system.repo.UserRepo;

@Service
public class LoginDaoImpl implements LoginDao {

	@Autowired
	UserRepo repo;
	
	@Override
	public ResponsePojo login(LoginPojo pojo) {
		ResponsePojo result = new ResponsePojo();
		try {
			UsersEntity user=repo.findByUsername(pojo.getUsername());
			
			if (user.getUsername().equals(pojo.getUsername()) &&  user.getPassword().equals(pojo.getPassword())) {
				result.setStatus(true);
				result.setData(user);
				result.setMessage("Logged In Successfull");	
				
			} else {

				result.setStatus(false);
				result.setMessage("Invalid Credentials");
			}
			

		} catch (Exception e) {
			result.setStatus(false);
			result.setMessage("Exception while fetching user details");
			e.printStackTrace();
		}

		return result;
	}

}
