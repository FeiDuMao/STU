package com.tyy.stu.adapter.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "role")
@Entity
@Data
public class Role {


    @Id
    /**
     *     @GeneratedValue(strategy = GenerationType.IDENTITY)
     *     @GeneratedValue(generator = "uuid")
     *     @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
     */
    private String id;
    private String name;
    private String organizationId;
    private LocalDateTime createTime;


}
