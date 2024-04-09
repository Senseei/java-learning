package com.learning.pedidos.entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Client {
    private String name;
    private String email;
    private Date birthDate;

    public Client(String name, String email, String birthDate) {
        this.name = name;
        this.email = email;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.birthDate = formatter.parse(birthDate);
        } catch (ParseException e) {
            this.birthDate = new Date();
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String toString() {
        return name + " (" + birthDate + ") - " + email;
    }
}
