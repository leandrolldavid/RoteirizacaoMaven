/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 *
 * @author Leandro David
 * @author Thayllan Siqueira
 */
@Entity (name = "tbEntrega")
public class Entrega {
    
    @Id
    private int IdEntrega;
    private int NumMax;
    private Funcionario Funcionario;

    public int getIdEntrega() {
        return IdEntrega;
    }

    public void setIdEntrega(int IdEntrega) {
        this.IdEntrega = IdEntrega;
    }

    public int getNumMax() {
        return NumMax;
    }

    public void setNumMax(int NumMax) {
        this.NumMax = NumMax;
    }

    public Funcionario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Funcionario Funcionario) {
        this.Funcionario = Funcionario;
    }
    
    
    
}
