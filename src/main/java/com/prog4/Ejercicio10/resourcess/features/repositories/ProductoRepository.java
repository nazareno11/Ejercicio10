package com.prog4.Ejercicio10.resourcess.features.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prog4.Ejercicio10.resourcess.features.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>, PagingAndSortingRepository<Producto, Long> {
}