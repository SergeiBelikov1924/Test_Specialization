// Программа для подсчета количества слов в файле input.txt

package VirtualPicnic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            int count = 0;

            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }

            System.out.println("Количество слов в файле: " + count);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}
