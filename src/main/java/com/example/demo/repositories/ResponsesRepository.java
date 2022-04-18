package com.example.demo.repositories;

import com.example.demo.models.Buyer;
import com.example.demo.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ResponsesRepository extends JpaRepository<Response,Integer> {
    ArrayList<Response> findAllBySellerId(int id);
}
