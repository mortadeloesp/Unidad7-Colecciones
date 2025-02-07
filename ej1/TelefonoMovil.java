package Ej1_ArraysList.ej1;

import java.util.ArrayList;
import java.util.Comparator;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacto contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contacto oldContact, Contacto newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0 || findContact(newContact.getName()) >= 0) {
            return false;
        }
        myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contacto contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false;
        }
        myContacts.remove(foundPosition);
        return true;
    }

    public void removeAllContacts() {
        myContacts.clear();
    }

    private int findContact(Contacto contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contacto queryContact(String name) {
        int position = findContact(name);
        return (position >= 0) ? myContacts.get(position) : null;
    }

    public Contacto queryContactByPhone(String phoneNumber) {
        for (Contacto contact : myContacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Lista de contactos:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contacto contact = myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

    public void sortContacts() {
        myContacts.sort(Comparator.comparing(Contacto::getName));
    }

    public int getContactCount() {
        return myContacts.size();
    }
}
