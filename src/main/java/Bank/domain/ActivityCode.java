package Bank.domain;

import java.util.Calendar;

public class ActivityCode {
    private final String value;

    public ActivityCode(Calendar issueDate, int sequence) {
        this.value = this.generateCode(issueDate, sequence);
    }

    private String generateCode(Calendar issueDate, int sequence) {
        String padSequence = String.format("%1$" + 8 + "s", sequence).replace(' ', '0');
        int year = issueDate.get(Calendar.YEAR);
        String parsedYear = Integer.toString(year);
        return parsedYear + padSequence;
    }
    public String getValue() {
        return this.value;
    }
}
