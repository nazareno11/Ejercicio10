package com.prog4.Ejercicio10.resourcess.features.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog4.Ejercicio10.resourcess.features.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}