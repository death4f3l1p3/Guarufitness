/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guarufitness.util;

import java.sql.Connection;


/**
 *
 * @author Felipe
 */
public interface IConexaoFactory {
    public Connection gerarConexao(String host,String usuario,String senha);
    public void encerrarConexao(Connection conexao);
}
