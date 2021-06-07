package com.example.onlinestore.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderP {
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

    @Enumerated(EnumType.STRING)
    Status status;
}
