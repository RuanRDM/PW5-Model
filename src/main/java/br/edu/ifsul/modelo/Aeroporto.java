package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author ruan_
 */
@Entity
@Table(name = "aeroporto")
public class Aeroporto implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_aeroporto", sequenceName = "seq_aeroporto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aeroporto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @NotNull(message = "O operacao noturna ativo deve ser informado")
    @Column(name = "operacaonoturna", nullable = false)
    private Boolean operacaoNoturna;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false)
    private Cidade cidade;
    @ManyToMany
    @JoinTable(name = "voo",
            // se refere a classe aeroporto
            joinColumns = 
                    @JoinColumn(name = "id", referencedColumnName = "nome", 
                            nullable = false),
            // se refere ao tipo da lista <voo>
            inverseJoinColumns = 
                    @JoinColumn(name = "voo", referencedColumnName = "descricao", 
                            nullable = false)
            )            
    private Set<Voo> voos = new HashSet<>();
    
    public Aeroporto(){
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aeroporto other = (Aeroporto) obj;
        return Objects.equals(this.getId(), other.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getOperacaoNoturna() {
        return operacaoNoturna;
    }

    public void setOperacaoNoturna(Boolean operacaoNoturna) {
        this.operacaoNoturna = operacaoNoturna;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Set<Voo> getVoos() {
        return voos;
    }

    public void setVoos(Set<Voo> voos) {
        this.voos = voos;
    }
    
}
