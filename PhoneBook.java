import java.util.*;

public class PhoneBook {
    private static Map<String, Set<String>> phoneBook = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            hr();
            System.out.println("Телефонная книга:\n");
            System.out.println("1. Просмотреть записи");
            System.out.println("2. Добавить запись");
            System.out.println("3. Удалить запись");
            System.out.println("4. Редактировать запись");
            System.out.println("5. Выйти");
            System.out.print("\nВыберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            clearConsole();

            switch (choice) {
                case 1:
                    displayItems();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    editItem();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("\nНекорректный выбор! Попробуйте снова.\n");
            }
        }
        System.out.println("\nРабота приложения завершена.\n");
    }

    private static void displayItems() {
        if (phoneBook.isEmpty()) {
            System.out.println("\nТелефонная книга пуста.\n");
        } else {
            List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
            sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
            hr();
            System.out.println("Записи в телефонной книге (отсортированы по убыванию числа телефонов):\n");
            for (Map.Entry<String, Set<String>> entry : sortedEntries) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        waitEnter();
    }