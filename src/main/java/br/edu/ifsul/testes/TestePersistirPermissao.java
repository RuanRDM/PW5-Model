package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistirPermissao {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW5-Model-PU");
        EntityManager em = emf.createEntityManager();
        Permissao pusuario = new Permissao();
        pusuario.setNome("USUARIO");
        pusuario.setDescricao("Usuário Simples");
        Permissao padmin = new Permissao();
        padmin.setNome("ADMINISTRADOR");
        padmin.setDescricao("Usuario Admin");
        em.getTransaction().begin();
        em.persist(pusuario);
        em.persist(padmin);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}