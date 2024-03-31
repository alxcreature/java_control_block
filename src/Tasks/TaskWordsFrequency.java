/***
 * 3. Вычислить частоту слов:
 * Напишите программу, которая анализирует, сколько раз каждое
 * слово встречается в файле. Подумайте об этом как о подсчете того,
 * какие фрукты и овощи самые популярные на вашем пикнике!
 */

package Tasks;

import java.util.HashMap;
import java.util.Map;
/***
 * Класс подсчёта частоты вхождения/нахождния слова в словаре
 */
public class TaskWordsFrequency {
    /***
     * Статический метод вычисления частоты нахождения слова в словаре (массиве строк)
     * @param wordsArray массив слов (строк)
     * @return словарь, ключ - слово, значение - число (частота нахождения)
     */
    public static Map<String,Integer> WordsFrequency(String [] wordsArray){
        Map<String, Integer> wordsFrequency = new HashMap<>();
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsFrequency.get(wordsArray[i]) != null) 
                wordsFrequency.put(wordsArray[i], wordsFrequency.get(wordsArray[i])+1);
            else wordsFrequency.put(wordsArray[i], 1);
        }
        return wordsFrequency;
    }
}
