package com.example.myapplication;

public class ListItem {

    private String Name;
    private  String Title;
    private String Description;
    private  String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
    public ListItem(String name,String title,String description,String image)
    {
        this.Name=name;
        this.Title=title;
        this.Description=description;
        this.image=image;
    }
    public ListItem()
    {

    }
}
