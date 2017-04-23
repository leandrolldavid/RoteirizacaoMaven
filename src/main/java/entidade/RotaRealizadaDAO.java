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
public class RotaRealizadaDAO {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RA21551055
 */
public class RotaDAO {
    public RotaRealizada salvar(RotaRealizada p){
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

    public RotaRealizada buscar(int id){
        return (RotaRealizada) HibernateUtil.getSessionFactory().openSession().get(RotaRealizada.class, id);
    }

    public List<RotaRealizada> consultar(String palavra){

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(RotaRealizada.class);
        criteria.add(Restrictions.like("texto", "%" + palavra + "%"));

        return criteria.list();
    }
    
    public void deletar(int id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        sessao.delete(sessao.get(RotaRealizada.class, id));
    }
    
    public RotaRealizada atualizar(int id, RotaRealizada novo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        RotaRealizada antiga = (RotaRealizada) sessao.get(RotaRealizada.class, id);
        
        antiga.setTempo(novo.getTempo());
        antiga.setLocalizacaoEntregador(novo.getLocalizacaoEntregador());
        antiga.setEnderecoEntrega(novo.getEnderecoEntrega());
        
        sessao.save(antiga);
        sessao.flush();
        
        return antiga;
    }
    
}

    
}
