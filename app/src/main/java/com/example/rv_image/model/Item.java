package com.example.rv_image.model;

public class Item {

    // ATRIBUTO
    private String itemDescripcion;
    private String urlImage;


    // CONSTRUCTOR
    public Item(String itemDescripcion, String urlImage){

        this.itemDescripcion = itemDescripcion;

        this.urlImage = urlImage;

    }


    public String getItemDescripcion() {
        return itemDescripcion;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
