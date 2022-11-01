import java.time.LocalDateTime;

public class OneTime extends Task implements Repeatable {
    public OneTime(String name, String description, TypeTask typeTask, LocalDateTime dateOfTask) throws WrongDataException {
        super(name, description, typeTask, dateOfTask);
        setTypeRepeat(1);
    }

    @Override
    public LocalDateTime repeatable() {
        return getDateOfTask();
    }

    @Override
    public String toString() {
        return "Однократная задача " + super.toString();
    }
}
