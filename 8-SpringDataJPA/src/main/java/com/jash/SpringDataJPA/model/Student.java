package com.jash.SpringDataJPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@Scope("prototype")
@Entity
public class Student {
    @Id
    private int rollNo;

    private String name;
    private int marks;
}
