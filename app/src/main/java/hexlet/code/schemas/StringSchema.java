package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    static final StringSchema STRING_SCHEMA = new StringSchema();
    private String stringForValidation;
    private int minLength;
    private String contains;

    public static StringSchema getStringSchema() {
        return STRING_SCHEMA;
    }
    private StringSchema() {
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
