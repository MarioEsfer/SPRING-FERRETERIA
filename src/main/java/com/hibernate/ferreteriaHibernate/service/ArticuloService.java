package com.hibernate.ferreteriaHibernate.service;

import com.hibernate.ferreteriaHibernate.dTO.ArticulosDTO;
import com.hibernate.ferreteriaHibernate.entity.Articulos;
import com.hibernate.ferreteriaHibernate.mapper.ArticuloMapper;
import com.hibernate.ferreteriaHibernate.repositorio.I_RepoArticulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticuloService {

    @Autowired
    private I_RepoArticulos repositorio;

    public List<Articulos>  consultaArticulos(){
        return (List<Articulos>) repositorio.findAll();
    }

    public List<ArticulosDTO> serv_Listar(){
        return repositorio.findAll().stream().map(ArticuloMapper::toDTO).collect(Collectors.toList());
    }

    public ArticulosDTO serv_buscarPorId(Long id){
        Articulos articuloPorId = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Articulo no encontrado"));
        return ArticuloMapper.toDTO(articuloPorId);
    }

    public ArticulosDTO serv_Insertar(ArticulosDTO dto){
        Articulos articulo = ArticuloMapper.toEntity(dto);
        Articulos insertado = repositorio.save(articulo);
        return ArticuloMapper.toDTO(insertado);
    }

    public ArticulosDTO serv_Actualizar(Long id, ArticulosDTO dto){
        Optional<Articulos> existe = repositorio.findById(id);

        if (existe.isPresent()) {
            Articulos articulo = existe.get();
            articulo.setNombre(dto.getNombre());
            articulo.setPrecio(dto.getPrecio());
            articulo.setStock(dto.getStock());

            Articulos actualizado = repositorio.save(articulo);
            return  ArticuloMapper.toDTO(actualizado);
        } else {
            throw new RuntimeException("No se encontro el articulo del id " + id);
        }
    }

    public String serv_Eliminar(Long id){
        if(repositorio.existsById(id)){
            repositorio.deleteById(id);
            return "El articulo se elimino correctamente";
        } else {
            return "El articulo del id + id + no se encontro";
        }
    }

}
