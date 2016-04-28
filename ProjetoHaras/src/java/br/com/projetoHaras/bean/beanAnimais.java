package br.com.projetoHaras.bean;

import br.com.projetoHaras.dao.AnimaisDao;
import br.com.projetoHaras.model.animais;
import br.com.projetoHaras.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MBAnimais")
@ViewScoped
public class beanAnimais {

    public ArrayList<animais> getItens() {
        return itens;
    }

    public void setItens(ArrayList<animais> itens) {
        this.itens = itens;
    }

    public animais getAnimais() {
        return animais;
    }

    public void setAnimais(animais animais) {
        this.animais = animais;
    }
    private ArrayList<animais> itens;
    private animais animais;
    
     @PostConstruct
    public void prepararPesquisa() {
        AnimaisDao dao = new AnimaisDao();
        try {
            itens = dao.lista();
        } catch (SQLException ex) {
            Logger.getLogger(beanAnimais.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(beanAnimais.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void prepararAnimal() {
        animais = new animais();
    }
      
      public void novoAnimal() throws ClassNotFoundException {
        try {
            AnimaisDao dao = new AnimaisDao();
            dao.salvar(animais);
            itens = dao.lista();
            JSFUtil.addMsgSucesso("Animal salvo com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }

    }
      
     public void excluirAnimal() throws ClassNotFoundException {
        try {
            AnimaisDao dao = new AnimaisDao();
            dao.excluir(animais);
            itens = dao.lista();
            JSFUtil.addMsgSucesso("Animais excluida com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }
    }
     
         public void editarAnimal() throws ClassNotFoundException {
        try {
            AnimaisDao dao = new AnimaisDao();
            dao.editar(animais);
            itens = dao.lista();
            JSFUtil.addMsgSucesso("Animal editada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JSFUtil.addMsgErro(e.getMessage());
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            JSFUtil.addMsgErro(ex.getMessage());
        }

    }
}
