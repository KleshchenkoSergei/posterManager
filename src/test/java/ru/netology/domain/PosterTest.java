package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterTest {
    Poster item1 = new Poster(1, "Гонка со временем", "Триллер");
    Poster item2 = new Poster(2, "Красное уведомление", "Комедия");
    Poster item3 = new Poster(3, "Гениальное ограбление", "Боевик");
    Poster item4 = new Poster(4, "Мой любимый враг", "Мелодрама");
    Poster item5 = new Poster(5, "Афёра века", "Драма");
    Poster item6 = new Poster(6, "Время", "Триллер");
    Poster item7 = new Poster(7, "Бесконечность", "Фантастика");
    Poster item8 = new Poster(8, "Последний богатырь", "Приключение");
    Poster item9 = new Poster(9, "Дом Gucci", "Биография");
    Poster item10 = new Poster(10, "Довод", "Боевик");
    Poster item11 = new Poster(11, "Это всё он", "Мелодрамма");

    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    @Test
    public void addNewNoFilm() {

        manager.add(item1);

        Poster[] expected = {item1};
        Poster[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addNewYesFilm() {

        manager.add(item1);

        manager.add(item2);

        Poster[] expected = {item1, item2};
        Poster[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);

        Poster[] expected = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        Poster[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastDefault() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);

        Poster[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsLowLimit() {

        Manager manager = new Manager(5, repo);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);

        Poster[] expected = {item11, item10, item9, item8, item7};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsOverLimit() {

        Manager manager = new Manager(8, repo);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Poster[] expected = {item6, item5, item4, item3, item2, item1};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsZero() {

        Manager manager = new Manager(0, repo);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Poster[] expected = {};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsUnderZero() {

        Manager manager = new Manager(-1, repo);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Poster[] expected = {};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void getSum() {
//
//        manager.add(item1);
//        manager.add(item2);
//        manager.add(item3);
//        manager.add(item4);
//        manager.add(item5);
//        manager.add(item6);
//
//        int expected = 21;
//
//        int actual = manager.sum();
//
//        assertEquals(expected, actual);
//    }

    @Test
    public void removeById() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.removeId(2);

        Poster[] expected = {item1, item3};
        Poster[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Poster[] expected = {item3};
        Poster[] actual = manager.findId(3);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAll() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        manager.removeAllItems();

        Poster[] expected = {};
        Poster[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }
}