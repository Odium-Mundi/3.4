package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Films;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    private AfishaRepository repository = new AfishaRepository();
    private AfishaManager manager = new AfishaManager(repository);

    private Films film1 = new Films("nameFilm", 1);
    private Films film2 = new Films("nameFilm2", 2);

    @BeforeEach
    @Test
    public void addFilms() {
        manager.add(film1);
        manager.add(film2);
    }

    @Test
    public void shouldRemoveIfExists() {
        repository.removeById(1);

        Films[] expected = new Films[]{film2};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {

        repository.removeById(99);

        Films[] expected = new Films[]{film2, film1};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExists() {

        assertEquals(repository.findById(1), film1);
    }

    @Test
    public void shouldFindByIdIfNoExists() {

        assertNull(repository.findById(99));
    }

    @Test
    public void  shouldRemoveAll() {
        repository.removeAll();

        Films[] expected = new Films[0];
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

    }
}