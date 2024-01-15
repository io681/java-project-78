package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    private int minLength;
    private String contains;
    public StringSchema() {
    }
    public boolean checkInstance(Object obj) {
        return obj instanceof String || obj == null;
    }
    public boolean additionalValidate(Object obj) {
        String actual;
        try {
            actual = (String) obj;
        } catch (ClassCastException exc) {
            return false;
        }

        if (getMinLength() > 0 && actual.length() < getMinLength()) {
            return false;
        }
        if (!(getContains() == null) && !actual.contains(getContains())) {
            return false;
        }

        return true;
    }
    public StringSchema required() {
        setRequired(true);
        return this;
    }
    public StringSchema minLength(int number) {
        setMinLength(number);
        return this;
    }

    public StringSchema contains(String stringContains) {
        setContains(stringContains);
        return this;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLengthForSet) {
        this.minLength = minLengthForSet;
    }

    public String getContains() {
        return contains;
    }

    public void setContains(String containsForSet) {
        this.contains = containsForSet;
    }

    public void clearCash() {
        setRequired(false);
        setContains(null);
        setMinLength(0);
    }
}
