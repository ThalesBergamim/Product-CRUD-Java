package com.thalesbergamim.projeto1.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thalesbergamim.projeto1.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer>{
    
}
