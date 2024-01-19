package com.aplication.appfoody.Domain;

public class Category {
    private int Id;
    private String ImagePath;
    private String Name;

    public Category() {
    }

    public int getId() {
        return Id;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setImagePath(String imagePath) {
        this.ImagePath = imagePath;
    }

    public void setId(int id) {
        this.Id = id;
    }

    @Override
    public String toString(){
        return "id: "+this.Id + " name: "+this.Name;
    }
}
