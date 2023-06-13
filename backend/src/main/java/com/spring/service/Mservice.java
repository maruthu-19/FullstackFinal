package com.spring.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.spring.model.AppModel;
import com.spring.model.AuthModel;
import com.spring.repository.Apprepo;
import com.spring.repository.Authrepo;

@Service
public class Mservice {
	
	@Autowired
	private Apprepo apprepo;
	@Autowired
	private Authrepo authrepo;

	//Login Logic
	public String Login(String username, String password) {
		AuthModel xuser = authrepo.findByusername(username);
		if (xuser == null) {
			return "invalidusername";
		} else {
			if (xuser.getPassword().equals(password)) {
				return "success";
			} else {
				return "invalidpassword";
			}
		}
	}

	//Signup Logic
	public String Signup(AuthModel xuser) {
	    String username = xuser.getUsername();
	    AuthModel authuser = authrepo.findByusername(username);
	    if (authuser == null) {
	        authrepo.save(xuser);
	        return "useradded";
	    } else {
	        return "existingusername";
	    }
	}

	// Get 
	public List<AppModel> getData() {
		return apprepo.findAll();
	}
	
	// Post
	public AppModel addData(AppModel data) {
		return apprepo.save(data);
	}
	
	// Edit (modify if data exists and save, else don't save)
	public AppModel editData(AppModel data, Long id) {
		AppModel edx = apprepo.findById(id).orElse(data);
		if (edx != null) {
			edx.setCustname(data.getCustname());
			edx.setLefteye(data.getLefteye());
			edx.setRighteye(data.getRighteye());
			edx.setProductid(data.getProductid());
			edx.setType(data.getType());
			return apprepo.saveAndFlush(edx);
		} else {
			return null;
		}
	}
	
	//Delete
	public String deleteData(Long id) {
		apprepo.deleteById(id);
		return "Deleted Successfully";
	}
	
	//Find by ID
	public Optional<AppModel> findbyID(Long id) {
		return apprepo.findById(id);
	}
	//sorting
		public List<AppModel>sort(String field)
		{
			return apprepo.findAll(org.springframework.data.domain.Sort.by(field));
		}
		//pagination
		public List<AppModel>paging( int offset,int pagesize)
		{
			Page<AppModel> page = apprepo.findAll(PageRequest.of(offset, pagesize));
			return page.getContent();
		}
}
