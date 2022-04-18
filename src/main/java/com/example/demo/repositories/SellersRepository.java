package com.example.demo.repositories;

import com.example.demo.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellersRepository extends JpaRepository<Seller,Integer> {
    Seller findByLoginAndPassword(String login, String password);
}
