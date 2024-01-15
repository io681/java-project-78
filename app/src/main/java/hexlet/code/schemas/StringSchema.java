package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    private int minLength;
    private String contains;
    public StringSchema() {
    }
    @Override
    public boolean isValid(Object obj) {
        String actual;
        boolean result = super.isValid(obj);

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

        return result;
    }
    public boolean checkInstance(Object obj) {
        return obj instanceof String || obj == null;
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
