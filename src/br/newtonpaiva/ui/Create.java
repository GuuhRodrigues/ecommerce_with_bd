package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Categoria;
import br.newtonpaiva.dominio.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Create {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("EC-PU");

        EntityManager em = factory.createEntityManager();


        em.getTransaction().begin();

        Produto p = new Produto();
        p.setNome("Dota2");

        Categoria c = new Categoria();
        //c.setId(1);
        c.setNome("Jogos");

        List<Produto> produtos = new ArrayList<>();
        c.setProdutos(produtos);
        produtos.add(p);

//        Categoria c2 = new Categoria();
//        //c.setId(2);
//        c.setNome("Filmes");

        em.persist(c);

        em.getTransaction().commit();
        em.close();
        factory.close();

    }
}
