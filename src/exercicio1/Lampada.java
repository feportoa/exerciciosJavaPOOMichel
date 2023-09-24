package exercicio1;

import java.awt.*;

public class Lampada {

    // Verificar se a lampada tem energia para poder ligar
    // ligar a lampada se tiver energia
    // checar estado da lampada
    // checar energia passando por ela
    // se a energia for mt alta e tentar ligar, lampada explode
    // se a energia for mt baixa, so nao liga

    // pq eu complico tudo?

    private boolean isOn;
    private boolean isReceivingEnergy;
    private boolean isBurned;
    private short energyReceived_W;
    private short volts;

    private Color bulbColor;

    // Usando mais de um construtor para permitir parametros opcionais ou diferentes tipos de parametros

    public Lampada(int r, int g, int b)
    {
        bulbColor = new Color(r,g,b);
        isReceivingEnergy = false;
        volts = 220;
        isOn = false;
        energyReceived_W = 0;
    }

    public Lampada(String colorHex)
    {
        bulbColor = new Color(Integer.parseInt(colorHex, 16));
        isReceivingEnergy = false;
        volts = 220;
        isOn = false;
        energyReceived_W = 0;
    }

    public Lampada()
    {
        bulbColor = new Color(230, 230, 230);
        isReceivingEnergy = false;
        volts = 220;
        isOn = false;
        energyReceived_W = 0;
    }

    public void Observe() { // Mostra as informações "observáveis" sobre a lâmpada
        System.out.print("Está recebendo energia? " + (isOn ? "Sim" : "Não se sabe") + "\n");
        System.out.print("Ligada? " + (isOn ? "Sim" : "Não") + "\n");
        System.out.print("Cor: " + (isOn ? bulbColor : "Desconhecida") + "\n");
    }

    public void Status() { // Mostra informações mais detalhadas sobre a lâmpada
        System.out.print("# Está recebendo energia? " + (isReceivingEnergy ? "Sim" : "Não") + "\n");
        System.out.print("# Ligada? " + (isOn ? "Sim" : "Não") + "\n");
        System.out.print("# Cor: " + "[" + bulbColor.getRed() + ", " + bulbColor.getGreen() + ", " + bulbColor.getBlue() + "]" + "\n");
        System.out.print("# Voltagem da lampada: " + volts + "\n");
        System.out.print("# Energia recebida (A): " + energyReceived_W + "\n");
    }

    private boolean isOn() { // private por que eu nao quero que o isOn seja chamado diretamente pela main, em vez disso, devera chamar o metodo Observe
        return this.isOn;
    }

    public void setOn(boolean state) {
        if(!this.isBurned()){
            this.isOn = state;
        }
    }

    private boolean isReceivingEnergy() {
        return this.isReceivingEnergy;
    }

    public void setReceivingEnergy(boolean isReceiving) {
        this.isReceivingEnergy = isReceiving;
    }

    private boolean isBurned() {
        return this.isBurned;
    }

    private void setBurned(boolean burned) {
        this.isBurned = burned;
    }

    public short getEnergyReceived() {
        return this.energyReceived_W;
    }

    public void setEnergyReceived(short received) {
        this.energyReceived_W = received;
        if(this.energyReceived_W > 0) { this.isReceivingEnergy = true; }
        if(energyReceived_W > volts*10) { this.setBurned(true); }
    }

    public short getVolts() {
        return this.volts;
    }

    public void setVolts(short v) {
        this.volts = v;
    }

    private Color getBulbColor() {
        return this.bulbColor;
    }

}
