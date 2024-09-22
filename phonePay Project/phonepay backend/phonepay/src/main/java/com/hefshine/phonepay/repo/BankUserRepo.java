package com.hefshine.phonepay.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.phonepay.entity.BankUser;

public interface BankUserRepo extends JpaRepository<BankUser, Integer> {
	
	     int countByMobile(long mobile);
		 List<BankUser> findByMobile(long mobile);
	   
	    

		
}
