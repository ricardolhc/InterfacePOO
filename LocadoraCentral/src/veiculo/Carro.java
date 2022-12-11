/**
 * A classe Carro modela um carro do sistema.
 * @author Ricardo, Tales, Mateus, Mauricio
 * @since nov 2022
 * @version 1.0
 */

package veiculo;

public class Carro extends Veiculo {

    /**
     * O atributo numeroPassageiros, do tipo int, identifica o número de passageiros do carro.
     */
    private int numeroPassageiros;

    /**
     * O atributo numeroPortas, do tipo int, identifica o número de portas do carro.
     */
    private int numeroPortas;

    /**
     * O atributo mediaKm, do tipo double, identifica a média de quilômetros rodados por litro do carro.
     */
    private double mediaKm;

    /**
     * O atributo arcondicionado, do tipo boolean, identifica se o carro possui ar condicionado.
     */
    private boolean arcondicionado;


    /**
     * Construtor default da classe Carro<br>
     * <b>Uso: </b>
     * Carro carro = new Carro("ABC1234", 2010, 100.0, 5, 4, 10.0, true);<br><br>
     * @param placa String que identifica a placa do carro
     * @param ano int que identifica o ano do carro
     * @param diaria double que identifica a diária do carro
     * @param numeroPassageiros int que identifica o número de passageiros do carro
     * @param numeroPortas int que identifica o número de portas do carro
     * @param mediaKm double que identifica a média de quilômetros rodados por litro do carro
     * @param arcondicionado boolean que identifica se o carro possui ar condicionado
     */
    public Carro (String placa, int ano, double diaria, int numeroPassageiros, int numeroPortas, double mediaKm, boolean arcondicionado){
        super(placa, ano, diaria);
        this.numeroPassageiros = numeroPassageiros;
        this.numeroPortas = numeroPortas;
        this.mediaKm = mediaKm;
        this.arcondicionado = arcondicionado;
    }

    /**
     * Construtor alternativo da classe Carro<br>
     * <b>Uso: </b>
     * Carro carro = new Carro("ABC1234");<br><br>
     * @param placa
     */
    public Carro(String placa) {
        this(placa, 0, 0, 0, 0, 0, false);
    }
    
    
    /** 
     * @return int que identifica o numero de passageiros do carro
     */
    public int getNumeroPassageiros() { 
        return numeroPassageiros; 
    }

    
    /** 
     * @return int que identifica o numero de portas do carro
     */
    public int getNumeroPortas() { 
        return numeroPortas; 
    }

    
    /** 
     * @return double que identifica a média de KM do carro
     */
    public double getMediaKm() { 
        return mediaKm; 
    }

    
    /** 
     * @return boolean que identifica se o carro possui ar condicionado
     */
    public boolean getArcondicionado() { 
        return arcondicionado; 
    }

    
    /** 
     * @param numeroPassageiros int que identifica o numero de passageiros do carro
     */
    public void setNumeroPassageiros(int numeroPassageiros) { 
        this.numeroPassageiros = numeroPassageiros; 
    }

    
    /** 
     * @param numeroPortas int que identifica o numero de portas do carro
     */
    public void setNumeroPortas(int numeroPortas) { 
        this.numeroPortas = numeroPortas; 
    }

    
    /** 
     * @param mediaKm double que identifica a média de KM do carro
     */
    public void setmediaKm(double mediaKm) { 
        this.mediaKm = mediaKm; 
    }
    
    
    /** 
     * @param arcondicionado boolean que identifica se o carro possui ar condicionado
     */
    public void setArcondicionado(boolean arcondicionado) { 
        this.arcondicionado = arcondicionado; 
    }

    
    /** 
     * @return String que identifica as informações do carro
     */
    public String toString() {
        String arcondicionadoStr = null;
        if(arcondicionado) {
            arcondicionadoStr = "Sim";
        } else {
            arcondicionadoStr = "Não";
        }

        return super.toString() + "; Numero de Passageiros: " + numeroPassageiros + 
                                  "; Numero Portas: " + numeroPortas + 
                                  "; Media km: " + mediaKm + 
                                  "; Ar-Condicionado: " + arcondicionadoStr;
    }

}