package Ej1_ArraysList.ej1;

import PruebaArraylist.ProductList;

import java.util.Scanner;

public class Main {
    //Lo que pide
    //Buscar por telefono
    //Ordenar por nombre
    //borrar todo
    private static Scanner scanner = new Scanner(System.in);;



    public static void imprimirMenu() {
        System.out.println("0 - Para imprimir menu");
        System.out.println("1 - Para imprimir productos");
        System.out.println("2 - Para añadir");
        System.out.println("3 - Para modificar");
        System.out.println("4 - Para eliminar");
        System.out.println("5 - Para salir");
        System.out.println("6 - Buscar por telefono");
        System.out.println("7 - Ordenar por nombre");
        System.out.println("8 - Borrar todo");
        System.out.println("9 - Numero de contactos");
        System.out.println("10 - Busqueda opr clave");
    }

    public static void addItem() {
        System.out.println("Inserta el producto: ");
        productList.addProduct(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.println("Inserta número de posición: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Escribe el nuevo producto:");
        String newItem = scanner.nextLine();
        productList.modifyProductItem(index, newItem);
    }

    public static void removeItem() {
        System.out.println("Inserta número de posición: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        productList.removeProductItem(index);
    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion = 0;
        imprimirMenu();

        while (continuar) {
            System.out.println("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    TelefonoMovil.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    queryContactByPhone();
                    break;
                case 7:
                    telefonoMovil.sortContacts();
                    System.out.println("Contactos ordenados correctamente.");
                    break;
                case 8:
                    telefonoMovil.removeAllContacts();
                    System.out.println("Todos los contactos han sido eliminados.");
                    break;
                case 9:
                    System.out.println("Número de contactos: " + telefonoMovil.getContactCount());
                    break;
                case 10:
                    System.out.println("Funcionalidad de búsqueda por clave aún no implementada.");
                    break;
                case 11:
                    printMenu();
                    break;
            }
        }
    }
}
