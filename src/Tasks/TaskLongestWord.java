/***
 * 2. Найти самое длинное слово:
 * Создайте программу, которая находит самое длинное слово в
 * файле.
 */
package Tasks;

import java.util.HashSet;
import java.util.Set;

/***
 * Класс со статическим методом вычисления самого длинного слова или слов
 */
public class TaskLongestWord {
    /***
     * Статический метод нахождения самого длинного слова из массива строк (словаря)
     * @param wordsArray массив слов
     * @return самое длинное слово или слова (множество)
     */
    public static Set<String> LongestWord(String [] wordsArray){
        // размер самого длинное слово
        int max = 0;
        // массив длины по каждому слову по индексу
        int[] sizeWords = new int[wordsArray.length];
        
        for (int i = 0; i < wordsArray.length; i++) {
            sizeWords[i] = wordsArray[i].length();
            if (sizeWords[i] > max) max = sizeWords[i];
        }
        // Список длинных слов, если их несколько по равной максимальной длине
        Set<String> longestWord = new HashSet<>();
        for(int i = 0; i < sizeWords.length; i++){
            if (sizeWords[i] == max) {
                longestWord.add(wordsArray[i]);
            }
        }
        return longestWord;
    }
}
