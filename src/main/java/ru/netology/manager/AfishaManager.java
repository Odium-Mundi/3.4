package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import ru.netology.domain.Films;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor
@AllArgsConstructor
public class AfishaManager {
    private AfishaRepository repository;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int newLength) {
        this.repository = repository;
        this.countFilms = newLength;
    }

    private Films[] items = new Films[0];
    private int countFilms = 10;
    private int newLength;

    public void add(Films item) {
        repository.save(item);
    }

    public Films[] getAll() {
        Films[] items = repository.findAll();
        if (newLength <= 0 || newLength > countFilms) {
            newLength = countFilms;
        }
        if (items.length < newLength) {
            newLength = items.length;
        }
        Films[] result = new Films[newLength];

        for (int i = 0; i < items.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
