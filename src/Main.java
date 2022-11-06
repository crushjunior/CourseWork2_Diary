import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args)  {
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
                        case 4:
                            printTasks(diary);
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

    private static void inputTask(Scanner scanner, TaskService diary) {
        System.out.println("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.println("Введите описание задачи: ");
        String taskDescription = scanner.next();
        System.out.println("Выберите тип задачи: ");
        System.out.println(

                        "P - личная" + '\n' +
                        "W - рабочая"
                        );
        TypeTask typeTask = TypeTask.valueOf(scanner.next());
        System.out.println("Введите дату и время в формате год-месяц-день час:мин : ");
        LocalDate dateTask = LocalDate.parse(scanner.next());
        LocalTime timeTask = LocalTime.parse(scanner.next());
        LocalDateTime startTime = LocalDateTime.of(dateTask, timeTask);
        System.out.println("Укажите повторяемость задачи: ");
        System.out.println(

                        "1 - не повторяется" + '\n' +
                        "2 - через день" + '\n' +
                        "3 - через неделю" + '\n' +
                        "4 - через месяц" + '\n' +
                        "5 - через год"
                        );
        int typeRepeat = scanner.nextInt();

        switch (typeRepeat) {
            case 1:
                try {
                    diary.addTask(new OneTime(taskName, taskDescription, typeTask, startTime)); break;
                } catch (WrongDataException e) {
                System.out.println(e.getMessage());
            }
            case 2:
                try {
                    diary.addTask(new EveryDay(taskName, taskDescription, typeTask, startTime)); break;
                } catch (WrongDataException e) {
                    System.out.println(e.getMessage());
                }
            case 3:
                try {
                    diary.addTask(new EveryWeek(taskName, taskDescription, typeTask, startTime)); break;
                } catch (WrongDataException e) {
                    System.out.println(e.getMessage());
                }
            case 4:
                try {
                    diary.addTask(new EveryMonth(taskName, taskDescription, typeTask, startTime)); break;
                } catch (WrongDataException e) {
                    System.out.println(e.getMessage());
                }
            case 5:
                try {
                    diary.addTask(new EveryYear(taskName, taskDescription, typeTask, startTime)); break;
                } catch (WrongDataException e) {
                    System.out.println(e.getMessage());
                }
        }
    }

    private static void delTask(Scanner scanner, TaskService diary) {
        System.out.println("Укажите id задачи, которую хотите удалить");
        int idTask = scanner.nextInt();
        diary.deleteTask(idTask);
    }

    private static void printTasks(TaskService diary) {
        diary.printAllTasks();
    }

    private static void getTasksForDay(Scanner scanner, TaskService diary) {
        System.out.println("Укажите день, на который вы хотите получить список задачь в формате: год-месяц-день : ");
        LocalDate date = LocalDate.parse(scanner.next());
        diary.printTasksForDay(date);
    }

    private static void printMenu() {
        System.out.println(

                        "1. Добавить задачу" + '\n' +
                        "2. Удалить задачу" + '\n' +
                        "3. Получить задачу на указанный день" + '\n' +
                        "4. Получить все задачи"  + '\n' +
                        "0. Выход"

        );
    }
}
