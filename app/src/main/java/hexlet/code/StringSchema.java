package hexlet.code;

public final class StringSchema {
    static final StringSchema STRING_SCHEMA = new StringSchema();
    private String stringForValidation;
    private boolean isRequired;
    private int minLength;
    private String contains;
    private StringSchema() {

    }
    public static StringSchema getStringSchema() {
        return STRING_SCHEMA;
    }

    public boolean isValid(Object obj) {
        if (obj == null && isRequired()) {
            return false;
        }

        try {
            setStringForValidation((String) obj);
        } catch (ClassCastException exc) {
            return false;
        }

        if (isRequired() && getStringForValidation().isEmpty()) {
            return false;
        }

        if (getMinLength() > 0 && getStringForValidation().length() < getMinLength()) {
            return false;
        }
        if (!(getContains() == null) && !getStringForValidation().contains(getContains())) {
            return false;
        }

        return true;
    }
    public StringSchema required() {
        setRequired(true);
        return getStringSchema();
    }
    public StringSchema minLength(int number) {
        setMinLength(number);
        return getStringSchema();
    }

    public StringSchema contains(String stringContains) {
        setContains(stringContains);
        return getStringSchema();
    }

    public String getStringForValidation() {
        return stringForValidation;
    }

    public void setStringForValidation(String stringForValidation) {
        this.stringForValidation = stringForValidation;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        this.isRequired = required;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }

    public void clearCash() {
        setRequired(false);
        setContains(null);
        setMinLength(0);
    }
}
