/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guarufitness.model;

import com.guarufitness.util.ConexaoFactoryMySql;
import com.guarufitness.util.ICrudPadrao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ClienteDAO extends ConexaoFactoryMySql implements ICrudPadrao<Cliente>{
    PreparedStatement stmt;
    Connection conn;
    String url = "jdbc:mysql://localhost/guarufitness";
    String usuario = "root";
    String senha = "";
    @Override
    public void inserir(Cliente param) {
        this.stmt = null;
        this.conn = gerarConexao(url,usuario, senha);
        String insere = "INSERT INTO cliente(nome, telefone, cpf, rg, status) VALUES(?,?,?,?,?)";
        try{
        this.stmt = conn.prepareStatement(insere);
        this.stmt.setString(1, param.getNome());
        this.stmt.setString(2, param.getTelefone());
        this.stmt.setString(3, param.getCpf());
        this.stmt.setString(4, param.getRg());
        this.stmt.setBoolean(5, param.isStatus());
        this.stmt.execute();
        this.stmt.close();
        }catch(SQLException e){
            System.out.print("Erro na inclusão do Cliente"+e.getMessage());
        }finally{
            encerrarConexao(this.conn);
        }
    }

    @Override
    public void atualizar(Cliente param) {
        this.stmt = null;
        this.conn = gerarConexao(url,usuario, senha);
        String atualiza = "UPDATE cliente "
                + "SET nome = ?, telefone = ?, cpf = ?, rg = ?, status = ? "
                + "WHERE cod_cliente = ?";
        try{
        this.stmt = conn.prepareStatement(atualiza);
        this.stmt.setString(1, param.getNome());
        this.stmt.setString(2, param.getTelefone());
        this.stmt.setString(3, param.getCpf());
        this.stmt.setString(4, param.getRg());
        this.stmt.setBoolean(5, param.isStatus());
        this.stmt.setInt(6, param.getCod_cliente());
        this.stmt.executeUpdate();
        this.stmt.close();
        }catch(SQLException e){
            System.out.print("Erro na operação de atualização. Detalhe: "+e.getMessage());
        }finally{
            encerrarConexao(this.conn);
        }
    }

    @Override
    public Cliente buscar(Integer codigo) {
        this.conn = gerarConexao(url,usuario, senha);
        ResultSet resultado;
        Statement statement;
        Cliente cliente = new Cliente();
        String busca = "SELECT * FROM cliente WHERE cod_cliente = "+codigo+";";
        try{
            statement = conn.createStatement();
            resultado = statement.executeQuery(busca);
            while(resultado.next()){
                cliente.setCod_cliente(resultado.getInt("cod_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setStatus(resultado.getBoolean("status"));
            }
            statement.close();
            resultado.close();
        }catch(SQLException e){
            System.out.print("Erro na operação de busca ao cliente. Detalhe: "+e.getMessage());
        }finally{
            encerrarConexao(this.conn);
        }
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        this.conn = gerarConexao(url,usuario, senha);
        Statement statement;
        ResultSet resultado;
        List<Cliente> clientes = new ArrayList<>();
        String listar = "SELECT * FROM cliente;";
        try{
            statement = conn.createStatement();
            resultado = statement.executeQuery(listar);
            while(resultado.next()){
                Cliente cliente = new Cliente();
                cliente.setCod_cliente(resultado.getInt("cod_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setRg(resultado.getString("rg"));
                cliente.setStatus(resultado.getBoolean("status"));
                clientes.add(cliente);
            }
            statement.close();
            resultado.close();
        }catch(SQLException e){
            System.out.print("Erro na operação de listagem. Detalhe: "+e.getMessage());
        }finally{
            encerrarConexao(this.conn);
        }
        return clientes;
    }
    
}
