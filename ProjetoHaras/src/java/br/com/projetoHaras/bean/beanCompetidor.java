package br.com.projetoHaras.bean;

import br.com.projetoHaras.dao.CompetidorDao;
import br.com.projetoHaras.model.competidor;
import br.com.projetoHaras.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBCompetidor")
@ViewScoped
public class beanCompetidor {

    public ArrayList<competidor> getItens() {
        return itens;
    }

    public void setItens(ArrayList<competidor> itens) {
        this.itens = itens;
    }

    public competidor getCompetidor() {
        return competidor;
    }

    public void setCompetidor(competidor competidor) {
        this.competidor = competidor;
    }
    private ArrayList<competidor> itens;
    private competidor competidor;
    
      @PostConstruct
    public void prepararPesquisa() {
        CompetidorDao dao = new CompetidorDao();
        try {
            itens = dao.lista();
        } catch (SQLException ex) {
            Logger.getLogger(beanCompetidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(beanCompetidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void prepararCompetidor() {
        competidor = new competidor();
    }
        
        public void novoCompetidor() throws ClassNotFoundException {
        try {
            CompetidorDao dao = new CompetidorDao();
            dao.salvar(competidor);
            itens = dao.lista();
            JSFUtil.addMsgSucesso("Competidor salva com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }

    }
        
        public void excluirCompetidor() throws ClassNotFoundException {
        try {
            CompetidorDao dao = new CompetidorDao();
            dao.excluir(competidor);
            itens = dao.lista();
            JSFUtil.addMsgSucesso("Competidor excluido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }
        
       public void editarCompetidor() throws ClassNotFoundException {
        try {
            CompetidorDao dao = new CompetidorDao();
            dao.editar(competidor);
            itens = dao.lista();
            JSFUtil.addMsgSucesso("Competidor editado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
}
}
