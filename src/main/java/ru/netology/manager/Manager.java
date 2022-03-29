package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.Repository;

public class Manager {

    private int itemCount = 10;
    private Repository repository;

    public Manager() {
    }

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public Manager(int itemCount, Repository repository) {
        this.repository = repository;
        if (itemCount >= 0) {
            this.itemCount = itemCount;
        } else {
            this.itemCount = 0;
        }
    }

    public void add(Poster item) {
        repository.save(item);
    }

    public void removeId(int id) {
        repository.removeById(id);
    }

    public void removeAllItems() {
        repository.removeAll();
    }

    public Poster[] getAll() {
        Poster[] result = repository.findAll();
        return result;
    }

    public Poster[] findId(int id) {
        Poster[] result = repository.findById(id);
        return result;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Poster[] findLast() {
        int length;
        Poster[] items = repository.findAll();
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
