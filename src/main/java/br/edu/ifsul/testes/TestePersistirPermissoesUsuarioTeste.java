package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistirPermissoesUsuarioTeste {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW5-Model-PU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, "ruand");
        Permissao padmin = em.find(Permissao.class, "USUARIO");
        padmin.getUsuarios().add(u);
        em.getTransaction().begin();
        em.persist(padmin);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}