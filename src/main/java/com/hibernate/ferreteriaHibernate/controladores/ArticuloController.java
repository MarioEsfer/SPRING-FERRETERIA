package com.hibernate.ferreteriaHibernate.controladores;

import com.hibernate.ferreteriaHibernate.dTO.ArticulosDTO;
import com.hibernate.ferreteriaHibernate.entity.Articulos;
import com.hibernate.ferreteriaHibernate.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService service;

    @GetMapping("/listar")
    public List<Articulos> consultarArticulos(){
        return service.consultaArticulos();
    }

    @GetMapping()
    public  List<ArticulosDTO> listar(){
        return service.serv_Consultar();
    }

    @GetMapping("/{id}")
    public ArticulosDTO buscarArticuloPorId(@PathVariable Long id){
        return service.serv_buscarPorId(id);
    }

    @PostMapping
    public ArticulosDTO insertaArticulos(@RequestBody ArticulosDTO dto){
        return  service.serv_Insertar(dto);
    }

    @PutMapping("/{id}")
    public ArticulosDTO actualizarArticulos(@PathVariable Long id, @RequestBody ArticulosDTO dto){
        return service.serv_Actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public  String eliminarArticulos(@PathVariable Long id){
        return service.serv_Eliminar(id);
    }

}
