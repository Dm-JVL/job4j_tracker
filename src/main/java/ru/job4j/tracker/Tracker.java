package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        items[index] = item;
        item.setId(id);
        return (index != -1);
    }

    public boolean delete(int id) {
        int distPos = indexOf(id);
        int startPos = distPos + 1;
        int length = size - distPos;
        if (distPos!=-1){
            System.arraycopy(items, startPos, items, distPos, length);
            items[size - 1] = null;
            size--;
            return true;
        } else return false;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return (Arrays.copyOf(items, size));
    }


    public Item[] findByName(String key) {
        Item[] rsl = Arrays.copyOf(items, size);
        int k = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName() == key) {
                rsl[k] = item;
                k++;
            }
        }
        return rsl;
    }

}

