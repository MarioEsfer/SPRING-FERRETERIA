package com.hibernate.ferreteriaHibernate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Metodo que encripta la contrasena que ingresa el usuario (admin123)
public class GeneraPassword {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin123"));
    }

}
