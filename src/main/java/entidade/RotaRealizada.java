/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 *
 * @author Leandro David
 * @author Thayllan Siqueira
 */
@Entity (name = "tbRotaRealizada")
public class RotaRealizada {
    @Id
    private int IdRotaReal;
    private String EnderecoEntrega;
    private String LocalizacaoEntregador;
    private Time tempo;     //<<<<<<< classifiquei como time? verificar!!!

    public int getIdRotaReal() {
        return IdRotaReal;
    }
    public void setIdRotaReal(int IdRotaReal) {
        this.IdRotaReal = IdRotaReal;
    }
    
    public String getEnderecoEntrega() {
        return EnderecoEntrega;
    }
    public void setEnderecoEntrega(String EnderecoEntrega) {
        this.EnderecoEntrega = EnderecoEntrega;
    }

    public String getLocalizacaoEntregador() {
        return LocalizacaoEntregador;
    }
    public void setLocalizacaoEntregador(String LocalizacaoEntregador) {
        this.LocalizacaoEntregador = LocalizacaoEntregador;
    }

    public Time getTempo() {
        return tempo;
    }

    public void setTempo(Time tempo) {
        this.tempo = tempo;
    }

  
    
}
