package servMediador;
import java.util.List;
import entidade.Cargo;
import persistencia.CargoDAO;

/**
 *
 * @author leandroDavid
 */
public class MedCargo {
     private CargoDAO cargoDAO;
     
     public String salvarCargo(Cargo t) throws Exception{
        try {
            String message = "";
           Cargo cargo = cargoDAO.salvar(t);
           if(cargo != null){
              message = "Questão incluída com sucesso"; 
           }else {
               message = "Erro de inclusão Questão, contate o administrador do sistema";
           }return message;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
         
     }
           public List<Cargo> listCargo() throws Exception {
        
            try {
            return cargoDAO.listCargo();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
           
        public Cargo BuscarCargo(Integer id) throws Exception {
            try {
            return cargoDAO.consultar(id);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }   
        }
        
        public String atualizar(Cargo car) throws Exception{
        try {
            String message = ""; 
           String cargo = cargoDAO.atualizar(car);
           if(cargo != null){
              message = "Questão incluída com sucesso"; 
           }else {
               message = "Erro de inclusão Questão, contate o administrador do sistema";
           }return message;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
         
     }
         
}
