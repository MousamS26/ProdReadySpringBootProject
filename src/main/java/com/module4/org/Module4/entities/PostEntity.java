package com.module4.org.Module4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "posts")

public class PostEntity extends AuditableEntity
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        private String description;
        private String title;


}

