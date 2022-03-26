package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MockitoTest {

    @Mock
    private Repository repository = Mockito.mock(Repository.class);
    @InjectMocks
    private Manager manager;
    //Manager manager1 = new Manager(repository);

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


    @Test
    public void shouldMockitoGtSum() {

        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);


        Poster[] returned = {item1, item2, item3, item4, item5, item6};
        doReturn(returned).when(repository).findAll();

        int expected = 21;

        int actual = manager.sum();

        assertEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldMockitoGetLast() {

        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);


        Poster[] returned = {item1, item2, item3, item4, item5, item6};
        doReturn(returned).when(repository).findAll();

        Poster[] expected = {item6, item5, item4, item3, item2, item1};

        Poster[] actual;
        actual = manager.findLast();

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}