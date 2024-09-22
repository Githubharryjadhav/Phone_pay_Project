package com.hefshine.phonepay.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.phonepay.entity.Phonepayuser;

public interface PhonePayUserRepo extends JpaRepository<Phonepayuser, Integer> 
{
	 int countByMobile(long mobile);
	 Phonepayuser findByMobile(long mobile);

	 
	
	
	
}
