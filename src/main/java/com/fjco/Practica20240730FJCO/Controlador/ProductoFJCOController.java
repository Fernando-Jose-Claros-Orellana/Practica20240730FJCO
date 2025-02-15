package com.fjco.Practica20240730FJCO.Controlador;

import com.fjco.Practica20240730FJCO.Modelo.ProductoFJCO;
import com.fjco.Practica20240730FJCO.Servicios.Interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/Productos")
public class ProductoFJCOController {

    @Autowired
private IProductoService productoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<ProductoFJCO> productos = productoService.buscarTodosPaginados(pageable);
        model.addAttribute("productos", productos);

        int totalPages = productos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "Productos/index";
    }

    @GetMapping("/create")
    public String create(ProductoFJCO producto){
        return "Productos/create";
    }

    @PostMapping("/save")
    public String save(ProductoFJCO productoFJCO, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(productoFJCO);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "Productos/create";
        }

        productoService.crearOEditar(productoFJCO);
        attributes.addFlashAttribute("msg", "Producto creado correctamente");
        return "redirect:/Productos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        ProductoFJCO productoFJCO = productoService.buscarPorId(id).get();
        model.addAttribute("producto", productoFJCO);
        return "Productos/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        ProductoFJCO productoFJCO = productoService.buscarPorId(id).get();
        model.addAttribute("producto", productoFJCO);
        return "Productos/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        ProductoFJCO productoFJCO = productoService.buscarPorId(id).get();
        model.addAttribute("producto", productoFJCO);
        return "Productos/delete";
    }

    @PostMapping("/delete")
    public String delete(ProductoFJCO productoFJCO, RedirectAttributes attributes){
        productoService.eliminarPorId(productoFJCO.getId());
        attributes.addFlashAttribute("msg", "Producto eliminado correctamente");
        return "redirect:/Productos";
    }

}
