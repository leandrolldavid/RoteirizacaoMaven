package controle;
/**
 *
 * @author leandroDavid
 */
 
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 


import Entidade.Cargo;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class ControleCargo {
    
     @CrossOrigin(origins = "http://editor.swagger.io")
     @RequestMapping(method = RequestMethod.PUT, value = "/cargo/{id}")
     public Cargo atualizarCargo(@RequestBody Cargo p, @PathVariable("id") int id){
        //jogar p no BD e receher do BD o id
        //preencher o id de p
        p.setIdCargo(1);
        return p;
    }
    
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping(method = RequestMethod.POST, value = "/cargo")
    public Cargo criarCargo(@RequestBody Cargo p){
        //jogar p no BD e receher do BD o id
        //preencher o id de p
         p.setPerfil("Gerente");
         return p;
    }
    
     @CrossOrigin(origins = "http://editor.swagger.io")
     @RequestMapping("/cargo/{id}")
    public Cargo buscarCargo(@PathVariable("id") int id){
        
         Cargo p = new Cargo();
         p.setPerfil("Gerente");
         p.setIdCargo(id);
         return p;
     }
    
    //GET cargo
    @CrossOrigin(origins = "http://editor.swagger.io")
    @RequestMapping("/cargo")
    public List<Cargo> buscarCargo(){
        List resultado = new ArrayList<>();
        
         Cargo p1 = new Cargo();
         p1.setPerfil("Gerente");
         p1.setIdCargo(1);
        
         resultado.add(p1);
        
        
         return resultado;
                
     }
}


