package com.example.demo.controllers;

import com.example.demo.dtos.LoginRequestDto;
import com.example.demo.dtos.RequestsDto;
import com.example.demo.models.Buyer;
import com.example.demo.models.Request;
import com.example.demo.repositories.BuyersRepository;
import com.example.demo.repositories.RequestsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/buyers", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor
public class BuyerController {
    @Autowired
    BuyersRepository buyers;
    @Autowired
    RequestsRepository requests;


    @GetMapping(value = "/logInByLoginAndPassword")
    public Buyer logInByLoginAndPassword(@RequestBody LoginRequestDto loginRequestDto) {
        return buyers.findByLoginAndPassword(loginRequestDto.login,loginRequestDto.password);
    }
    @PostMapping(value = "/signUp")
    public String signUpByLoginAndPassword(@RequestBody Buyer buyer) {
        Buyer foundBuyer=buyers.findByLoginAndPassword(buyer.login,buyer.password);
        if (foundBuyer==null){
            buyers.saveAndFlush(buyer);
            return "OK";
        }
        else {
            return "This Buyer Already Exist";
        }
    }
    @PostMapping(value = "/editBuyer")
    public String editBuyer(@RequestBody Buyer buyer) {
        Buyer foundBuyer=buyers.findByLoginAndPassword(buyer.login,buyer.password);
        if (foundBuyer!=null){
            buyers.saveAndFlush(buyer);
            return "OK";
        }
        else {
            return "This Buyer does not Exist";
        }
    }
    @GetMapping(value = "/getAllRequests")
    public RequestsDto getAllRequests(){
        return new RequestsDto((ArrayList<Request>) requests.findAll());
    }
    @PostMapping(value = "/createNewRequest")
    public String createNewRequest(@RequestBody Request request) {
        requests.saveAndFlush(request);
        return "OK";
    }
    @PostMapping(value = "/updateRequest")
    public String updateRequest(@RequestBody Request request) {
        requests.saveAndFlush(request);
        return "OK";
    }
    @DeleteMapping(value = "/deleteRequest")
    public String deleteRequest(@RequestBody Request request) {
        requests.delete(request);
        return "OK";
    }






}
