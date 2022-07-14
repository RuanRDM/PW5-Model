/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Passagem;
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
public class TestePersistirVooAgendado {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW5-Model-PU");
        EntityManager em = emf.createEntityManager();
        VooAgendado v = new VooAgendado();
        v.setAeronave("teste");
        v.setData(Calendar.getInstance());
        v.setTotalPassageiros(5);
        v.setVoo(em.find(Voo.class, 14));
        //v.getPassagens().add(em.find(Passagem.class, 7));

        
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
