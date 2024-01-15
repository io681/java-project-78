package hexlet.code.schemas;

public abstract class BaseSchema {
    private boolean isRequired;
    public final boolean isRequired() {
        return isRequired;
    }
    public final boolean isValid(Object obj) {
        if (!(checkInstance(obj))) {
            return false;
        }
        if ((obj == null || obj.toString().isEmpty()) && isRequired()) {
            return false;
        }
        return additionalValidate(obj);
    }

    public final void setRequired(boolean required) {
        isRequired = required;
    }

    public abstract boolean checkInstance(Object obj);
    public abstract boolean additionalValidate(Object obj);

}
