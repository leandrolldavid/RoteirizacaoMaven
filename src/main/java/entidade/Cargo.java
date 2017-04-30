package entidade;
    
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Leandro David
 * @author Thayllan Siqueira
 */
@Entity 
@Table(name = "tbCargo")
public class Cargo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdCargo;
    
    @Column
    private String perfil;


    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Integer getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(Integer IdCargo) {
        this.IdCargo = IdCargo;
    }
}
