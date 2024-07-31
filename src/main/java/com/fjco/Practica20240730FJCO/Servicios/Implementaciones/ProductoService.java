package com.fjco.Practica20240730FJCO.Servicios.Implementaciones;

import com.fjco.Practica20240730FJCO.Modelo.ProductoFJCO;
import com.fjco.Practica20240730FJCO.Respositorio.IProductoFJCORepository;
import com.fjco.Practica20240730FJCO.Servicios.Interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoFJCORepository productoFJCORepository;
    @Override
    public Page<ProductoFJCO> buscarTodosPaginados(Pageable pageable) {
        return productoFJCORepository.findAll(pageable);
    }

    @Override
    public List<ProductoFJCO> obtenerTodos() {
        return productoFJCORepository.findAll();
    }

    @Override
    public Optional<ProductoFJCO> buscarPorId(Integer id) {
        return productoFJCORepository.findById(id);
    }

    @Override
    public ProductoFJCO crearOEditar(ProductoFJCO productoFJCO) {
        return productoFJCORepository.save(productoFJCO);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productoFJCORepository.deleteById(id);
    }
}
