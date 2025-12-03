class Spreadsheet {
    private int[][] grid;

    public Spreadsheet(int rows) {
        grid = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int[] pos = getCellPosition(cell);
        grid[pos[0]][pos[1]] = value;
    }
    public void resetCell(String cell) {
        int[] pos = getCellPosition(cell);
        grid[pos[0]][pos[1]] = 0;
    }
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] parts = formula.split("\\+");
        int sum = 0;
        for (String part : parts) {
            sum += evaluate(part);
        }
        return sum;
    }
    private int evaluate(String token) {
        if (Character.isDigit(token.charAt(0))) {
            return Integer.parseInt(token);
        } else {
            int[] pos = getCellPosition(token);
            return grid[pos[0]][pos[1]];
        }
    }
    private int[] getCellPosition(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}
