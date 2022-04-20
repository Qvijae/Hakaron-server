package com.example.demo.controllers;

import com.example.demo.dtos.LoginRequestDto;
import com.example.demo.dtos.RequestsDto;
import com.example.demo.dtos.*;
import com.example.demo.dtos.ResponsesDto;
import com.example.demo.models.Buyer;
import com.example.demo.models.Request;
import com.example.demo.models.Response;
import com.example.demo.models.Seller;
import com.example.demo.repositories.BuyersRepository;
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
    @Autowired
    BuyersRepository buyers;

    @GetMapping(value = "/logInByLoginAndPassword")
    public Seller logInByLoginAndPassword(@RequestBody LoginRequestDto loginRequestDto) {
        return sellers.findByLoginAndPassword(loginRequestDto.login, loginRequestDto.password);
    }

    @PostMapping(value = "/signUp")
    public String signUpByLoginAndPassword(@RequestBody Seller seller) {
        Seller foundSeller = sellers.findByLoginAndPassword(seller.login, seller.password);
        if (foundSeller == null) {
            sellers.saveAndFlush(seller);
            return "OK";
        } else {
            return "This Seller Already Exist";
        }
    }

    @PostMapping(value = "/editSeller")
    public String editSeller(@RequestBody Seller seller) {
        Seller foundSeller = sellers.findByLoginAndPassword(seller.login, seller.password);
        if (foundSeller != null) {
            sellers.saveAndFlush(seller);
            return "OK";
        } else {
            return "This Seller does not Exist";
        }
    }

    @GetMapping(value = "/getAllRequests")
    public RequestsDto getAllRequests() {
        return new RequestsDto((ArrayList<Request>) requests.findAll());
    }

    @PostMapping(value = "/createNewResponse")
    public String createNewResponse(@RequestBody Response response) {
        responses.saveAndFlush(response);
        return "OK";
    }

    @PutMapping(value = "/updateResponse")
    public String updateResponse(@RequestBody Response response) {
        responses.saveAndFlush(response);
        return "OK";
    }

    @DeleteMapping(value = "/deleteResponse")
    public String deleteResponse(@RequestBody Response response) {
        responses.delete(response);
        return "OK";
    }

    @GetMapping(value = "/getAllResponses")
    public ResponsesDto getAllResponses() {
        return new ResponsesDto((ArrayList<Response>) responses.findAll());
    }

    @GetMapping("/getAllBuyers")
    public BuyersDto getAllBuyers() {
        return new BuyersDto((ArrayList<Buyer>)buyers.findAll());
    }
}
