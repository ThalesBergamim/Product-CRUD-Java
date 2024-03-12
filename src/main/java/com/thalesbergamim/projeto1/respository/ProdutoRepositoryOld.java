package com.thalesbergamim.projeto1.respository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.thalesbergamim.projeto1.model.Produto;
import com.thalesbergamim.projeto1.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepositoryOld {
    
    //Criando um repositorio de produtos
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0; 
    
    /**
     * Metodo para retornar uma lista com todos os produtos
     * @return Retorna todos os produtos da lista
     */
    public static List<Produto> obterTodos(){
        return produtos; 
    }

    /**
     * Metodo que procura o procuto pelo Id
     * @param id do produto para localizar
     * @return Retorna o produto caso seja encontrato 
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
                    .stream()
                    .filter(produtos -> produtos.getId() == id)
                    .findFirst();
    }

    /**
     * Metodo para adicionar um produto na lista
     * @param produto Produto que será adicionado   
     * @return retorna o produto que foi adicionado 
     */
    public Produto adicionar(Produto produto){
        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto; 
    }

    /**
     * Metodo para deletar um produto por Id 
     * @param id id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }


    /**
     * Metodo usado para atualizar o produto na lista
     * @param produto Produto que será atualizado
     * @return Retorna o produto atualizado
     */
    public Produto atualizar(Produto produto) {
        //Procura o produto pelo ID
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        //Se o ID digitado não estiver no banco aparece essa mensagem
        if (produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado!");
        }
        //Remove o produto da lista caso tenha encontrado o ID
        deletar(produto.getId());
        //Depois adiciona o produto atualizado na lista e retorna ele 
        produtos.add(produto);

        return produto; 
    }
}
