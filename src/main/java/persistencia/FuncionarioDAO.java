package persistencia;

import entidade.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by rafael on 06/04/17.
 */
public class FuncionarioDAO {


    public Funcionario salvar(Funcionario f){
        Transaction tx = null;
        try{
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            tx = sessao.beginTransaction();

            sessao.save(f);
            sessao.flush();
            tx.commit();

            sessao.close();
        } catch (Exception e) {
            e.printStackTrace();
            if(tx != null) {
                tx.rollback();
            }
        }

        return f;
    }

    public Funcionario buscar(int id){
        return (Funcionario) HibernateUtil.getSessionFactory().openSession().get(Funcionario.class, id);
    }

    public List<Funcionario> consultar(String palavra){

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.add(Restrictions.like("texto", "%" + palavra + "%"));
        

        return criteria.list();
    }
    
    public void deletar(int id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        sessao.delete(sessao.get(Funcionario.class, id));
    }
    
    public Funcionario atualizar(int id, Funcionario novo){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Funcionario antiga = (Funcionario) sessao.get(Funcionario.class, id);
        
        antiga.setNome(novo.getNome());
        antiga.setCPF(novo.getCPF());
        antiga.setEndereco(novo.getEndereco());
        antiga.setTelefone(novo.getTelefone());
        antiga.setStatus(novo.getStatus());
        antiga.setLogin(novo.getLogin());
        antiga.setSenha(novo.getSenha());
        antiga.setSenha(novo.getSenha());
        
        antiga.setCargo(novo.getCargo());
        
        
        sessao.save(antiga);
        sessao.flush();
        
        return antiga;
    }
    
}
