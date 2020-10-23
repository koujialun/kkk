package com.jk.kjl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class storerank implements Serializable {
    private Long id;

    private Date createddate;

    private Date lastmodifieddate;

    private Long version;

    private Integer orders;

    private Boolean isallowregister;

    private String memo;

    private String name;

    private Long quantity;

    private BigDecimal servicefee;


}