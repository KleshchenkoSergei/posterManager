package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterTest {

    @Test
    public void addNewNoFilm() {
        Poster item1 = new Poster(1,"Гонка со временем", "Триллер");

        Manager manager = new Manager();
        manager.save(item1);

        Poster[] expected = {item1};
        Poster[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addNewYesFilm() {
        Poster item1 = new Poster(1,"Гонка со временем", "Триллер");
        Manager manager = new Manager();
        manager.save(item1);

        Poster item2 = new Poster(2,"Красное уведомление", "Комедия");
        manager.save(item2);

        Poster[] expected = {item1, item2};
        Poster[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        Poster item1 = new Poster(1,"Гонка со временем", "Триллер");
        Poster item2 = new Poster(2,"Красное уведомление", "Комедия");
        Poster item3 = new Poster(3,"Гениальное ограбление", "Боевик");
        Poster item4 = new Poster(4,"Мой любимый враг", "Мелодрама");
        Poster item5 = new Poster(5,"Афёра века", "Драма");
        Poster item6 = new Poster(6,"Время", "Триллер");
        Poster item7 = new Poster(7,"Бесконечность", "Фантастика");
        Poster item8 = new Poster(8,"Последний богатырь", "Приключение");
        Poster item9 = new Poster(9,"Дом Gucci", "Биография");
        Poster item10 = new Poster(10,"Довод", "Боевик");
        Poster item11 = new Poster(11,"Это всё он", "Мелодрамма");

        Manager manager = new Manager();
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);
        manager.save(item7);
        manager.save(item8);
        manager.save(item9);
        manager.save(item10);
        manager.save(item11);

        Poster[] expected = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        Poster[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastDefault() {
        Poster item1 = new Poster(1,"Гонка со временем", "Триллер");
        Poster item2 = new Poster(2,"Красное уведомление", "Комедия");
        Poster item3 = new Poster(3,"Гениальное ограбление", "Боевик");
        Poster item4 = new Poster(4,"Мой любимый враг", "Мелодрама");
        Poster item5 = new Poster(5,"Афёра века", "Драма");
        Poster item6 = new Poster(6,"Время", "Триллер");
        Poster item7 = new Poster(7,"Бесконечность", "Фантастика");
        Poster item8 = new Poster(8,"Последний богатырь", "Приключение");
        Poster item9 = new Poster(9,"Дом Gucci", "Биография");
        Poster item10 = new Poster(10,"Довод", "Боевик");
        Poster item11 = new Poster(11,"Это всё он", "Мелодрамма");

        Manager manager = new Manager();
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);
        manager.save(item7);
        manager.save(item8);
        manager.save(item9);
        manager.save(item10);
        manager.save(item11);

        Poster[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsLowLimit() {
        Poster item1 = new Poster(1,"Гонка со временем", "Триллер");
        Poster item2 = new Poster(2,"Красное уведомление", "Комедия");
        Poster item3 = new Poster(3,"Гениальное ограбление", "Боевик");
        Poster item4 = new Poster(4,"Мой любимый враг", "Мелодрама");
        Poster item5 = new Poster(5,"Афёра века", "Драма");
        Poster item6 = new Poster(6,"Время", "Триллер");
        Poster item7 = new Poster(7,"Бесконечность", "Фантастика");
        Poster item8 = new Poster(8,"Последний богатырь", "Приключение");
        Poster item9 = new Poster(9,"Дом Gucci", "Биография");
        Poster item10 = new Poster(10,"Довод", "Боевик");
        Poster item11 = new Poster(11,"Это всё он", "Мелодрамма");

        Manager manager = new Manager(5);
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);
        manager.save(item7);
        manager.save(item8);
        manager.save(item9);
        manager.save(item10);
        manager.save(item11);

        Poster[] expected = {item11, item10, item9, item8, item7};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsOverLimit() {
        Poster item1 = new Poster(1,"Гонка со временем", "Триллер");
        Poster item2 = new Poster(2,"Красное уведомление", "Комедия");
        Poster item3 = new Poster(3,"Гениальное ограбление", "Боевик");
        Poster item4 = new Poster(4,"Мой любимый враг", "Мелодрама");
        Poster item5 = new Poster(5,"Афёра века", "Драма");
        Poster item6 = new Poster(6,"Время", "Триллер");

        Manager manager = new Manager(8);
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);

        Poster[] expected = {item6, item5, item4, item3, item2, item1};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsZero() {
        Poster item1 = new Poster(1,"Гонка со временем", "Триллер");
        Poster item2 = new Poster(2,"Красное уведомление", "Комедия");
        Poster item3 = new Poster(3,"Гениальное ограбление", "Боевик");
        Poster item4 = new Poster(4,"Мой любимый враг", "Мелодрама");
        Poster item5 = new Poster(5,"Афёра века", "Драма");
        Poster item6 = new Poster(6,"Время", "Триллер");

        Manager manager = new Manager(0);
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);

        Poster[] expected = {};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsUnderZero() {
        Poster item1 = new Poster(1,"Гонка со временем", "Триллер");
        Poster item2 = new Poster(2,"Красное уведомление", "Комедия");
        Poster item3 = new Poster(3,"Гениальное ограбление", "Боевик");
        Poster item4 = new Poster(4,"Мой любимый враг", "Мелодрама");
        Poster item5 = new Poster(5,"Афёра века", "Драма");
        Poster item6 = new Poster(6,"Время", "Триллер");

        Manager manager = new Manager(-1);
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);

        Poster[] expected = {};
        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

}