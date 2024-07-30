package com.fjco.Practica20240730FJCO.Respositorio;

import com.fjco.Practica20240730FJCO.Modelo.ProductoFJCO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoFJCORepository extends JpaRepository<ProductoFJCO, Integer> {
}
