package hexlet.code;

public final class NumberSchema {
    static final NumberSchema NUMBER_SCHEMA = new NumberSchema();
    private boolean isPositive;
    private boolean isRequired;
    private int numberForValidation;
    private int[] range = new int[2];
    private boolean isRange;

    private NumberSchema() {
    }

    public static NumberSchema getNumberSchema() {
        return NUMBER_SCHEMA;
    }

    public boolean isValid(Object obj) {
        if (!(obj instanceof Integer) && !(obj == null)) {
            return false;
        }
        try {
            setNumberForValidation((int) obj);
        } catch (NullPointerException exc) {
            return !isRequired();
        }

        if (isPositive() && getNumberForValidation() <= 0) {
            return false;
        }

        if (isRange()
                && !(getNumberForValidation() >= getRange()[0] && getNumberForValidation() <= getRange()[1])) {
            return false;
        }
        return true;
    }

    public NumberSchema positive() {
        setPositive(true);
        return getNumberSchema();
    }

    public NumberSchema required() {
        setRequired(true);
        return getNumberSchema();
    }

    public NumberSchema range(int startNumber, int endNumber) {
        setRange(startNumber, endNumber);
        return getNumberSchema();
    }

    public void clearCash() {
        setRequired(false);
        setPositive(false);
        clearIsRange();
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public int getNumberForValidation() {
        return numberForValidation;
    }

    public void setNumberForValidation(int numberForValidation) {
        this.numberForValidation = numberForValidation;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public int[] getRange() {
        return range;
    }

    public void setRange(int startNumber, int endNumber) {
        this.range[0] = startNumber;
        this.range[1] = endNumber;
        this.isRange = true;
    }

    public boolean isRange() {
        return isRange;
    }
    public void clearIsRange() {
        this.isRange = false;
    }

}
