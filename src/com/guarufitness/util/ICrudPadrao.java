/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guarufitness.util;

import java.util.List;

/**
 *
 * @author Felipe
 */
public interface ICrudPadrao<E> {
    public void inserir(E param);
    public void atualizar(E param);
    public E buscar(Integer codigo);
    public List<E> listar(); 
}
