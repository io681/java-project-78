package hexlet.code.schemas;

public abstract class BaseSchema {
    private boolean isRequired;
    boolean isRequired() {
        return isRequired;
    }
    protected  boolean isValid(Object obj) {
        if (!(checkInstance(obj))) {
            return false;
        }
        if ((obj == null || obj.toString().isEmpty()) && isRequired()) {
            return false;
        }
        return true;
    }

    public final void setRequired(boolean required) {
        isRequired = required;
    }

    public abstract boolean checkInstance(Object obj);

}
