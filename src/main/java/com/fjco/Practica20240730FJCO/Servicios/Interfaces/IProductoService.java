package com.fjco.Practica20240730FJCO.Servicios.Interfaces;

import com.fjco.Practica20240730FJCO.Modelo.ProductoFJCO;
import com.fjco.Practica20240730FJCO.Servicios.Implementaciones.ProductoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Page<ProductoFJCO> buscarTodosPaginados(Pageable pageable);

    List<ProductoFJCO> obtenerTodos();

    Optional<ProductoFJCO> buscarPorId(Integer id);

    ProductoFJCO crearOEditar(ProductoFJCO grupo);

    void eliminarPorId(Integer id);
}
