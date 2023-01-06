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
     * FALTA ESSE AQUI
     */
    private Locacao locacao;

    /**
     *  FALTA ESSE AQUI
     */
    private Veiculo veiculo;
 
    /**
     * FALTA ESSE AQUI
     */
    private Cliente cliente;

    /**
     * Construtor da classe DadosTabela que recebe como parâmetro a locação, o veículo e o cliente
     * @param locacao
     * @param veiculo
     * @param cliente
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