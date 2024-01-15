package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    private boolean isPositive;
    private final int[] range = new int[2];
    private boolean isRange;
    public NumberSchema() {
    }
    @Override
    public boolean isValid(Object obj) {
        Integer actual;
        boolean result = super.isValid(obj);

        try {
            actual = (Integer) obj;
        } catch (ClassCastException exc) {
            return false;
        }

        try {
            if (isPositive() && actual <= 0) {
                return false;
            }
        } catch (NullPointerException exc) {
            return !isRequired();
        }

        if (isRange()
                && !(actual >= getRange()[0] && actual <= getRange()[1])) {
            return false;
        }
        return result;
    }
    public boolean checkInstance(Object obj) {
        return obj instanceof Integer || obj == null;
    }
    public NumberSchema required() {
        setRequired(true);
        return this;
    }
    public NumberSchema positive() {
        setPositive(true);
        return this;
    }

    public NumberSchema range(int startNumber, int endNumber) {
        setRange(startNumber, endNumber);
        return this;
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
