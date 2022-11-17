import javax.swing.*;

public class Main {

    public static void main(String[] args) throws ValorMaiorQueOPermitidoException, ValorMenorQueOPermitidoException{

        int num = 10;

        checaValorTry();
    }

    private static void checaValorTry() throws ValorMenorQueOPermitidoException, ValorMaiorQueOPermitidoException {
        try {
            checaValor();
        } catch (ValorMenorQueOPermitidoException e){
            JOptionPane.showMessageDialog(null, "Valor menor que o permitido!");
        } catch (ValorMaiorQueOPermitidoException e){
            JOptionPane.showMessageDialog(null, "Valor maior que o permitido!");
        } finally {
            checaValorTry();
        }
    }

    private static void checaValor() throws ValorMenorQueOPermitidoException, ValorMaiorQueOPermitidoException {

        String valor = JOptionPane.showInputDialog("Informe um valor: ");

        if (valor.length()< 10){
            throw new ValorMenorQueOPermitidoException("Valor menor que 10");
        }

        if(valor.length() > 10){
            throw new ValorMaiorQueOPermitidoException("Valor maior que 10");
        }

        if(!valor.equals("10")){
            checaValor();
        }

            System.out.println("Valor correto!");
            System.exit(0);
    }
}
