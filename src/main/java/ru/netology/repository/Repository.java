package ru.netology.repository;

import ru.netology.domain.Poster;

public class Repository {

    public Repository() {
    }

    private Poster[] items = new Poster[0];

    public void save(Poster item) {

        int length = items.length + 1;
        Poster[] tmp = new Poster[length];
//        for (int i = 0; i < items.length; i++) {
//            tmp[i] = items[i];
//        }
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Poster[] findAll() {
        return items;
    }

    //removeById
    public void removeById(int id) {
        Poster[] tmp = new Poster[1];
        for (Poster item : items) {
            if (item.getId() == id) {
                tmp[0] = item;
            }
        }
        items = tmp;
    }

    //findById
    public Poster[] findById(int id) {
        Poster[] tmp = new Poster[1];
        for (Poster item : items) {
            if (item.getId() == id) {
                tmp[0] = item;
            }
        }
        items = tmp;
        return items;
    }


    //removeAll
    public void removeAll() {
        Poster[] tmp = new Poster[0];
        items = tmp;
    }


}
