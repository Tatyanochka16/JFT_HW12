package ru.netology;

public class MovieItem {
    private int id;
    private String name;
    private String style;
    private int count;

    public MovieItem(int id, String name, String style, int count) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}

