package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;


        @Entity
        @Getter
        @Setter
        @Table(name = "users") //automation in writing sql

        public class Users {

            @Id //generating unique ID
            @GeneratedValue(strategy = GenerationType.IDENTITY) //Organizing the data identity

            private long ID;

            private String name;
            private String program;

}
