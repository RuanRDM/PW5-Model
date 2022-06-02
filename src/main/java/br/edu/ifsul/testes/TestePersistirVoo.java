/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.modelo.VooAgendado;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ruan_
 */
public class TestePersistirVoo {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW5-Model-PU");
        EntityManager em = emf.createEntityManager();
        Voo v = new Voo();
        
        
        v.setAtivo(true);
        //v.setEscalas(em.find(Aeroporto.class, 1));
        v.setTempoEstimado(65.0);
        v.setPeriodicidade("1 vez ano");
        v.setDescricao("voo para disney");
        //v.getAeroportos().add(em.find(Aeroporto.class, 1));
        //v.getVooagendado().add(em.find(VooAgendado.class, 1));
       

        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
