package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "responses")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public int price;
    @Column
    public String comment;
    @Column
    public int requestId;
    @Column
    public int sellerId;
}
