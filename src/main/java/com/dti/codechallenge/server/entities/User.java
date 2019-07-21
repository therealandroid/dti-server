//package com.dti.codechallenge.server.entities;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//@Entity
//public class User {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    @Column
//    private Long id;
//
//    @NotNull
//    @Column
//    @Size(min = 5, max = 60)
//    private String username;
//
//    @NotNull
//    @Column
//    @Size(min = 3, max = 1024)
//    private String password;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
//}
