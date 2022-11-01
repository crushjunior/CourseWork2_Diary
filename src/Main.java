import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws WrongDataException {
        TaskService diary = new TaskService();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, diary);
                            break;
                        case 2:
                            delTask(scanner, diary);
                            break;
                        case 3:
                            getTasksForDay(scanner, diary);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner, TaskService diary) throws WrongDataException {
        System.out.println("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.println("Введите описание задачи: ");
        String taskDescription = scanner.next();
        System.out.println("Выберите тип задачи: ");
        System.out.println(
                """
                        P - личная,
                        W - рабочая,
                        """);
        TypeTask typeTask = TypeTask.valueOf(scanner.next());
        System.out.println("Введите дату и время в формате год-месяц-день час:мин : ");
        LocalDateTime dateTime = LocalDateTime.parse(scanner.next());
        System.out.println("Укажите повторяемость задачи: ");
        System.out.println(
                """
                        1 - не повторяется,
                        2 - через день,
                        3 - через неделю,
                        4 - через месяц,
                        5 - через год.
                        """);
        int typeRepeat = scanner.nextInt();

        switch (typeRepeat) {
            case 1:
                diary.addTask(new OneTime(taskName, taskDescription, typeTask, dateTime)); break;
            case 2:
                diary.addTask(new EveryDay(taskName, taskDescription, typeTask, dateTime)); break;
            case 3:
                diary.addTask(new EveryWeek(taskName, taskDescription, typeTask, dateTime)); break;
            case 4:
                diary.addTask(new EveryMonth(taskName, taskDescription, typeTask, dateTime)); break;
            case 5:
                diary.addTask(new EveryYear(taskName, taskDescription, typeTask, dateTime)); break;
        }
    }

    private static void delTask(Scanner scanner, TaskService diary) {
        System.out.println("Укажите id задачи, которую хотите удалить");
        int idTask = scanner.nextInt();
        diary.deleteTask(idTask);
    }

    private static void getTasksForDay(Scanner scanner, TaskService diary) {
        System.out.println("Укажите день, на который вы хотите получить список задачь в формате: год-месяц-день час:мин : ");
        LocalDateTime date = LocalDateTime.parse(scanner.next());
        diary.printTasksForDay(date);
    }

    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );
    }
}
