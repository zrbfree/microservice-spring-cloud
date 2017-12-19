package com.itmuch.cloud.microserviceprovideruser.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/********************************************************
 *@Desc:
 *@Author: ZRP
 *@Date: 2017/12/18 11:17
 ********************************************************/

@Data
@Entity
public class User implements Serializable{

    private static final long serialVersionUID = -7145710194980383182L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String username;
    @Column
    private String name;
    @Column
    private Short age;
    @Column
    private BigDecimal balance;
}
