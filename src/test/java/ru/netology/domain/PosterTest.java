package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;

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
    public void shouldAddNewNoFilm() {

        repo.save(item1);

        Poster[] expected = {item1};
        Poster[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewYesFilm() {

        repo.save(item1);

        repo.save(item2);

        Poster[] expected = {item1, item2};
        Poster[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);

        Poster[] expected = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        Poster[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastDefault() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);

        Poster[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsLowLimit() {

        Manager manager = new Manager(5, repo);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);

        Poster[] expected = {item11, item10, item9, item8, item7};
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsOverLimit() {

        Manager manager = new Manager(8, repo);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        Poster[] expected = {item6, item5, item4, item3, item2, item1};
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsZero() {

        Manager manager = new Manager(0, repo);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        Poster[] expected = {};
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsUnderZero() {

        Manager manager = new Manager(-1, repo);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        Poster[] expected = {};
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldGetSum() {
//
//        repo.save(item1);
//        repo.save(item2);
//        repo.save(item3);
//        repo.save(item4);
//        repo.save(item5);
//        repo.save(item6);
//
//        int expected = 21;
//
//        int actual = manager.sum();
//
//        assertEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveById() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(1);

        Poster[] expected = {item1};
        Poster[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Poster[] expected = {item2};
        Poster[] actual = repo.findById(2);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        repo.removeAll();

        Poster[] expected = {};
        Poster[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}