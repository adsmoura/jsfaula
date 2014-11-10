/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.mouralacerda.bean;

import br.edu.mouralacerda.Pessoa;
import br.edu.mouralacerda.dao.PessoaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author João Paulo B. Casati
 */
@ManagedBean
public class PessoaBean {

    private Pessoa p = new Pessoa();

    private List<Pessoa> pessoas = new ArrayList<>();
    
    private final PessoaDAO pDAO = new PessoaDAO();

    public void salvarPessoa() {
        pDAO.salvar(p);
        p = new Pessoa();
        carregaLista();
    }
    
    public void excluirPessoa(Pessoa p) {
        System.out.println("oi");
        pDAO.excluir(p);
        System.out.println("tchau");
        carregaLista();
    }
    
    @PostConstruct
    public void carregaLista(){
        pessoas = pDAO.consultarLista();
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
