package ru.netology.repository;

import ru.netology.domain.Films;

public class FilmsRepository {
    private Films[] items = new Films[0];

    public void save(Films item) {
        int length = items.length + 1;
        Films[] tmp = new Films[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Films[] findAll() {
        return items;
    }


}
