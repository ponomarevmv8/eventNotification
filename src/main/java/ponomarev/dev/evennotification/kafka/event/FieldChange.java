package ponomarev.dev.evennotification.kafka.event;

public class FieldChange<T> {

    private T oldField;
    private T newField;

    public FieldChange(T oldField, T newField) {
        this.oldField = oldField;
        this.newField = newField;
    }

    public FieldChange() {
    }

    public T getOldField() {
        return oldField;
    }

    public void setOldField(T oldField) {
        this.oldField = oldField;
    }

    public T getNewField() {
        return newField;
    }

    public void setNewField(T newField) {
        this.newField = newField;
    }

    @Override
    public String toString() {
        return "FieldChange{" +
               "oldField=" + oldField +
               ", newField=" + newField +
               '}';
    }

    public static <T> T getOldField(FieldChange<T> fieldChange) {
        return  fieldChange != null ? fieldChange.getOldField() : null;
    }

    public static <T> T getNewField(FieldChange<T> fieldChange) {
        return  fieldChange != null ? fieldChange.getNewField() : null;
    }
}
