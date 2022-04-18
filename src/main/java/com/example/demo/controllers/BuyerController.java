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
    @GetMapping(value = "/getAllRequestsByLoginAndPassword")
    public RequestsDto getAllRequestsByLoginAndPassword(@RequestBody LoginRequestDto loginRequestDto){
        Buyer foundBuyer=buyers.findByLoginAndPassword(loginRequestDto.login,loginRequestDto.password);
        ArrayList<Request> allByBuyerId = requests.findAllByBuyerId(foundBuyer.id);
        return new RequestsDto(allByBuyerId);
    }
    @PostMapping(value = "/createNewRequest")
    public String createNewRequest(@RequestBody Request request) {
        requests.saveAndFlush(request);
        return "OK";
    }





}
