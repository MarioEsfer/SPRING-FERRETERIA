package com.hibernate.ferreteriaHibernate.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="articulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "stock")
    private Integer stock;

    @Override
    public String toString() {
        return "Articulo{" +
                " id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio="  + precio +
                ", stock="   + stock  +
                '}';
    }

}
