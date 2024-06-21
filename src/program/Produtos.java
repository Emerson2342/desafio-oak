package program;

import entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class Produtos extends Produto {
    private static Produtos instance;

    private List<Produto> produtoList;

    public Produtos(){
        this.produtoList = new ArrayList<>();
    }

    public static Produtos getInstance(){
        if(instance == null){
            instance = new Produtos();
        }
        return instance;
    }

    public void adicionarProduto(String nome, String descricao, double valor, String disponivel ){
        produtoList.add(new Produto(nome, descricao, valor, disponivel));
    }

    public List<Produto> listaProdutos(){
       return produtoList;
    }


}
