/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author RA21551055
 */
public class EntregaDAO {
     public Entrega salvar(Entrega c){
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

    public Entrega buscar(int id){
        return (Entrega) HibernateUtil.getSessionFactory().openSession().get(Entrega.class, id);
    }

    public List<Entrega> consultar(String palavra){

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Entrega.class);
        criteria.add(Restrictions.like("texto", "%" + palavra + "%"));

        return criteria.list();
    }
    
    public void deletar(int id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        sessao.delete(sessao.get(Entrega.class, id));
    }
    
    public Entrega atualizar(int id, Entrega novo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Entrega antiga = (Entrega) sessao.get(Entrega.class, id);
        
        antiga.setFuncionario(novo.getFuncionario());
        antiga.setNumMax(novo.getNumMax());
        sessao.save(antiga);
        sessao.flush();
        
        return antiga;
    }
    
}
