import java.time.LocalDateTime;

public class EveryWeek extends Task implements Repeatable {
    public EveryWeek(String name, String description, TypeTask typeTask, LocalDateTime dateOfTask) throws WrongDataException {
        super(name, description, typeTask, dateOfTask);
        setTypeRepeat(3);
    }


    @Override
    public LocalDateTime repeatable() {
        return getDateOfTask().plusWeeks(1);
    }

    @Override
    public String toString() {
        return "Еженедельная задача " + super.toString();
    }
}
