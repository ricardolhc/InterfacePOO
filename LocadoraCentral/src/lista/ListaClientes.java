/**
 * A classe ListaClientes representa uma lista de clientes.
 * @author Mateus, Maurício, Ricardo, Tales
 * @since nov 2022
 * @version 1.0
 */

package lista;

import java.util.ArrayList;

import exceptions.cliente.ClienteNotFoundException;
import exceptions.geral.EmptyList;

public class ListaClientes implements IClientes {


    /**
     * Arraylist do tipo cliente para armazenar clientes
     */
    private ArrayList<Cliente> clientes;


    /**
     * Construtor default da classe
     */
    public ListaClientes() {
        clientes = new ArrayList<Cliente>();
    }


    
    /** 
     * @param cliente parâmetro necesário para adicionar o cliente
     */
    @Override
    public void add(Cliente cliente) {
        clientes.add(cliente);
    }

    
    /** 
     * @param CPF cpf do cliente a ser procurado
     * @return O cliente que tem o cpf informado
     */
    @Override   
    public Cliente get(long CPF) {
        for(Cliente cliente : clientes) {
            if(Long.parseLong(cliente.getCpf()) == CPF) {
                return cliente;
            }
        }
        throw new ClienteNotFoundException("Cliente não encontrado");
    }

    
    /** 
     * @param CPF cpf do cliente usado para procurar as informações
     * @return String com as informações do cliente
     */
    @Override
    public String getInfo(long CPF) {
        try {
            return get(CPF).toString();
        } catch (ClienteNotFoundException e) {
            return e.getMessage();
        }
    }

    
    /** 
     * @return String com todas as informações dos clientes
     */
    @Override
    public String getInfo() {
        if(clientes.size() > 0) {
            String conteudo = "";
            for(Cliente cliente : clientes) {
                conteudo += cliente.toString() + "\n";
            }
            return conteudo;
        }
        throw new EmptyList("Não existem clientes cadastrados");
    }

    
    /** 
     * @return String com as informações resumidas dos clientes
     */
    @Override
    public String getResumoInfo() {
        if(clientes.size() > 0) {
            String conteudo = "";
            for(Cliente cliente : clientes) {
                conteudo += cliente.getResumo() + "\n";
            }
            return conteudo;
        }
        throw new EmptyList("Não existem clientes cadastrados");
    }

    
    /** 
     * @param CPF long utilizado para identificar o cliente
     * @return boolean se o cliente foi removido do sistema ou não
     */
    @Override
    public boolean remove(long CPF) {
        for(Cliente cliente : clientes) {
            if(Long.parseLong(cliente.getCpf()) == CPF) {
                clientes.remove(cliente);
                return true;
            }
        }
        return false;       
    }

    
    /** 
     * @param CPF long utilizado para identificar o cliente
     * @return boolean se o cliente existe ou não
     */
    @Override
    public boolean existe(long CPF) {
        for(Cliente cliente : clientes) {
            if(Long.parseLong(cliente.getCpf()) == CPF) {
                return true;
            }
        }
        return false;
    }

    
    /** 
     * @param CPF long utilizado para identificar o cliente
     * @param nome String que identifica o cliente
     */
    public void setNome(long CPF, String nome) throws ClienteNotFoundException {
        get(CPF).setNome(nome);
    }

    
    /** 
     * @param CPF long utilizado para identificar o cliente
     * @param numeroCarteiraMotorista int que identifica o número da carteira de motorista do cliente
     */
    public void setNumeroCarteira(long CPF, int numeroCarteiraMotorista) throws ClienteNotFoundException {
        get(CPF).setNumeroCarteira(numeroCarteiraMotorista);
    }

    
    /** 
     * @param CPF long utlizado para identificar o cliente
     * @param endereco String que identifica o endereço do cliente
     */
    public void setEndereco(long CPF, String endereco) throws ClienteNotFoundException {
        get(CPF).setEndereco(endereco);
    }

    
    /** 
     * @param CPF long utilizado para identificar o cliente
     * @param telefone int que identifica o telefone do cliente
     */
    public void setTelefone(long CPF, long telefone) throws ClienteNotFoundException {
        get(CPF).setTelefone(telefone);
    }
    
}