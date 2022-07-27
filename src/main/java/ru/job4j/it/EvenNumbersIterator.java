package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

    /**
    * Итератор четных чисел в массиве
    * @author Artamonov Dmitriy
    * @since 27.07.2022
    */
public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    /**
     * Конструктор
     * @param data массив чисел
     */
    public EvenNumbersIterator(int[] data) {
        this.data = data;
        index = -1;
        index = findEvenNumber();
    }

    /**
     * Ищет следующее четное число после указателя в массиве
     * Если число не найдено, возвращает -1
     * @return индекс четного числа в массиве, либо -1
     */
    public int findEvenNumber() {
        int result = -1;
        for (int i = this.index + 1; i < this.data.length; i++) {
            if (data[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * Проверяет наличие четных чисел после указателя
     * @return true, если далее есть четные числа
     *         false, если четных чисел нет
     */
    @Override
    public boolean hasNext() {
        return (this.index != -1);
    }

    /**
     * Возвращает текущий элемент массива и переводит указатель на следующее четное число
     * @return четное число data[index]
     * @throws NoSuchElementException если четного числа нет
     */
    @Override
    public Integer next() {
        if (this.index == -1) {
            throw new NoSuchElementException();
        }
        int result = data[index];
        index = findEvenNumber();
        return result;
    }
}