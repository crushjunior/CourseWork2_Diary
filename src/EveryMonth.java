import java.time.LocalDate;
import java.time.LocalDateTime;

public class EveryMonth extends Task implements Repeatable{
    public EveryMonth(String name, String description, TypeTask typeTask, LocalDateTime dateOfTask) throws WrongDataException {
        super(name, description, typeTask, dateOfTask);
    }


    @Override
    public boolean appearsIn(LocalDate date) {
        return (date.isEqual(getDateOfTask().toLocalDate()) || date.isAfter(getDateOfTask().toLocalDate()) && date.getDayOfMonth() == getDateOfTask().getDayOfMonth());
    }

    @Override
    public String toString() {
        return "Ежемесячная задача " + super.toString();
    }
}
