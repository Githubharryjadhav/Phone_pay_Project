package com.hefshine.phonepay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.phonepay.entity.BankUser;
import com.hefshine.phonepay.entity.LinkAccountEnttity;
import com.hefshine.phonepay.repo.BankUserRepo;
import com.hefshine.phonepay.repo.LinkAccountRepo;

@RestController
@CrossOrigin
public class LinkAccountController {
	
	
	@Autowired
	LinkAccountRepo linkAccountRepo;
	
	@Autowired
	BankUserRepo bankUserRepo;
	
	
	@RequestMapping("/getBankAccounts")
	public List<BankUser>getbankAccounts(@RequestParam long mobile)
	{
		return bankUserRepo.findByMobile(mobile);
	}
	
	@RequestMapping("/LinkedAccountwithphonepay")
	public LinkAccountEnttity linkBankAccountWithPhonepay(@RequestBody BankUser bankUser)
	{
		LinkAccountEnttity accountEnttity = new LinkAccountEnttity();
		accountEnttity.setAccountno(bankUser.getAccountNumber());
		accountEnttity.setBalance(bankUser.getBalance());
		accountEnttity.setIfscno(bankUser.getIFSCcode());
		accountEnttity.setMobile(bankUser.getMobile());
		accountEnttity.setName(bankUser.getName());
		return linkAccountRepo.save(accountEnttity);
	}
	
	
	@GetMapping("getbankAccounts")
	public List<BankUser> getBankAccount(@RequestParam long mobile)
	{
		 return bankUserRepo.findByMobile(mobile);
	}
	
	@RequestMapping("/getlinkbankaccounts")
	public List<LinkAccountEnttity>getLinkBankAccount(@RequestParam long mobile)
	{
		return linkAccountRepo.findByMobile(mobile);
	
	}
	
	@DeleteMapping("/deletefromBankUser/{id}")
	public void deletefromBankuser(@RequestParam int id)
	{
		bankUserRepo.deleteById(id);
	}
	
	

}
