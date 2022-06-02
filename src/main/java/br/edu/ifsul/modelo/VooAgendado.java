package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author ruan_
 */
@Entity
@Table(name = "vooagendado")
public class VooAgendado implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_vooagendado", sequenceName = "seq_vooagendado_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_vooagendado", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A aeronave não pode ser em branco")
    @Length(max = 25, message = "A aeronave não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String aeronave;
    @NotBlank(message = "O total de passageiros não pode estar em branco")
    @Length(max = 50, message = "O total de passageiros não pode ter mais que {max} caracteres")
    @Column(name = "totalpassageiros", length = 40, nullable = false)
    private Integer totalPassageiros;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
    @ManyToOne
    @JoinColumn(name = "voo_id", referencedColumnName = "descricao", nullable = false)    
    private Voo voo;
    @OneToMany(mappedBy = "vooagendado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Passagem> passagens = new ArrayList<>();
    
    
    
    public VooAgendado(){
        
    }
    
    public void adicionarPassagem(Passagem obj){
        obj.setVooagendado(this);
        this.getPassagens().add(obj);
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.getId());
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
        final VooAgendado other = (VooAgendado) obj;
        return Objects.equals(this.getId(), other.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public Integer getTotalPassageiros() {
        return totalPassageiros;
    }

    public void setTotalPassageiros(Integer totalPassageiros) {
        this.totalPassageiros = totalPassageiros;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
    
}
