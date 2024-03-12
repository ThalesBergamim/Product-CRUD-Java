package com.thalesbergamim.projeto1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thalesbergamim.projeto1.model.Produto;
import com.thalesbergamim.projeto1.respository.ProdutoRepositoryOld;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositoryOld produtoRepository; 

    public List<Produto> obterTodos(){
        return ProdutoRepositoryOld.obterTodos(); 
    }

    /**
     * Metodo que procura o procuto pelo Id
     * @param id do produto para localizar
     * @return Retorna o produto caso seja encontrato 
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

    /**
     * Metodo para adicionar um produto na lista
     * @param produto Produto que será adicionado   
     * @return retorna o produto que foi adicionado 
     */
    public Produto adicionar(Produto produto){
        return produtoRepository.adicionar(produto); 
    }

    /**
     * Metodo para deletar um produto por Id 
     * @param id id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }

    /**
     * Metodo usado para atualizar o produto na lista
     * @param produto Produto que será atualizado
     * @return Retorna o produto atualizado
     */
    public Produto atualizar(Integer id, Produto produto) {
        produto.setId(id);

        return produtoRepository.atualizar(produto);
}}
