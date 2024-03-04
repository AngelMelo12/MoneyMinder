package br.com.fiap.moneyminder.controller;

import br.com.fiap.moneyminder.model.Categoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Categoria> repository = new ArrayList<>();

    @GetMapping
    public List<Categoria> index(){
        return repository;
    }

    @PostMapping
    //@ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity <Categoria> create(@RequestBody Categoria categoria){
        log.info("cadastrando categoria: {}", categoria );
        repository.add(categoria);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoria);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> get(@PathVariable Long id) {
        log.info("Buscar por id : {}", id);

        //for (Categoria categoria : repository){
           // if (categoria.id().equals(id)){
               // return ResponseEntity
                        //.status(HttpStatus.OK)
                        //.body(categoria);
           // }
        //}

        var optionalCategoria = repository
                                    .stream()
                                    .filter(c -> c.id().equals(id))
                                    .findFirst();

        if(optionalCategoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity
                .status((HttpStatus.OK))
                .body(optionalCategoria.get());
    }


}
