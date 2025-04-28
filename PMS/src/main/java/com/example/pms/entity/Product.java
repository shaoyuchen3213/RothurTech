package com.example.pms.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable{

    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true,nullable = false)
    private Long id;

    @Column(name = "product_name", unique = true,nullable = false, length = 100)
    private String productName;

    @Column(name ="price", nullable = false)
    private Double price;

    @Column(name = "category", nullable = false, length = 100)
    private String category;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "descrption", length = 2000)
    private String descrption;



}
