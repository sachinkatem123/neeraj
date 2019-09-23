package com.example.gatha;

public class ClassListItems {

    public int id;
    public String IndexText;
    public String OviText;

    public ClassListItems(int id, String indexText, String oviText) {
        this.id = id;
        this.IndexText = indexText;
        this.OviText = oviText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndexText() {
        return IndexText;
    }

    public void setIndexText(String indexText) {
        IndexText = indexText;
    }

    public String getOviText() {
        return OviText;
    }

    public void setOviText(String oviText) {
        OviText = oviText;
    }
}
