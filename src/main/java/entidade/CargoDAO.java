package entidade;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by rafael on 06/04/17.
 */
public class CargoDAO {

    public Cargo salvar(Cargo c){
        Transaction tx = null;
        try{
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            tx = sessao.beginTransaction();

            sessao.save(c);
            sessao.flush();
            tx.commit();

            sessao.close();
        } catch (Exception e) {
            e.printStackTrace();
            if(tx != null) {
                tx.rollback();
            }
        }

        return c;
    }

    public Cargo buscar(int id){
        return (Cargo) HibernateUtil.getSessionFactory().openSession().get(Cargo.class, id);
    }

    public List<Cargo> consultar(String palavra){

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Cargo.class);
        criteria.add(Restrictions.like("texto", "%" + palavra + "%"));

        return criteria.list();
    }
    
    public void deletar(int id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        sessao.delete(sessao.get(Cargo.class, id));
    }
    
    public Cargo atualizar(int id, Cargo novo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Cargo antiga = (Cargo) sessao.get(Cargo.class, id);
        
        antiga.setPerfil(novo.getPerfil());
        
        sessao.save(antiga);
        sessao.flush();
        
        return antiga;
    }
}
