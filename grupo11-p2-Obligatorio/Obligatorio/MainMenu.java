package Obligatorio;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        System.out.println("Menu Principal");
        System.out.println("Seleccione una opcion");
        System.out.println("1- Listar los 10 pilotos activos en la temporada 2023 mas mencionados en los tweets en un mes");
        System.out.println("2- Top 15 usuarios con mas tweets");
        System.out.println("3- Cantidad de Hashtags distintos para un dia dado");
        System.out.println("4- Hashtag mas usado para un dia dado");
        System.out.println("5- Top 7 cuentas con mas favoritos");
        System.out.println("6- Cantidad de tweets con una palabra o frase especificos");
        System.out.println("7- Salir");
        switch (option){
            case 1:


            case 2:


            case 3:


            case 4:


            case 5:


            case 6:

            case 7:
                System.out.println("Saliendo del programa...");
                break;
        }


    }
}
