package persistencia;

import entidade.Rota;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author leandroDavid
 */
public class RotaDAO {
  
    public Rota salvar(Rota p){
        Transaction tx = null;
        try{
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            tx = sessao.beginTransaction();
 
            sessao.save(p);
            sessao.flush();
            tx.commit();

            sessao.close();
        } catch (Exception e) {
            e.printStackTrace();
            if(tx != null) {
                tx.rollback();
            }
        }

        return p;
    }

    public Rota buscar(int id){
        return (Rota) HibernateUtil.getSessionFactory().openSession().get(Rota.class, id);
    }

    public List<Rota> consultar(String palavra){

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Rota.class);
        criteria.add(Restrictions.like("texto", "%" + palavra + "%"));

        return criteria.list();
    }
    
    public void deletar(int id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        sessao.delete(sessao.get(Rota.class, id));
    }
    
    public Rota atualizar(int id, Rota novo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Rota antiga = (Rota) sessao.get(Rota.class, id);
        
       antiga.setTempo(novo.getTempo());
       antiga.setLocalizacaoEntregador(novo.getLocalizacaoEntregador());
       antiga.setEnderecoEntrega(novo.getEnderecoEntrega());
        
        sessao.save(antiga); 
        sessao.flush();
        
        return antiga;
    }
}
     
 
