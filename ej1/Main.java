package Ej1_ArraysList.ej1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// .trim() se usa para no dejar al usuario introducir valores en blanco.
// .sort ordena los valores.

public class Main {
    // 📌 Se crea un Scanner para leer la entrada del usuario desde el teclado.
    private static Scanner scanner = new Scanner(System.in);

    // 📌 Se usa un ArrayList para almacenar la lista de contactos en memoria.
    // Un ArrayList es una lista dinámica que permite agregar, eliminar y modificar elementos fácilmente.
    private static ArrayList<Contacto> contactos = new ArrayList<>();

    // 📌 Método para agregar un nuevo contacto
    public static void addNewContact() {
        // Se obtiene un nombre válido del usuario (solo letras permitidas).
        String name = getValidName();

        // Se obtiene un número de teléfono válido (solo números permitidos).
        String phoneNumber = getValidPhoneNumber();

        // Se verifica si el contacto ya existe en la lista de contactos.
        if (findContact(name) == -1) { // Si el contacto no existe...
            // Se agrega un nuevo contacto al ArrayList.
            contactos.add(new Contacto(name, phoneNumber));
            System.out.println("✅ Contacto agregado con éxito.");
        } else {
            // Si el contacto ya existe, se muestra un mensaje de error.
            System.out.println("⚠️ Error: El contacto ya existe.");
        }
    }

    // 📌 Método para actualizar un contacto existente.
    public static void updateContact() {
        System.out.print("Ingrese el nombre del contacto a actualizar: ");
        String oldName = scanner.nextLine().trim(); // Se lee y limpia el nombre.

        // Se busca el índice del contacto en la lista.
        int index = findContact(oldName);

        if (index != -1) { // Si el contacto existe...
            System.out.println("Ingrese los nuevos datos:");
            String newName = getValidName(); // Se solicita un nuevo nombre válido.
            String newPhoneNumber = getValidPhoneNumber(); // Se solicita un nuevo número válido.
            // Se actualiza el contacto en la lista con los nuevos datos.
            contactos.set(index, new Contacto(newName, newPhoneNumber));
            System.out.println("✅ Contacto actualizado correctamente.");
        } else {
            System.out.println("⚠️ Error: Contacto no encontrado.");
        }
    }

    // 📌 Método para eliminar un contacto
    public static void removeContact() {
        System.out.print("Ingrese el nombre del contacto a eliminar: ");
        String name = scanner.nextLine().trim();
        int index = findContact(name);

        if (index != -1) { // Si el contacto existe...
            contactos.remove(index); // Se elimina el contacto de la lista.
            System.out.println("✅ Contacto eliminado correctamente.");
        } else {
            System.out.println("⚠️ Error: No se encontró el contacto.");
        }
    }

    // 📌 Método para imprimir todos los contactos almacenados en el ArrayList.
    public static void printContacts() {
        if (contactos.isEmpty()) { // Si la lista está vacía...
            System.out.println("⚠️ No hay contactos en la lista.");
        } else {
            System.out.println("\n📋 Lista de contactos:");
            for (int i = 0; i < contactos.size(); i++) {
                Contacto contact = contactos.get(i); // Se obtiene cada contacto.
                System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
            }
        }
    }

    // 📌 Método para buscar un contacto por nombre y devolver su índice en la lista.
    public static int findContact(String name) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getName().equalsIgnoreCase(name)) { // Se compara ignorando mayúsculas/minúsculas.
                return i; // Se devuelve la posición donde se encontró.
            }
        }
        return -1; // Si no se encuentra, se devuelve -1.
    }

    // 📌 Método para ordenar los contactos por nombre alfabéticamente.
    public static void sortContacts() {
        contactos.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName())); // Se usa el método sort() con un comparador.
        System.out.println("✅ Contactos ordenados correctamente.");
    }

    // 📌 Método para eliminar todos los contactos de la lista.
    public static void removeAllContacts() {
        contactos.clear(); // Se vacía el ArrayList.
        System.out.println("✅ Todos los contactos han sido eliminados.");
    }

    public static void main(String[] args) {
        boolean quit = false; // Variable para controlar la ejecución del programa.
        printMenu(); // Se imprime el menú al iniciar el programa.

        while (!quit) { // Mientras el usuario no elija salir...
            try {
                System.out.print("Elige una opción: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea.

                switch (choice) {
                    case 0:
                        quit = true; // Salir del programa.
                        break;
                    case 1:
                        printContacts();
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
                        System.out.print("Ingrese el nombre del contacto a buscar: ");
                        String name = scanner.nextLine().trim();
                        int index = findContact(name);
                        if (index != -1) {
                            Contacto contact = contactos.get(index);
                            System.out.println("✅ Contacto encontrado: " + contact.getName() + " -> " + contact.getPhoneNumber());
                        } else {
                            System.out.println("⚠️ Error: Contacto no encontrado.");
                        }
                        break;
                    case 6:
                        System.out.print("Ingrese el número de teléfono a buscar: ");
                        String phoneNumber = scanner.nextLine().trim();
                        boolean found = false;
                        for (Contacto contact : contactos) {
                            if (contact.getPhoneNumber().equals(phoneNumber)) {
                                System.out.println("✅ Contacto encontrado: " + contact.getName() + " -> " + contact.getPhoneNumber());
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("⚠️ Error: No se encontró un contacto con ese número.");
                        }
                        break;
                    case 7:
                        sortContacts();
                        break;
                    case 8:
                        removeAllContacts();
                        break;
                    case 9:
                        System.out.println("📌 Número de contactos: " + contactos.size());
                        break;
                    case 10:
                        printMenu();
                        break;
                    default:
                        System.out.println("⚠️ Error: Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error: Debes ingresar un número válido.");
                scanner.nextLine(); // Limpiar el buffer de entrada.
            }
        }
    }

    // 📌 Método para mostrar el menú en pantalla.
    private static void printMenu() {
        System.out.println("\n📌 Menú de opciones:");
        System.out.println("0 - Salir");
        System.out.println("1 - Imprimir contactos");
        System.out.println("2 - Agregar un nuevo contacto");
        System.out.println("3 - Actualizar un contacto existente");
        System.out.println("4 - Eliminar un contacto");
        System.out.println("5 - Buscar un contacto por nombre");
        System.out.println("6 - Buscar por teléfono");
        System.out.println("7 - Ordenar por nombre");
        System.out.println("8 - Borrar todo");
        System.out.println("9 - Número de contactos");
        System.out.println("10 - Volver a imprimir el menú");
    }

    // 📌 Método para validar que el nombre solo contenga letras y espacios.
    private static String getValidName() {
        System.out.print("Ingrese el nombre (solo letras): ");
        String name = scanner.nextLine().trim();
        while (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.println("⚠️ Error: Solo se permiten letras en el nombre.");
            System.out.print("Ingrese nuevamente el nombre: ");
            name = scanner.nextLine().trim();
        }
        return name;
    }

    // 📌 Método para validar que el número de teléfono solo contenga números.
    private static String getValidPhoneNumber() {
        String phoneNumber = scanner.nextLine().trim();
        while (!phoneNumber.matches("\\d+") || phoneNumber.length() < 8) {
            System.out.println("⚠️ Error: Solo se permiten números en el teléfono y tiene que tener 8 digitos obligatoriamente.");
            System.out.print("Ingrese nuevamente el número de teléfono: ");
            phoneNumber = scanner.nextLine().trim();
        }
        return phoneNumber;
    }
}
