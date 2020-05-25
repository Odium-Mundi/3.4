package ru.netology.manager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import ru.netology.domain.Films;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
@AllArgsConstructor
public class AfishaManager {
    private AfishaRepository repository;
    public AfishaManager(AfishaRepository repository){
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int countFilms) {
        this.repository = repository;
        this.countFilms = countFilms;
    }

    private Films[] items = new Films[0];
    private int countFilms = 10;
    private int itemsLength;

    public void add(Films item) {
        repository.save(item);
    }

    public Films[] getAll() {
        Films[] items = repository.findAll();
        if (itemsLength <=0 || itemsLength > countFilms){
            itemsLength = countFilms;
        }
        if (items.length < itemsLength) {
            itemsLength = items.length;
        }
        Films[] result = new Films[itemsLength];

        for (int i = 0; i < items.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
    public void findById(int id) {
        repository.findById(id);
    }
}
