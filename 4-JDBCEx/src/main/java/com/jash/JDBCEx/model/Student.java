package com.jash.JDBCEx.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter @Setter @ToString
@Component @Scope("prototype")
public class Student {
    int rollNo;
    String name;
    int marks;
}
