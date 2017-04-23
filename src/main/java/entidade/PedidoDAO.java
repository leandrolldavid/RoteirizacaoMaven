package entidade;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import java.util.List;

/**
 * Created by rafael on 06/04/17.
 */
public class PedidoDAO {


    public Pedido salvar(Pedido p){
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

    public Pedido buscar(int id){
        return (Pedido) HibernateUtil.getSessionFactory().openSession().get(Pedido.class, id);
    }

    public List<Pedido> consultar(String palavra){

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.like("texto", "%" + palavra + "%"));

        return criteria.list();
    }
    
    
    
    public void deletar(int id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        sessao.delete(sessao.get(Pedido.class, id));
    }
    
    public Pedido atualizar(int id, Pedido novo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Pedido antiga = (Pedido) sessao.get(Pedido.class, id);
        
        antiga.setNumeroPedido(novo.getNumeroPedido());
        antiga.setDescricao(novo.getDescricao());
        antiga.setEnderecoCliente(novo.getEnderecoCliente());
        antiga.setNomeCliente(novo.getNomeCliente());
        antiga.setTelefoneCliente(novo.getTelefoneCliente());
        antiga.setTelefoneCliente(novo.getTelefoneCliente());
        antiga.setStatus(novo.getStatus());
        
        antiga.setEntrega(novo.getEntrega());
        antiga.setFuncionairo(novo.getFuncionairo());
        antiga.setRota(novo.getRota());
        antiga.setRotaReal(novo.getRotaReal());
        
        sessao.save(antiga);
        sessao.flush();
        
        return antiga;
    }
    
    








}
