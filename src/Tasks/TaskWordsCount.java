/***
 * 1. Осуществить подсчет слов:
 * Напишите программу, которая подсчитывает количество слов в
 * файле `input.txt`.
 */

package Tasks;

import java.util.Arrays;
/***
 * Класс со статическим методом подсчёта количества слов из тектового буфера
 */
public class TaskWordsCount {
    // Статический класс требует статические переменные, создаём строковый массив для словаря
    public static String [] wordsArray;
    /***
     * Статический метод подсчёта количества слов в строковом буфере
     * @param bufferString строковый буфер
     * @return целое - количество слов
     */
    public static int WordsCount (String bufferString){
        wordsArray = bufferString.split(" ");
        System.out.println("Слова: " + Arrays.asList(wordsArray));
        return wordsArray.length;
    }
}