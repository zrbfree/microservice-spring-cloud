package com.itmuch.cloud.microserviceconsumermovie.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/********************************************************
 *@Desc:
 *@Author: ZRP
 *@Date: 2017/12/18 11:17
 ********************************************************/

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1143322444216858084L;
    private Long id;
    private String username;
    private String name;
    private Short age;
    private BigDecimal balance;
}
