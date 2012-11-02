/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guarufitness.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class ConexaoFactoryMySql implements IConexaoFactory{
    Connection conn;
    @Override
    public Connection gerarConexao(String host, String usuario, String senha) {
        try{
        this.conn = DriverManager.getConnection(host, usuario, senha);
        }catch(SQLException e){
            System.out.printf("Erro na abertura da conexão. Detalhe: "+ e.getMessage());
        }
        return this.conn;
    }

    @Override
    public void encerrarConexao(Connection conexao) {
        try{
            conexao.close();
        }catch(SQLException e){
            System.out.print("Erro no fechamento da conexão. Detalhe: "+e.getMessage());
        }
    }
    
}
