package com.module4.org.Module4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        private String description;
        private String title;
}

