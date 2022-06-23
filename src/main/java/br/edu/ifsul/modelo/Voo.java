package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author ruan_
 */
@Entity
@Table(name = "voo")
public class Voo implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_voo", sequenceName = "seq_voo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_voo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    @Min(value = 0, message = "O Tempo estimado não pode ser negativo")
    @NotNull(message = "O Tempo estimado deve ser informado")
    @Column(name = "tempoestimado", nullable = false)
    private Double tempoEstimado;
    @NotNull(message = "O campo ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @NotBlank(message = "A periodicidade não pode ser em branco")
    @Length(max = 50, message = "A aeronave não pode ter mais que {max} caracteres")
    @Column(name = "periodicidade", length = 40, nullable = false)
    private String periodicidade;
    
    @JoinColumn(name = "escalas", referencedColumnName = "nome", nullable = false)    
    @ManyToOne
    private Aeroporto escalas;
    
    @OneToMany(mappedBy = "voo", cascade = CascadeType.ALL)
    private List<VooAgendado> vooAgendados = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "aeroportos",
            joinColumns = 
                    @JoinColumn(name = "id", referencedColumnName = "id", 
                            nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "aeroporto", referencedColumnName = "nome", 
                            nullable = false)
            )            
    private Set<Aeroporto> aeroportos = new HashSet<>();
    
    
    public Voo(){
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.getId());
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
        final Voo other = (Voo) obj;
        return Objects.equals(this.getId(), other.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public Aeroporto getEscalas() {
        return escalas;
    }

    public void setEscalas(Aeroporto escalas) {
        this.escalas = escalas;
    }

    public List<VooAgendado> getVooAgendados() {
        return vooAgendados;
    }

    public void setVooAgendados(List<VooAgendado> vooAgendados) {
        this.vooAgendados = vooAgendados;
    }

    public Set<Aeroporto> getAeroportos() {
        return aeroportos;
    }

    public void setAeroportos(Set<Aeroporto> aeroportos) {
        this.aeroportos = aeroportos;
    }






    
}
