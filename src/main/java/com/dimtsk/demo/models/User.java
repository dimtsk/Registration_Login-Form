
package com.dimtsk.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(nullable=false, length=64)
    private String password;
    @Column(nullable=false, length=25)
    private String email;
    @Column(nullable=false, length=25)
    private String firstname;
    @Column(nullable=false, length=25)
    private String lastname;
    @Column(nullable=false, length=25)
    private String role;
    
    
}
