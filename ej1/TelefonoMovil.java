package Ej1_ArraysList.ej1;

import java.util.ArrayList;

public class TelefonoMovil {
    private String mynumber;
   private ArrayList<Contacto> mycontacts = new ArrayList<>();

    public TelefonoMovil(String mynumber, ArrayList<Contacto> mycontacts) {
        this.mynumber = mynumber;
        this.mycontacts = new ArrayList<>();
    }

    private int findContact(Contacto contacto)  {
        if (mycontacts.contains(contacto)) {
           return mycontacts.indexOf(contacto);
        } else {
            return -1;
        }
    }

    private int findContact(String contacto) {
        int index = mycontacts.indexOf(contacto);
        if (index >= 0) {
            return mycontacts.indexOf(index);
        } else {
            return -1;
        }
    }


    public boolean addNewContact (Contacto contacto) {
        if (findContact(contacto.getName()) >= 0 ) {
            return false;
        } else {
            mycontacts.add(contacto);
            return true;
        }
    }

    public boolean updateContact(Contacto oldContact, Contacto newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0 || findContact(newContact.getName()) >= 0) {
            return false;
        }
        mycontacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contacto contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false;
        }
        mycontacts.remove(foundPosition);
        return true;
    }
}
