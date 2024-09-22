package com.hefshine.phonepay.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hefshine.phonepay.controller.LinkAccountController;
import com.hefshine.phonepay.entity.LinkAccountEnttity;

@Repository
public interface LinkAccountRepo extends JpaRepository<LinkAccountEnttity, Integer>
{
	
	List<LinkAccountEnttity>findByMobile(long mobile);
	
	
}
