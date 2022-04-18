package com.example.demo.repositories;

import com.example.demo.models.Buyer;
import com.example.demo.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface RequestsRepository extends JpaRepository<Request,Integer> {
    ArrayList<Request> findAllByBuyerId(int id);
}
