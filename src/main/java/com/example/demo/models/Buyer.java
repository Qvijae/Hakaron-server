package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String name;
    @Column
    public String phoneNumber;
    @Column
    public String email;
    @Column
    public String info;
    @Column
    public String login;
    @Column
    public String password;

}
