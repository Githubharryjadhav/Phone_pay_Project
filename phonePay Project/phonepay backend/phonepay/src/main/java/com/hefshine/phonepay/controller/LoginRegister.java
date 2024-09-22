package com.hefshine.phonepay.controller;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hefshine.phonepay.entity.BankUser;
import com.hefshine.phonepay.entity.Phonepayuser;
import com.hefshine.phonepay.repo.BankUserRepo;
import com.hefshine.phonepay.repo.PhonePayUserRepo;



@RestController
@CrossOrigin
public class LoginRegister 
{
	
	@Autowired
	PhonePayUserRepo phonePayUserRepo;
	@Autowired
	BankUserRepo bankUserRepo;
	
	
	@RequestMapping("setPin{mobile}")
	public int setPin(@PathVariable long mobile,@RequestBody int pin) {
		int count =phonePayUserRepo.countByMobile(mobile);
		if(count!=1)
			return -1;
		
		Phonepayuser user=phonePayUserRepo.findByMobile(mobile);
		//user.setPin(pin);
		user.setPin(pin);
		phonePayUserRepo.save(user);
		return 1;
	}
	
	@RequestMapping("verifyOtp")
	public int verifyOtp(@RequestBody long[]a)
	{
		long mobile =a[0];
		int otp=(int)a[1];
		
		int count=phonePayUserRepo.countByMobile(mobile);
		if(count!=1)
			return -1;
		
		Phonepayuser user=phonePayUserRepo.findByMobile(mobile);
		if(user.getOtp()==otp)
			return 1;
		return -1;
	}

	@RequestMapping("register{number}")
	public int  register(@PathVariable long number)
	{
		Phonepayuser user;
		int count = phonePayUserRepo.countByMobile(number);
		
		if(count==1)
		{
			user=phonePayUserRepo.findByMobile(number);
			Random obj=new Random();
			int otp=1000+obj.nextInt(9000);
			user.setOtp(otp);
			phonePayUserRepo.save(user);
		}
		else if(count==0)
		{
			//create new user and save into batabase
			user=new Phonepayuser();
			user.setMobile(number);
			java.util.List<BankUser> list=bankUserRepo.findByMobile(number);
			if(list==null || list.size()==0)
			{
				user.setName("User");
				
			}
			else
			{
				BankUser bankuser=list.get(0);
			//user.setName(bankuser.getName());
				user.setName(bankuser.getName());
			}
		
			Random obj=new Random();
			int otp=1000+obj.nextInt(9000);
			user.setOtp(otp);
			phonePayUserRepo.save(user);
			
		}
		else
			return -1;
		
		System.out.println(user.getOtp());
		
		return 1;
		
	}
}


