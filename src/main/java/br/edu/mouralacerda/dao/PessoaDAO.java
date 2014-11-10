/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mouralacerda.dao;

import br.edu.mouralacerda.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author João Paulo B. Casati
 */
public class PessoaDAO {
    
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste.jsf");
    final EntityManager em = factory.createEntityManager();
    
    public void salvar(Pessoa p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public Pessoa consultarPessoa(String cpf){
        Pessoa p = em.find(Pessoa.class, cpf);
        return p;
    }
    
    public List<Pessoa> consultarLista(){
        
        TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p", Pessoa.class);
        List<Pessoa> pessoas = query.getResultList();
        return pessoas;
    }
    
    public void excluir(Pessoa p){
        em.getTransaction().begin();
        p = em.merge(p);
        em.remove(p);
        em.getTransaction().commit();
    }
    
}
