package com.hefshine.phonepay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hefshine.phonepay.entity.Phonepayuser;
import com.hefshine.phonepay.repo.PhonePayUserRepo;
import java.util.Random;

@RestController
@CrossOrigin
public class LoginController {


//	    @Autowired
//	    UserRepo userRepo;
	
	int userOtp;
	
	@Autowired
	PhonePayUserRepo PhonePayUserRepo ;
	    
	@GetMapping("getUserOtp")
	    public int retrunOtp()
	    {
	    	return  userOtp;
	    }

	    @RequestMapping("login/{mobile}")
	    public int login(@PathVariable long mobile) {
	        int count = PhonePayUserRepo.countByMobile(mobile);

	        if (count != 1) {
	            return -1;  // Mobile number not registered
	        }

	        // If the mobile number is registered, generate and send OTP
	        Phonepayuser user =PhonePayUserRepo.findByMobile(mobile);
	        Random obj = new Random();
	        int otp = 1000 + obj.nextInt(9000);
	        user.setOtp(otp);
	        PhonePayUserRepo.save(user);
userOtp=otp;
	        System.out.println("OTP sent to " + mobile + ": " + userOtp);

	        return 1;  // OTP sent successfully
	    }


	 
	    @RequestMapping("verifyLogin/{mobile}/{otp}")
	    public int verifyLogin(@PathVariable long mobile, @PathVariable int otp) {
	        int count = PhonePayUserRepo.countByMobile(mobile);
	        
	        if (count != 1) {
	            return -1;  // Mobile number not registered
	        }
	        
	      Phonepayuser user = PhonePayUserRepo.findByMobile(mobile);
	        
	        if (user.getOtp() == otp) {
	            return 1;  // OTP verified successfully, proceed to dashboard
	        } else {
	            return -1;  // Incorrect OTP
	        }
	    }
	}