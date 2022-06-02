package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "passagem")
public class Passagem implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_passagem", sequenceName = "seq_passagem_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_passagem", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data da compra deve ser informada")
    @Column(name = "data_compra", nullable = false)
    private Calendar dataCompra;
    @NotBlank(message = "A bagagem não pode estar em branco")
    @Length(max = 12, message = "A bagagem não pode ter mais que {max} caracteres")
    @Column(name = "bagagem", length = 40, nullable = false)
    private Integer bagagem;
    @NotNull(message = "O Voo Agendado deve ser informado")
    @ManyToOne
    @JoinColumn(name = "vooagendado_id", referencedColumnName = "id", nullable = false)    
    private VooAgendado vooagendado;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "classe", referencedColumnName = "id", nullable = false)
    private Classe classe;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    public Passagem(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getBagagem() {
        return bagagem;
    }

    public void setBagagem(Integer bagagem) {
        this.bagagem = bagagem;
    }

    public VooAgendado getVooagendado() {
        return vooagendado;
    }

    public void setVooagendado(VooAgendado vooagendado) {
        this.vooagendado = vooagendado;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
