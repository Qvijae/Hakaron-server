package com.example.demo.repositories;

import com.example.demo.models.Buyer;
import com.example.demo.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyersRepository extends JpaRepository<Buyer,Integer> {
    Buyer findByLoginAndPassword(String login, String password);
}
