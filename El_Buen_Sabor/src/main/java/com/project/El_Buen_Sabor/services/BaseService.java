package com.project.El_Buen_Sabor.services;

import java.util.List;
public interface BaseService<E>{

    //Nos trae una lista de todas las entidades que se encuentran en nuestra base de datos
    public List<E> findAll() throws Exception;

    //OBTENER una entidad desde el ID que le pasemos
    public E findById(Long id) throws Exception;
    //
    public E save(E entity) throws Exception;

    public E update(Long id, E entity ) throws Exception;

    public boolean delete(Long id) throws Exception;
}
