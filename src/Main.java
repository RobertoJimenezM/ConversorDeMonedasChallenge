import com.google.gson.JsonSyntaxException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = """
               *********************************************
                                BIENVENIDO
                Divisas disponibles:
                
                    ARS - Peso argentino
                    BOB - Boliviano boliviano
                    BRL - Real brasileño
                    CLP - Peso chileno
                    COP - Peso colombiano
                    USD - Dólar estadounidense
                    
               *********************************************
                """;

        Scanner lectura = new Scanner(System.in);

        ConversorDivisaApi conversorDivisaApi = new ConversorDivisaApi();


        while (true){
            System.out.println(menu);
            try{
                System.out.println("Elija la moneda a convertir (Ej. MXN)");
                String divisa = lectura.next().toUpperCase();
                System.out.println("Elija la moneda objetivo (Ej. ZAR");
                String cambio = lectura.next().toUpperCase();

                System.out.println("Elija la cantidad a transformar");
                double valor = lectura.nextDouble();
                var convertido = conversorDivisaApi.convertirDivisas(divisa, cambio,valor);
                System.out.println("El valor "+ valor + " " + divisa + " es igual a " + convertido + " " + cambio);


            }catch (InputMismatchException | JsonSyntaxException e){
                System.out.println("Datos Inválidos.");
            }
            System.out.println("Escriba NO para salir  ");
            String opc = lectura.next();
            if (opc .equalsIgnoreCase("no")){
                System.out.println("Gracias.");
                break;
            }
        }



    }
}
