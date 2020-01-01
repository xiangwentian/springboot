package com.workman.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Slf4j
@Getter
@Setter
@Entity
@Table(name="t_user")
public class UserEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;

    @Column(name="t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name="t_address")
    private String address;

}
