package com.hefshine.phonepay.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.phonepay.entity.BankUser;
import com.hefshine.phonepay.entity.Transaction;
import com.hefshine.phonepay.repo.BankUserRepo;

@RestController
@CrossOrigin("*")
public class TransactionController 
{

	@Autowired
	BankUserRepo bankRepo;

	@PostMapping("addmoney")
	public boolean addMoney(@RequestBody Transaction transaction) 
	{
		Long mobileToFind = transaction.getMobile();
		List<BankUser> bankUsers = bankRepo.findByMobile(mobileToFind);

		BankUser foundBankUser = null;

		double sender = 0;
		double receiver = 0;

		// Since you're retrieving a list, let's find the exact match
		if (!bankUsers.isEmpty()) 
		{
			foundBankUser = bankUsers.stream().filter(bankUser -> bankUser.getMobile() == mobileToFind).findFirst()
					.orElse(null);
		}

		if (foundBankUser != null) 
		{
			sender = transaction.getAmount();
			receiver = foundBankUser.getBalance();

			// You can now proceed with your logic, e.g., updating balances or performing
			// transactions
		} 
		else 
		{
			// Handle the case where no BankUser was found
			System.out.println("No BankUser found with mobile number: " + mobileToFind);
		}

		double amountToAdd = sender + receiver;

		foundBankUser.setBalance(amountToAdd);

		bankRepo.save(foundBankUser);

		return true;

	}

}
