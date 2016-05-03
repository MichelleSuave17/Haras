package br.com.projetoHaras.dao;

import br.com.projetoHaras.factory.ConnectionFactory;
import br.com.projetoHaras.model.competidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompetidorDao {
        public void salvar(competidor d) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO competidor(nome, posicao, cod_animais, modalidade) VALUES(?, ?, ?, ?)";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, d.getNome());
        stmt.setInt(2, d.getPosicao());
        stmt.setInt(3, d.getId_animais());
        stmt.setString(4, d.getModalidade());
        stmt.execute();
        stmt.close();
        
    }  
        public void excluir(competidor d) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM competidor WHERE id_competidor = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, d.getId_competidor());
        stmt.execute();
        stmt.close();
    }
         public void editar(competidor d)throws ClassNotFoundException,SQLException{
        String sql= "UPDATE competidor SET nome = ?, posicao =?, cod_animais =?, modalidade =? WHERE id_competidor = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString (1, d.getNome());
        stmt.setInt(2, d.getPosicao());; 
         stmt.setInt(3, d.getId_animais());
         stmt.setString (4, d.getModalidade());
         stmt.setInt(5, d.getId_competidor());   
        stmt.execute();
        stmt.close();
}        
         public competidor pesquisar(competidor d)throws ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM competidor WHERE id_competidor = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, d.getId_competidor());
        
        ResultSet rs = stmt.executeQuery();
        competidor retorno = null;
           if(rs.next()){
            retorno = new competidor();
            retorno.setId_competidor(rs.getInt("id_competidor"));
            retorno.setNome(rs.getString("nome"));
            retorno.setPosicao(rs.getInt("posicao"));
            retorno.setId_animais(rs.getInt("cod_animais"));
            retorno.setModalidade(rs.getString("modalidade"));
        }
        return retorno;

}         
        public ArrayList<competidor> lista()throws SQLException, ClassNotFoundException{
        String sql = "select competidor.id_competidor, competidor.nome, competidor.posicao, competidor.modalidade,  animais.nome from competidor "
                + "inner join animais on animais.id_animais = competidor.cod_animais ";
                
        Connection connection = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<competidor> lista = new ArrayList<competidor>();
        
        while(rs.next()){
            competidor e = new competidor();
            e.setId_competidor(rs.getInt("id_competidor"));
            e.setNome(rs.getString("nome"));
            e.setPosicao(rs.getInt("posicao"));
            e.setModalidade(rs.getString("modalidade"));
            e.setNomeA(rs.getString("cod_animais"));
           
            lista.add(e);
        }
        return lista;
    }
        
}
