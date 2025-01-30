package com.projeto.sistema.repositorys;

import com.projeto.sistema.models.Cidade;
import com.projeto.sistema.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
