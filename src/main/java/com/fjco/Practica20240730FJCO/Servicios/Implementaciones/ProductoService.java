package com.fjco.Practica20240730FJCO.Servicios.Implementaciones;

import com.fjco.Practica20240730FJCO.Modelo.ProductoFJCO;
import com.fjco.Practica20240730FJCO.Respositorio.IProductoFJCORepository;
import com.fjco.Practica20240730FJCO.Servicios.Interfaces.IProductoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    private IProductoFJCORepository prod;
    @Override
    public Page<ProductoFJCO> buscarTodosPaginados(Pageable pageable) {
        return prod.findAll(pageable);
    }

    @Override
    public List<ProductoFJCO> obtenerTodos() {
        return prod.findAll();
    }

    @Override
    public Optional<ProductoFJCO> buscarPorId(Integer id) {
        return prod.findById(id);
    }

    @Override
    public ProductoFJCO crearOEditar(ProductoFJCO grupo) {
        return prod.save(grupo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        prod.deleteById(id);
    }
}
