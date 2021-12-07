public enum TAX {
    BASIC(0), IMPORTED(1), EXEMPTIONS(2);
    public int ValueEnum;
    TAX(int ValueEnum) {
        this.ValueEnum = ValueEnum;
    }
}