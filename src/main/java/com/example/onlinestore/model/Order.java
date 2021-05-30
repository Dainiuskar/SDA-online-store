package com.example.onlinestore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String userName;
    Double totalCost;

    @OneToOne
    Address deliveryAddress;

    @OneToOne
    Address userAddress;
    Date dateOfSubmission;

    @OneToMany
    List<OrderLine> orderLines;

    @ManyToOne
    UserAccount userAccount;

    Status status;
}
