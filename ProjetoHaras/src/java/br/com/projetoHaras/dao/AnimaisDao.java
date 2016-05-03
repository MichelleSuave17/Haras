package br.com.projetoHaras.dao;

import br.com.projetoHaras.factory.ConnectionFactory;
import br.com.projetoHaras.model.animais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimaisDao {
     
        public void salvar(animais d)throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO animais (nome, raca) VALUES(?,?)";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, d.getNomeA());
        stmt.setString(2, d.getRaca());
        stmt.execute();
        stmt.close();      
    }
        public void excluir(animais d)throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM animais WHERE id_animais = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, d.getId_animais());
        stmt.execute();
        stmt.close();
    }          
        public void editar(animais d)throws ClassNotFoundException,SQLException{
        String sql= "UPDATE animais SET nome= ?, raca =? WHERE id_animais = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString (1, d.getNomeA());
        stmt.setString(2, d.getRaca());
         stmt.setInt(3, d.getId_animais()); 
        stmt.execute();
        stmt.close();
}           
        public animais pesquisar(animais d)throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM animais WHERE id_animais = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, d.getId_animais());
        
        ResultSet rs = stmt.executeQuery();
        animais retorno = null;
           if(rs.next()){
            retorno = new animais();
            retorno.setId_animais(rs.getInt("Id_editora"));
            retorno.setNomeA(rs.getString("nome"));
            retorno.setRaca(rs.getString("raca"));
        }
        return retorno;

}
        public ArrayList<animais> lista()throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM animais";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<animais> lista = new ArrayList<animais>();
        
        while(rs.next()){
            animais e = new animais();
            e.setId_animais(rs.getInt("id_animais"));
            e.setNomeA(rs.getString("nome"));
            e.setRaca(rs.getString("raca"));     
            lista.add(e);
        }
        return lista;
    }
            

}   


