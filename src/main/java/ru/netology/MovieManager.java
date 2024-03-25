package ru.netology;

public class MovieManager {
    private MovieItem[] items = new MovieItem[0];
    public MovieManager(){

    }
    int limit;
    public MovieManager(int limit) {
        this.limit=limit;
    }

    public void save(MovieItem item) {
        MovieItem[] tmp = new MovieItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public MovieItem[] findAll() {
        return items;
    }


    public MovieItem[] findLast() {
        int resultLength;
        if (items.length < limit) {
            resultLength = items.length;
        } else {
            resultLength = limit;
        }
        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < result.length; i++) {

            result[i] = items[items.length - 1 - i];
        }
        return result;


    }

}


