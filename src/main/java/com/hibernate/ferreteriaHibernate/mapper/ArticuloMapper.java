package com.hibernate.ferreteriaHibernate.mapper;

import com.hibernate.ferreteriaHibernate.dTO.ArticulosDTO;
import com.hibernate.ferreteriaHibernate.entity.Articulos;

//Realizamos estos metodos para consultar y enviar datos
public class ArticuloMapper {

    //Conversion de entidad articulos a DTO
    public static ArticulosDTO toDTO(Articulos articulo){
        return new ArticulosDTO(
                articulo.getId(),
                articulo.getNombre(),
                articulo.getPrecio(),
                articulo.getStock()
        );

    }

    //Conversion de DTO a entidad articulos
    public static Articulos toEntity(ArticulosDTO dto){
        Articulos articulo = new Articulos();
        articulo.setId(dto.getId());
        articulo.setNombre(dto.getNombre());
        articulo.setPrecio(dto.getPrecio());
        articulo.setStock(dto.getStock());
        return articulo;
    }


}
