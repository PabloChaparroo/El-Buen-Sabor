package com.project.El_Buen_Sabor.services.BaseService;

import com.project.El_Buen_Sabor.entities.Base;

import java.io.Serializable;
import java.util.List;
public interface BaseService<E extends Base, ID extends Serializable>{

    //Nos trae una lista de todas las entidades que se encuentran en nuestra base de datos
    public List<E> findAll() throws Exception;

    //OBTENER una entidad desde el ID que le pasemos
    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(ID id, E entity ) throws Exception;

    public boolean delete(ID id) throws Exception;
}
