package exercicio1;

import java.awt.Color;
import exercicio1.Casa;

public class Lampada extends Casa {

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
    private int energyReceived_W;
    private Color bulbColor;
    private String room;
    private Casa socket;

    // Usando mais de um construtor para permitir parametros opcionais ou diferentes tipos de parametros
    public Lampada(int r, int g, int b)
    {
        this.bulbColor = new Color(r,g,b);
        this.isReceivingEnergy = false;
        this.socket = new Casa((short) 220);
        this.isOn = false;
        this.energyReceived_W = 0;
        this.socket = new Casa((short) 220);
    }

    public Lampada(String colorHex)
    {
        this.bulbColor = new Color(Integer.parseInt(colorHex, 16));
        this.isReceivingEnergy = false;
        this.socket = new Casa((short) 220);
        this.isOn = false;
        this.energyReceived_W = 0;
        this.socket = new Casa((short) 220);
    }

    public Lampada()
    {
        this.bulbColor = new Color(230, 230, 230);
        this.isReceivingEnergy = false;
        this.socket = new Casa((short) 220);
        this.isOn = false;
        this.energyReceived_W = 0;
        this.socket = new Casa((short) 220);
    }

    public void Observe() { // Mostra as informações "observáveis" sobre a lâmpada
        System.out.print("Está recebendo energia? " + (isOn ? "Sim" : "Não se sabe") + "\n");
        System.out.print("Ligada? " + (isOn ? "Sim" : "Não") + "\n");
        System.out.print("Cor: " + (isOn ? "[" + bulbColor.getRed() + ", " + bulbColor.getGreen() + ", " + bulbColor.getBlue() + "]" : "Desconhecida") + "\n");
    }

    public void Status() { // Mostra informações mais detalhadas sobre a lâmpada
        System.out.print("# Está recebendo energia? " + (isReceivingEnergy ? "Sim" : "Não") + "\n");
        System.out.print("# Ligada? " + (isOn ? "Sim" : "Não") + "\n");
        System.out.print("# Cor: " + "[" + bulbColor.getRed() + ", " + bulbColor.getGreen() + ", " + bulbColor.getBlue() + "]" + "\n");
        System.out.print("# Voltagem da lampada: " + socket.getVoltsSocket() + "\n");
        System.out.print("# Energia recebida (A): " + energyReceived_W + "\n");
    }

    private boolean isOn() { // private por que eu nao quero que o isOn seja chamado diretamente pela main, em vez disso, devera chamar o metodo Observe
        return this.isOn;
    }

    public void setOn(boolean state) {
        if(!this.isBurned() && this.isReceivingEnergy){
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

    public int getEnergyReceived() {
        return this.energyReceived_W;
    }

    public void setEnergyReceived(int received) {
        this.energyReceived_W = received;
        if(this.energyReceived_W > 0) { this.setReceivingEnergy(true); }
        if(energyReceived_W > socket.getVoltsSocket()*10) { this.setBurned(true); }
    }

    public short getVolts() {
        return this.socket.getVoltsSocket();
    }

    public void setVolts(short v) {
        this.socket.setVoltsSocket(v);
        setEnergyReceived(this.socket.getVoltsSocket()*10);
    }

    private Color getBulbColor() {
        return this.bulbColor;
    }

    public void setBulbColor(String colorHex) {
        this.bulbColor = new Color(Integer.parseInt(colorHex, 16));
    }

    public void setBulbColor(short r, short g, short b) {
        this.bulbColor = new Color(r,g,b);
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String r) {
        this.room = r;
    }

}
