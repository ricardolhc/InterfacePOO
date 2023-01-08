/**
 * A classe ListaLocacoes é responsável por armazenar as locações de um cliente.
 * @author Mateus, Maurício, Ricardo, Tales
 * @since nov 2022
 * @version 1.0
 */

package lista;

import java.util.ArrayList;
import java.util.Calendar;

import exceptions.geral.EmptyList;
import exceptions.locacao.LocacaoNotFoundException;
import veiculo.Veiculo;

public class ListaLocacoes implements ILocacoes {

    /**
     * Arraylist do tipo Locacao para armazenar as locações
     */
    private ArrayList<Locacao> locacoes;


    /**
     * Construtor default da classe ListaLocacoes<br>
     */
    public ListaLocacoes() {
        locacoes = new ArrayList<Locacao>();
    }

    
    /** 
     * @param locacao do tipo Locacao que adiciona a locacao no arraylist
     */
    @Override
    public void add(Locacao locacao) {
        locacoes.add(locacao);
    }

    
    /** 
     * @param codigo do tipo int que é usado para procurar a locacao
     * @return Locacao que tem o codigo informado
     */
    @Override
    public Locacao get(int codigo) {
        for(Locacao locacao : locacoes) {
            if(locacao.getCodigo() == codigo) {
                return locacao;
            }
        }
        throw new LocacaoNotFoundException("Locação não encontrada");
    }

    
    /** 
     * @param codigo do tipo int que é usado para procurar a locacao
     * @return String com as informações da locacao
     */
    @Override
    public String getInfo(int codigo) {
        if(locacoes.size() > 0) {
            String conteudo = "";
            for(Locacao locacao : locacoes) {
                conteudo += locacao.toString() + "\n";
            }
            return conteudo;
        }
        throw new EmptyList("Não existem locações cadastradas");
    }

    
    /** 
     * @return String com as informações de todas as locacoes
     */
    @Override
    public String getInfo() {
        if(locacoes.size() > 0) {
            String conteudo = "";
            for(Locacao locacao : locacoes) {
                conteudo += locacao.toString() + "\n";
            }
            return conteudo;
        }
        throw new EmptyList("Não existem locações cadastradas");
    }

    
    /** 
     * @param cpf do tipo int que é usado para procurar a locacao
     * @return boolean se a remoção foi feita com sucesso
     */
    @Override
    public boolean remove(int codigo) {
        for(Locacao locacao : locacoes) {
            if(locacao.getCodigo() == codigo) {
                locacoes.remove(locacao);
                return true;
            }
        }
        return false;
    }

    
    /** 
     * @param codigo do tipo int que é usado para procurar a locacao
     * @return boolean se a locacao existe
     */
    @Override
    public boolean existe(int codigo) {
        for(Locacao locacao : locacoes) {
            if(locacao.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }


    // ASSIM POR ENQUANTO
    public String getLocacoesByCliente(Cliente cliente) {
        String conteudo = "";
        boolean flag = false;
        for(Locacao locacao : locacoes) {
            if(locacao.getCliente().equals(cliente)) {
                conteudo += locacao.toString() + "\n";
                flag = true;
            }
        }
        if(flag) {
            return conteudo;
        }
        throw new LocacaoNotFoundException("O cliente não possui locações");
    }

    // ASSIM POR ENQUANTO
    public String getLocacoesByVeiculo(Veiculo veiculo) {
        String conteudo = "";
        boolean flag = false;
        for(Locacao locacao : locacoes) {
            if(locacao.getVeiculo().equals(veiculo)) {
                conteudo += locacao.toString() + "\n";
                flag = true;
            }
        }
        if(flag) {
            return conteudo;
        }
        throw new LocacaoNotFoundException("O veiculo não possui locações");
        
    }

    public String getLocacoesByDiaMesAno(Calendar calendar) {
        String conteudo = "";
        boolean flag = false;

        for(Locacao locacao : locacoes) {
            if(locacao.getDataInicial().get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) 
            && locacao.getDataInicial().get(Calendar.MONTH) == calendar.get(Calendar.MONTH) 
            && locacao.getDataInicial().get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                conteudo += locacao.toString() + "\n";
                flag = true;
            }
        }
        if(flag) {
            return conteudo;
        }
        throw new LocacaoNotFoundException("Não foi possível encontrar uma locação");
    }  

    public String getLocacoesByPeriodo(Calendar dataInicial, Calendar dataFinal) {
        String conteudo = "";
        boolean flag = false;

        for(Locacao locacao : locacoes) {
            if(locacao.getDataInicial().after(dataInicial) && locacao.getDataFinal().before(dataFinal)) {
                conteudo += locacao.toString() + "\n";
                flag = true;
            }
        }
        if(flag) {
            return conteudo;
        }
        throw new LocacaoNotFoundException("Não foi possível encontrar uma locação");
    }

}