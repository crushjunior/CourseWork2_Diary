import java.time.LocalDate;
import java.time.LocalDateTime;

public class EveryYear extends Task implements Repeatable {
    public EveryYear(String name, String description, TypeTask typeTask, LocalDateTime dateOfTask) throws WrongDataException {
        super(name, description, typeTask, dateOfTask);
        setTypeRepeat(5);
    }

    @Override
    public LocalDateTime repeatable() {
        return getDateOfTask().plusYears(1);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return (date.isEqual(getDateOfTask().toLocalDate()) || date.isAfter(getDateOfTask().toLocalDate()) && date.getDayOfYear() == getDateOfTask().getDayOfYear());
    }

    @Override
    public String toString() {
        return "Ежегодная задача: " + super.toString();
    }
}
