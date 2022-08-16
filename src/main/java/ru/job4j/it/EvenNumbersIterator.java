package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

    /**
    * Итератор четных чисел в массиве
    * @author Artamonov Dmitriy
    * @since 27.07.2022
    */
public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int index = 0;


    /**
     * Конструктор
     * @param data массив чисел
     */
    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    /**
     * Проверяет наличие четных чисел после указателя
     * @return true, если далее есть четные числа
     *         false, если четных чисел нет
     */
    @Override
    public boolean hasNext() {
        while (data.length > index) {
            if (data[index] % 2 == 0) {
                break;
            }
            index++;
        }
        return data.length > index;
    }

    /**
     * Возвращает текущий элемент массива и переводит указатель на следующее четное число
     * @return четное число data[index]
     * @throws NoSuchElementException если четного числа нет
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}