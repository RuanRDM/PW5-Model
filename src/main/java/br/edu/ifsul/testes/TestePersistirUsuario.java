package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistirUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW5-Model-PU");
        EntityManager em = emf.createEntityManager();
        Usuario u = new Usuario();
        u.setAtivo(true);
        u.setEmail("hacker@ifsul.edu.br");
        u.setNome("hacker");
        u.setNomeUsuario("hacker");
        u.setSenha("1234");
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }

}