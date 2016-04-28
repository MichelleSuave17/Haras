
package br.com.projetoHaras.factory;

import br.com.projetoHaras.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class teste {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}

