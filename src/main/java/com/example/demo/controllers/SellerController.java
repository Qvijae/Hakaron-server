package com.example.demo.controllers;

import com.example.demo.dtos.LoginRequestDto;
import com.example.demo.dtos.RequestsDto;
import com.example.demo.dtos.ResponsesDto;
import com.example.demo.models.Request;
import com.example.demo.models.Response;
import com.example.demo.models.Seller;
import com.example.demo.repositories.RequestsRepository;
import com.example.demo.repositories.ResponsesRepository;
import com.example.demo.repositories.SellersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/sellers", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class SellerController {
    @Autowired
    SellersRepository sellers;
    @Autowired
    RequestsRepository requests;
    @Autowired
    ResponsesRepository responses;


    @GetMapping(value = "/logInByLoginAndPassword")
    public Seller logInByLoginAndPassword(@RequestBody LoginRequestDto loginRequestDto) {
        return sellers.findByLoginAndPassword(loginRequestDto.login,loginRequestDto.password);
    }
    @PostMapping(value = "/signUp")
    public String signUpByLoginAndPassword(@RequestBody Seller seller) {
        Seller foundSeller=sellers.findByLoginAndPassword(seller.login,seller.password);
        if (foundSeller==null){
            sellers.saveAndFlush(seller);
            return "OK";
        }
        else {
            return "This Seller Already Exist";
        }
    }
    @GetMapping(value = "/getAllRequests")
    public RequestsDto getAllRequests(){
        return new RequestsDto((ArrayList<Request>) requests.findAll());
    }

    @PostMapping(value = "/createNewResponse")
    public String createNewRequest(@RequestBody Response response) {
        responses.saveAndFlush(response);
        return "OK";
    }

}
