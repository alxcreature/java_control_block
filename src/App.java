import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Tasks.TaskLongestWord;
import Tasks.TaskWordsCount;
import Tasks.TaskWordsFrequency;

public class App {
    public static void main(String[] args) throws Exception {
        // Имя тектового файла и преобразование с относительного в абсолютный путь к файлу
        Path filePathName = Paths.get("input.txt");
        if (Files.notExists(filePathName)){
            throw new RuntimeException("ИСКЛЮЧЕНИЕ: Файл не существует!"+filePathName.toString()+" Продолжение не возможно!");
        }
        String textBuffer = "";
        try {
            // Считываем содержимое файла в один стройковый буфер 
            textBuffer = Files.readString(filePathName, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("ИСКЛЮЧЕНИЕ: Файл не может быть прочитан!");
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            System.out.println("ИСКЛЮЧЕНИЕ: Недостаточно выделяемой памяти для чтения файла!");
            e.printStackTrace();
        } catch (SecurityException e){
            System.out.println("ИСКЛЮЧЕНИЕ: Отказано в доступе на чтение файла!");
            e.printStackTrace();
        }
        
        // Чистим строковый буфер от лишних пробелов и переходов на новую строку с кареткой
        textBuffer = clean(textBuffer);

        // Печатаем в консоль тиерминала результат
        System.out.println("Количество слов: " + TaskWordsCount.WordsCount(textBuffer));
        // Экономим на ресурсах, передаём готовый чистый словарь в качестве аргумнта из
        // TaskWordsCount.wordsArray
        System.out.println("Самое длинное слово: " + TaskLongestWord.LongestWord(TaskWordsCount.wordsArray));
        System.out.println("Частота повторения слов: " + TaskWordsFrequency.WordsFrequency(TaskWordsCount.wordsArray));
    }
    /***
     * Чиста текстового буфера от переходов строк и лишних пробелов
     * @param textBuffer текстовый буфер
     */
    static String clean(String textBuffer){
        String cleanBuffer = new String(textBuffer);
        // Заменяем переход новой строки и аретки на пробел в качество разделителя между слов
        while (cleanBuffer.contains("\r\n")){
            cleanBuffer = cleanBuffer.replace("\r\n", " ");
        }
        // Заменяем избыточные пробелы на один, так как пробел у нас разделитель между словами
        while (cleanBuffer.contains("  ")){
            cleanBuffer = cleanBuffer.replace("  ", " ");
        }
        return cleanBuffer;
    }
}
