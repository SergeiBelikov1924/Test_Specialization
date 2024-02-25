package Toy;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;

public class ToyShop {
    private PriorityQueue<Toy> toys;

    public ToyShop() {
         // Инициализация кдасса PriorityQueue для сортировки по весу
         this.toys = new PriorityQueue<>(Comparator.comparingInt(Toy::getWeight).reversed());
        }
    
        public void addToy(Toy toy) {
            toys.add(toy);
        }
        // Метод для извлечения игрушек из очереди
    public Toy getToy() {
        return toys.poll(); // Возвращает и удаляет элемент с наивысшим приоритетом
    }

    public static void main(String[] args) {
        ToyShop store = new ToyShop();

        // Добавляем игрушки в магазин
        // Формируем 3 массива
        Toy[] arr1 = new Toy[]{
                new Toy(1, "Игрушка № 1", 7),
                new Toy(2, "Игрушка № 2", 2),
                new Toy(3, "Игрушка № 3", 17),
                new Toy(4, "Игрушка № 4", 9)
        };
        Toy[] arr2 = new Toy[]{
                new Toy(5, "Игрушка № 5", 5),
                new Toy(6, "Игрушка № 6", 3),
                new Toy(7, "Игрушка № 7", 11),
                new Toy(8, "Игрушка № 8", 15)
        };
        Toy[] arr3 = new Toy[]{
                new Toy(9, "Игрушка № 9", 1),
                new Toy(10, "Игрушка № 10", 2)
        };
        for (int i = 0; i < arr1.length; i++) {
            store.addToy(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            store.addToy(arr2[i]);
        }
        for (int i = 0; i < arr3.length; i++) {
            store.addToy(arr3[i]);
        }
         // Запись результатов в файл
         try (FileWriter writer = new FileWriter("drawing_result.txt")) {
            for (int i = 0; i < 10; i++) {
                Toy toy = store.getToy();
                if (toy != null) {
                    writer.write(toy.toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}