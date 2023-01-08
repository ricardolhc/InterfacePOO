package controller.locacao;

import lista.Cliente;
import lista.Locacao;
import veiculo.Veiculo;

/**
 * A classe DadosTabela é responsável por armazenar os dados da tabela de locações
 * 
 * @author Mateus, Maurício, Ricardo, Tales
 * @since dez 2022
 * @version 1.0
 */
public class DadosTabela {
    
    /**
     * locacao para receber a locação que será exibida na tabela
     */
    private Locacao locacao;

    /**
     * veiculo para receber o veículo que será exibido na tabela
     */
    private Veiculo veiculo;
 
    /**
     * cliente para receber o cliente que será exibido na tabela
     */
    private Cliente cliente;

    /**
     * Construtor da classe DadosTabela que recebe como parâmetro a locação, o veículo e o cliente
     * @param locacao do tipo Locacao para receber a locação que será exibida na tabela
     * @param veiculo do tipo Veiculo para receber o veículo que será exibido na tabela
     * @param cliente do tipo Cliente para receber o cliente que será exibido na tabela
     */
    public DadosTabela(Locacao locacao, Veiculo veiculo, Cliente cliente) {
        this.locacao = locacao;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    /**
     * Método que retorna a locação
     * @return locacao
     */
    public Locacao getLocacao() {
        return locacao;
    }

    /**
     * Método que retorna o veículo
     * @return veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * Método que retorna o cliente
     * @return cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
}