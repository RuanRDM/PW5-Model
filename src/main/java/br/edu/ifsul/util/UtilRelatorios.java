/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Aeroporto;
import br.edu.ifsul.modelo.Cidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruan_
 */
public class UtilRelatorios {
    
    public static List<Aeroporto> carregaAeroportos(){
        Aeroporto a = new Aeroporto();
        List<Aeroporto> lista = new ArrayList<>();
        a.setId(1);
        a.setNome("Aero de pf");
        a.setOperacaoNoturna(true);
        Cidade c = new Cidade();
        c.setNome("Passo Fundo");
        a.setCidade(c);
        lista.add(a);
        return lista;
    }
}
