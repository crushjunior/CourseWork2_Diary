import java.time.LocalDate;
import java.time.LocalDateTime;

public class EveryDay extends Task implements Repeatable {


    public EveryDay(String name, String description, TypeTask typeTask, LocalDateTime dateOfTask) throws WrongDataException {
        super(name, description, typeTask, dateOfTask);
        setTypeRepeat(2);
    }



    @Override
    public LocalDateTime repeatable() {
        return getDateOfTask().plusDays(1);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return (date.isEqual(getDateOfTask().toLocalDate()) || date.isAfter(getDateOfTask().toLocalDate()));
    }

    @Override
    public String toString() {
        return "Ежедневная задача " + super.toString();
    }
}
