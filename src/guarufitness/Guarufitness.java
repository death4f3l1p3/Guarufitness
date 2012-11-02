/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guarufitness;

import com.guarufitness.model.Cliente;
import com.guarufitness.model.ClienteDAO;

/**
 *
 * @author Felipe
 */
public class Guarufitness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        cliente.setNome("Anna Stepanovna Politkovskaya");//Terá cod_cliente = 2
        cliente.setTelefone("(11)1111-2222");
        cliente.setCpf("12345678902");
        cliente.setRg("1234567-8");
        cliente.setStatus(true);
        
        clienteDAO.inserir(cliente);
        
        Cliente novoCliente = clienteDAO.buscar(1);
            System.out.println("Nome: "+novoCliente.getNome());
            System.out.println("Telefone: "+novoCliente.getTelefone());
            System.out.println("CPF: "+novoCliente.getCpf());
            System.out.println("Rg: "+novoCliente.getRg());
            System.out.println("Status: "+novoCliente.isStatus());
        System.out.print("\nOperação Realizada!:D");
        
        
        /*
        cliente.setNome("Gregor Samsa");
        cliente.setTelefone("(11)1111-2222");
        cliente.setCpf("12345678902");
        cliente.setRg("1234567-8");
        cliente.setStatus(true);
        
        clienteDAO.inserir(cliente);
        
        System.out.print("\nOperação Realizada!:D");
        
        cliente.setNome("George Orwell");
        cliente.setTelefone("(11)1984-1984");
        cliente.setCpf("12345678902");
        cliente.setRg("1234567-8");
        cliente.setStatus(false);
        cliente.setCod_cliente(1);
        
        clienteDAO.atualizar(cliente);
        
        System.out.print("\nOperação Realizada!:D");
        
       for(Cliente x : clienteDAO.listar() ){
            System.out.println("Códgigo: "+x.getCod_cliente());
            System.out.println("Nome: "+x.getNome());
            System.out.println("Telefone: "+x.getTelefone());
            System.out.println("CPF: "+x.getCpf());
            System.out.println("Rg: "+x.getRg());
            System.out.println("Status: "+x.isStatus());
            
        }
        System.out.print("\nOperação Realizada!:D");
        
        
        */
    }
}
