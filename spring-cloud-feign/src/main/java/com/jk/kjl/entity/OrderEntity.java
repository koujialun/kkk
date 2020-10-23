package com.jk.kjl.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="t_order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="order_id")
    private Integer orderId;
    @Column(name="order_name")
    private String orderName;
    @Column(name="create_time")
    private String creaTime;
}
