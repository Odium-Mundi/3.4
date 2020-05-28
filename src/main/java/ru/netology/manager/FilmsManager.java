package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import ru.netology.domain.Films;

@NoArgsConstructor
@AllArgsConstructor
public class FilmsManager {


    private Films[] items = new Films[0];
    private int countFilms = 10;
    private int itemsLength;
    private int newLength;

    public FilmsManager(int newLength) {
        this.countFilms = newLength;
    }

    public void add(Films item) {
        int length = items.length + 1;
        Films[] tmp = new Films[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Films[] getAll() {
        if (itemsLength <= 0 || itemsLength > countFilms) {
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

}
