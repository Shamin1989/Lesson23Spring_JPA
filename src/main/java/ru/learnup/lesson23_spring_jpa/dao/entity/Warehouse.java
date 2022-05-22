package ru.learnup.lesson23_spring_jpa.dao.entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "warehouse")
@Getter
@Setter
@RequiredArgsConstructor
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int count;
}
