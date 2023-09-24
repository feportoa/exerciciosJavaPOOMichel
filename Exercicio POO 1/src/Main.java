import exercicio1.Lampada;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    private static Lampada[] lampadas = new Lampada[6];
    private static byte lampadaIndex = 0;

    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Você tem 6 cômodos em casa, mas eles precisam de iluminação! \n Vamos configurar a iluminação de cada um dos seus cômodos.");
        while(isRunning) {
            System.out.print("1. Colocar nova lâmpada \n");
            System.out.print("2. Observar uma lâmpada \n");
            System.out.print("3. Informações detalhadas de uma lâmpada \n");
            System.out.print("4. Modificar uma lâmpada \n");
            System.out.print("Digite qualquer outro numero para sair \n");
            byte userChoice = read.nextByte();
            switch(userChoice) {
                case 1: // Colocar
                    if(isFullyPopulated(lampadas)){
                        System.out.println("Está CLARO que você tem mais lâmpadas do que consegue usar, por que não tenta fazer outra coisa?");
                    } else {
                        PlaceLightBulb(lampadas[lampadaIndex], read);
                        lampadaIndex++;
                        System.out.println("Lampada colocada!");
                    }
                    break;

                case 2: // Observar
                    Observe(lampadas, read);
                    break;

                case 3: // Status
                    Status(lampadas, read);
                    break;

                case 4: // Modificar
                    ModifyLightBulb(lampadas, read);
                    break;
                default:
                    isRunning = false;
                    break;
            }
        }
    }

    private static void PlaceLightBulb(Lampada lampada, Scanner read) {
        lampada = new Lampada();
        read = new Scanner(System.in);
        System.out.println("Vamos decidir algumas coisas sobre esta lâmpada.");
        System.out.println("1. Qual a cor da Lampada? (HEX | RGB) ");
        String cor = read.nextLine();
        if(cor != null){
            if(cor.contains(",")) {
                int[] rgb = new int[3];
                rgb[0] = Integer.parseInt(cor.split(",")[0].trim());
                rgb[1] = Integer.parseInt(cor.split(",")[1].trim());
                rgb[2] = Integer.parseInt(cor.split(",")[2].trim());
                lampada.setBulbColor((short) rgb[0], (short) rgb[1], (short) rgb[2]);
            } else {
                lampada.setBulbColor(cor);
            }
        }

        System.out.println("2. Qual a voltagem da tomada? (Comumente 110v ou 220v) ");
        short v = read.nextShort();
        lampada.setVolts(v);

        // Consome o \n deixado de sobra no Scanner anterior (Vulgo "limpa" o buffer);
        read.nextLine();
        System.out.println("3. Qual o cômodo que a lâmpada será colocada? ");
        String room = read.nextLine();
        lampada.setRoom(room);

        System.out.println("4. Deseja deixar a lampada ligada? (S/n) ");
        String isOn = read.nextLine();
        if(isOn.toUpperCase().equals("S")) { lampada.setOn(true); }
        else { lampada.setOn(false); }

        lampadas[lampadaIndex] = lampada;
    }

    private static void Observe(Lampada[] lampadaArr, Scanner read) {
        ShowAllLightBulbs(lampadaArr);

        byte userChoice = read.nextByte();
        userChoice--;

        try{
            lampadaArr[userChoice].Observe();
            read.nextLine();
        } catch (Exception e) { System.out.println("[ERRO] Opção inválida! (" + e + ")"); }
    }

    private static void Status(Lampada[] lampadaArr, Scanner read) {
        ShowAllLightBulbs(lampadaArr);

        byte userChoice = read.nextByte();
        userChoice--;

        try{
            lampadaArr[userChoice].Status();
            read.nextLine();
        } catch (Exception e) { System.out.println("[ERRO] Opção inválida! (" + e + ")"); }
    }

    private static void ModifyLightBulb(Lampada[] lampadaArr, Scanner read) {
        ShowAllLightBulbs(lampadaArr);

        byte userChoice = read.nextByte();
        userChoice--;

        try {
            Lampada lampada = lampadaArr[userChoice];
            System.out.println("1. Acender/Apagar");
            System.out.println("2. Trocar de comodo");
            System.out.println("3. Mudar cor");
            System.out.println("Aperte qualquer outro numero para cancelar.");
            userChoice = read.nextByte();

            read.nextLine(); // Limpar buffer do Scanner
            switch (userChoice) {
                case 1: // Acender/apagar
                    System.out.println("1. Acender");
                    System.out.println("Outro. Apagar");
                    byte isOn = read.nextByte();
                    lampada.setOn(isOn == 1);
                    break;
                case 2: // Trocar de comodo
                    System.out.print("Digite o novo comodo: ");
                    String comodo = read.nextLine();
                    lampada.setRoom(comodo);
                    break;
                case 3: // Mudar cor
                    System.out.print("Escolha a nova cor: ");
                    String novaCor = read.nextLine();
                    if(novaCor.contains(",") && novaCor != null) {
                        int[] rgb = new int[3];
                        rgb[0] = Integer.parseInt(novaCor.split(",")[0].trim());
                        rgb[1] = Integer.parseInt(novaCor.split(",")[1].trim());
                        rgb[2] = Integer.parseInt(novaCor.split(",")[2].trim());
                        lampada.setBulbColor((short) rgb[0], (short) rgb[1], (short) rgb[2]);
                    } else if(novaCor != null) {
                        lampada.setBulbColor(novaCor);
                    }
                    break;
                default:
                    System.out.println("Saindo...");
                    break;
            }
        } catch (Exception e) { System.out.println("[ERRO]: " + e); }
    }

    private static void ShowAllLightBulbs(Lampada[] lampadaArr) {
        for(byte i = 0; i <= lampadaIndex; i++) {
            if(lampadaArr[i] != null) { System.out.println(i+1 + ": " + lampadaArr[i].getRoom()); }
        }
    }

    private static boolean isFullyPopulated(Lampada[] arr) {
        for(Lampada l : arr) {
            if(l == null) { return false; }
        }
        return true;
    }
}