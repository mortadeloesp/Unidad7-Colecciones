package Ej1_ArraysList.ej1;

import java.util.ArrayList;

public class Contacto {
    protected String name;
    protected String phoneNumber;
    ArrayList<Contacto> contactos = new ArrayList<>();

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacto createContact (String name, String phoneNumber) {
        Contacto contacto = new Contacto(name, phoneNumber);
        return contacto;
    }
}
