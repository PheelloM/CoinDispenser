package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.io.Serializable;

@Data
//@Table(name="USER_OBJECT")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userobject")
@Component
public class UserObject implements Serializable {
    //mark id as primary key and auto increment
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    //defining number as column name
    @Column
    private int number;

    //defining type as column name
    @Column
    private String type;

    //defining description as column name
    @Column
    private String description;
}
