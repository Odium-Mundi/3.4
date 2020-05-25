package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Films;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerMockTest {

    @Mock
    private AfishaRepository repository = new AfishaRepository();
    @InjectMocks
    private AfishaManager manager = new AfishaManager(repository);
   private Films film1  = new Films("1", 1);
   private Films film2  = new Films("2", 2);
   private Films film3  = new Films("3",3);
   private Films film4  = new Films("4",4);
   private Films film5  = new Films("5", 5);
   private Films film6  = new Films("6", 6);
   private Films film7  = new Films("7", 7);
   private Films film8  = new Films("8", 8);
   private Films film9  = new Films("9",9);
   private Films film10  = new Films("10",10);
   private Films film11  = new Films("11",11);

    @Test
    public void shouldGetLastFilms() {
        Films[] returned = new Films[]{film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        doReturn(returned).when(repository).findAll();

        Films[] actual = manager.getAll();
        Films[] expected = new Films[]{film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }


    @Test
    public void shouldRemoveIfExists(){
        int idToRemove = 1;
        Films[] returned = new Films[]{film2,film3,film4,film5,film6,film7,film8,film9,film10};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Films[] expected = new Films[]{film10,film9,film8,film7,film6,film5,film4,film3,film2};
        Films[] actual= manager.getAll();
        assertArrayEquals(expected,actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 25;
        Films[] returned = new Films[]{film2,film3,film4,film5,film6,film7,film8,film9,film10,film11};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Films[] expected = new Films[]{film11,film10,film9,film8,film7,film6,film5,film4,film3,film2};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }


    @Test
    void shouldGetAllWithEnterCountOverDefault() {
        Films[] returned = new Films[]{film1,film2, film3, film4, film5, film6, film7, film8, film9, film10, film11};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository, 11);

        Films[] expected = new Films[]{film11,film10, film9,film8,film7,film6,film5,film4,film3,film2,film1};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllWithEnterCountUnderDefault() {
        Films[] returned = new Films[]{film7, film8, film9, film10, film11};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository, 5);

        Films[] expected = new Films[]{film11,film10, film9,film8,film7};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllWithEnterZeroCount() {
        Films[] returned = new Films[]{};
        doReturn(returned).when(repository).findAll();

        AfishaManager manager = new AfishaManager(repository, 0);

        Films[] expected = new Films[]{};
        Films[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

}