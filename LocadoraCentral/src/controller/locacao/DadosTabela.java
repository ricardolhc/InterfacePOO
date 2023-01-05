package controller.locacao;

import lista.Cliente;
import lista.Locacao;
import veiculo.Veiculo;

class DadosTabela {
    
    private Locacao locacao;
    private Veiculo veiculo;
    private Cliente cliente;

    public DadosTabela(Locacao locacao, Veiculo veiculo, Cliente cliente) {
        this.locacao = locacao;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}