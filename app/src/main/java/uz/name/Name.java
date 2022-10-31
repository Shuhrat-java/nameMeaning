package uz.name;

import androidx.annotation.NonNull;

public class Name {
    private String name;
    private String nameDesc;
    private String nat;


    public String getNat() {
        return nat;
    }

    public String getNameDesc() {
        return nameDesc;
    }

    public String getName() {
        return name;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public void setNameDesc(String nameDesc) {
        this.nameDesc = nameDesc;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Nomi: "+name + "\nTavsifi: "+nameDesc+"\nKelib chiqishi: "+nat+"\n";

    }
}
