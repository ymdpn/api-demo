package com.example.apidemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.apidemo.models.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_key")
    private long userKey;

    @Column(name = "user_id")
    @Getter
    @Setter
    private String userId;

    @Column(name = "user_name")
    @Getter
    @Setter
    private String userName;

    @Column
    @Getter
    @Setter
    private String password;

}