package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String productName;
    @Column
    public String essence;
    @Column
    public int totalPrice;
    @Column
    public Boolean isOpen;
    @Column
    public int buyerId;

}
