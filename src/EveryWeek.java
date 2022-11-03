import java.time.LocalDate;
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
    public boolean appearsIn(LocalDate date) {
        return (date.isEqual(getDateOfTask().toLocalDate()) || date.isAfter(getDateOfTask().toLocalDate()) && date.getDayOfWeek() == getDateOfTask().getDayOfWeek());
    }

    @Override
    public String toString() {
        return "Еженедельная задача " + super.toString();
    }
}
