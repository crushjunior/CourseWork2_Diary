import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int countId = 1;
    private final int id;
    private String name;
    private String description;
    private TypeTask typeTask;
    private final LocalDateTime dateOfTask;


    public Task(String name, String description, TypeTask typeTask, LocalDateTime dateOfTask) throws WrongDataException {
        this.id = countId++;
        setName(name);
        setDescription(description);
        setTypeTask(typeTask);

        if (dateOfTask == null) {
            this.dateOfTask = LocalDateTime.now();
        } else {
            this.dateOfTask = dateOfTask;
        }
    }

    public void setName(String name) throws WrongDataException{
        if (name == null || name.isBlank()) {
            throw new WrongDataException("Заголовок заполнен не корректно!");
        } else {
            this.name = name;
        }
    }

    public void setDescription(String description) throws WrongDataException{
        if (description == null || description.isBlank()) {
            throw new WrongDataException("Описание заполнено не корректно!");
        } else {
            this.description = description;
        }
    }

    public void setTypeTask(TypeTask typeTask) throws WrongDataException{
        if (typeTask == null) {
            throw new WrongDataException("Укажите тип задачи!");
        } else {
            this.typeTask = typeTask;
        }
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public LocalDateTime getDateOfTask() {
        return dateOfTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(description, task.description) && typeTask == task.typeTask && Objects.equals(dateOfTask, task.dateOfTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, typeTask, dateOfTask);
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", заголовок: " + name +
                ", описание: " + description +
                ", тип: " + typeTask +
                ", дата создания: " + dateOfTask;
    }

    public abstract boolean appearsIn(LocalDate date);
}


