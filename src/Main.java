import exercicio1.Lampada;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
        Lampada[] lampadas = new Lampada[6];
        byte index = 0;

        System.out.println("Você tem 6 cômodos em casa, mas eles precisam de iluminação! \n Vamos configurar a iluminação de cada um dos seus cômodos.");
        while(true) {
            System.out.print("1. Colocar nova lâmpada \n");
            System.out.print("2. Observar uma lâmpada \n");
            System.out.print("3. Informações detalhadas de uma lâmpada \n");
            System.out.print("4. Modificar uma lâmpada \n");
            System.out.print("5. Remover uma das lâmpadas \n");
            byte userChoice = read.nextByte();
            switch(userChoice) {
                case 1:
                    if(isFullyPopulated(lampadas)){
                        System.out.println("Está CLARO que você tem mais lâmpadas do que consegue usar, por que não tenta fazer outra coisa?");
                    } else {

                    }
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                    break;
            }
        }
    }

    private static boolean isFullyPopulated(Lampada[] arr) {
        for(Lampada l : arr) {
            if(l == null) { return false; }
        }
        return true;
    }

    private static void placeLightBulb()
    {

    }
}