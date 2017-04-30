package entidade;
    
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
    private int IdCargo;
    
    private String perfil;

    public int getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
}
