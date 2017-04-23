/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;
  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
 
/** 
 *
 * @author Leandro David
 * @author Thayllan Siqueira
 */
@Entity (name = "tbFuncioanrio")
public class Funcionario { 
    
     @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdFuncionario;
    
    private String Nome; 
    private String CPF;
    private String Endereco;
    private String Telefone;
    private String Status;
    private String login;
    private String Senha;
    
    @ManyToOne
    private Cargo cargo;

    public int getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(int IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public Cargo getCargo() {
        return cargo;
    }
 
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
