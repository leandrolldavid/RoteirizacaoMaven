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
@Entity (name = "tbRota")
 class Rota {
    @Id
    private int IdRota;
    private String EnderecoEntrega;
    private String LocalizacaoEntregador;
    private Time tempo;

    public int getIdRota() {
        return IdRota;
    }
    public void setIdRota(int IdRota) {
        this.IdRota = IdRota;
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
