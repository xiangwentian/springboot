package com.workman.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/4 21:26
 * @Version 1.0
 */
@Slf4j
@Getter
@Setter
@Entity
@Table(name="t_roles")
public class RoleEntity implements Serializable {
    @Id
    @Column(name = "r_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "r_name")
    private String name;

    @Column(name = "r_flag")
    private String flag;
}
