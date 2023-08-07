package com.programmingdarinol.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "master_store")
@Entity
@Getter
@Setter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")//pemberian nama kolom
    private String name;
    @Column(name = "Adress")
    private String address;
}
