package co.kozao.kotask.views;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserLogin login = new UserLogin();
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n===== Bienvenue sur Ko-Task =====");
            System.out.println("1. Se connecter");
            System.out.println("2. Se déconnecter");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    login.userLogin();
                    break;

                case 2:
                    System.out.println("Déconnexion effectuée !");
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    continuer = false; 
                    break;

                default:
                    System.out.println("Option invalide.");
            }
        }

        scanner.close(); 
    }
}
