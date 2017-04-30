package entidade;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author leandroDavid
 */

    @Entity
    @Table(name = "tbRota")
    public class Rota  {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdRota;
    
    private String EnderecoEntrega;
    private String LocalizacaoEntregador;
    private Time tempo;

    public Integer getIdRota() {
        return IdRota;
    }

    public void setIdRota(Integer IdRota) {
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

