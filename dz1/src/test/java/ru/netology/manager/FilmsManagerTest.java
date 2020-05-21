package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Films;
import static org.junit.jupiter.api.Assertions.*;


public class FilmsManagerTest {

    private FilmsManager manager;
    Films film0  = new Films("0");
    Films film1  = new Films("1");
    Films film2  = new Films("2");
    Films film3  = new Films("3");
    Films film4  = new Films("4");
    Films film5  = new Films("5");
    Films film6  = new Films("6");
    Films film7  = new Films("7");
    Films film8  = new Films("8");
    Films film9  = new Films("9");
    Films film10  = new Films("10");

    @Test
    void shouldGetFirstFilm() {
        manager = new FilmsManager();
        manager.add(film0);

        Films[] expected = new Films[]{film0};

        assertArrayEquals(expected,manager.getAll());
    }

    @Test
    void shouldGetAllWithEnterCountOverDefault() {
        manager = new FilmsManager(11);
        manager.add(film0);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);

        Films[] expected = new Films[]{film10, film9,film8,film7,film6,film5,film4,film3,film2,film1,film0};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllWithEnterCountUnderDefault() {
        manager = new FilmsManager(5);

        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);

        Films[] expected = new Films[]{film10, film9,film8,film7,film6};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldGetAllWithEnterZeroCount() {
        manager = new FilmsManager(0);

        Films[] expected = new Films[]{};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        manager = new FilmsManager();
        manager.add(film0);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);


        Films[] expected = new Films[]{film9,film8,film7,film6,film5,film4,film3,film2,film1, film0};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }
}