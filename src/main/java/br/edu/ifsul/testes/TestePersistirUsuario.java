package br.edu.ifsul.testes;

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
        u.setEmail("ruan@ifsul.edu.br");
        u.setNome("ruan");
        u.setNomeUsuario("ruan");
        u.setSenha("123456");
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }

}