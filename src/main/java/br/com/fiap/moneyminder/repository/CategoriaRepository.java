package br.com.fiap.moneyminder.repository;


import br.com.fiap.moneyminder.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}