package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPermissoesUsuario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW5-Model-PU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, "hacker");
        Permissao pusuario = em.find(Permissao.class, "USUARIO");
        //Permissao padmin = em.find(Permissao.class, "ADMINISTRADOR");
        //u.getPermissoes().add(padmin);
        u.getPermissoes().add(pusuario);
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}