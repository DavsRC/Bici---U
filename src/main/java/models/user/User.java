package models.user;

import common.CommonMethods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements CommonMethods {

    protected String id;
    protected String dni;
    protected String name;
    protected String surName;
    protected int age;
    private boolean hasDebts;


    @Override
    public String giveFormat() {
        return dni+","+name+","+age;
    }
}
