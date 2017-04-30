
package controle;
/**
 *
 * @author leandroDavid
 */

import entidade.Cargo;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.http.MediaType;
import static org.springframework.http.RequestEntity.method;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import servMediador.MedCargo;

 
@RestController
public class ControleCargo {
    
     private MedCargo medCargo;
    //post ok ||
    //        ||
    //        \/
     
    @RequestMapping(value = "/cargo",
                    method = RequestMethod.POST )
    public String criarCargo(@RequestBody Cargo p)throws Exception {
        //jogar p no BD e receher do BD o id
        //preencher o id de p
        return medCargo.salvarCargo(p);  
    } 
    
       @RequestMapping(value = "/cargo/{id}",
                    method = RequestMethod.GET)
    public Cargo buscarCargo(@PathVariable("id") Integer id) throws Exception{
        
                return medCargo.BuscarCargo(id);
         
     }
    
      //GET cargo
    @RequestMapping(value = "/cargo/lista", method = RequestMethod.GET)
    public List<Cargo> listCargo() throws Exception {
        return medCargo.listCargo();//verificar se esta certo
    }
    //         /\
    //         ||
    // Ate aqui||
    
   
    
     @RequestMapping(method = RequestMethod.PUT, value = "/cargo/{id}")
     public Cargo atualizarCargo(@RequestBody Cargo p, @PathVariable("id") int id){
        //jogar p no BD e receher do BD o id
        //preencher o id de p
        p.setIdCargo(1);
        return p;
    }
     @RequestMapping(
            value = "/cargo",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String atualizar(@RequestBody Cargo cargo) throws Exception {
        return medCargo.atualizar(cargo);
    }
  
}


