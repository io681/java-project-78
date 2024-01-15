package hexlet.code.schemas;

public abstract class BaseSchema {
    private boolean isRequired;
    public boolean isRequired() {
        return isRequired;
    }
    public void required() {
        setRequired(true);
    }
    public boolean isValid(Object obj) {
        if (!(checkInstance(obj))) {
            return false;
        }
        if ((obj == null || obj.toString().isEmpty()) && isRequired()) {
            return false;
        }
        return true;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public abstract boolean checkInstance(Object obj);

}
