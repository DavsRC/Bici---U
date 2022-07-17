package models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    protected String id;
    protected String dni;
    protected String name;
    protected String surName;
    protected int age;
    private boolean hasDebts;

}
