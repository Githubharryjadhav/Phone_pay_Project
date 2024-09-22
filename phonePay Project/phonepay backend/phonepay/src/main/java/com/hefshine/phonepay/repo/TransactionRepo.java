package com.hefshine.phonepay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.phonepay.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>
{
	 Long findByMobile(Long mob);
}
