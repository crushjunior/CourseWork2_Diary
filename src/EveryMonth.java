import java.time.LocalDateTime;

public class EveryMonth extends Task implements Repeatable{
    public EveryMonth(String name, String description, TypeTask typeTask, LocalDateTime dateOfTask) throws WrongDataException {
        super(name, description, typeTask, dateOfTask);
        setTypeRepeat(4);
    }

    @Override
    public LocalDateTime repeatable() {
        return getDateOfTask().plusMonths(1);
    }

    @Override
    public String toString() {
        return "Ежемесячная задача " + super.toString();
    }
}
