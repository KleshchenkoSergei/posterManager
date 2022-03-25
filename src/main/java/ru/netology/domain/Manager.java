package ru.netology.domain;

public class Manager {

    private int itemCount = 10;

    public Manager() {
    }

    public Manager(int itemCount) {
        if (itemCount >= 0) {
            this.itemCount = itemCount;
        } else {
            this.itemCount = 0;
        }

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

    public Poster[] findLast() {
        int length;
        if (itemCount <= items.length) {
            length = itemCount;
        } else {
            length = items.length;
        }
        Poster[] tmp = new Poster[length];
        for (int i = 0; i < length; i++) {
            tmp[i] = items[items.length - i - 1];
        }
        items = tmp;
        return items;
    }
}
