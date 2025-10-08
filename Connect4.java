import java.util.*;

public class Connect4 {
    static final int ROWS = 6;
    static final int COLS = 7;
    static char[][] board = new char[ROWS][COLS];
    static char currentPlayer = 'X';
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int mode; // 1 = PvP, 2 = Basic AI, 3 = Advanced AI

    public static void main(String[] args) {
        System.out.println("=== CONNECT 4 ===");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Basic AI");
        System.out.println("3. Player vs Advanced AI (Minimax + Alpha-Beta)");
        System.out.print("Choose mode: ");
        mode = scanner.nextInt();

        initializeBoard();
        printBoard();

        while (true) {
            System.out.println("Player_" + (currentPlayer == 'X' ? "1" : "2") + "'s turn.");

            int col;
            if (mode == 1 || (mode > 1 && currentPlayer == 'X')) {
                col = getPlayerMove();
            } else if (mode == 2) {
                col = getAIMoveBasic();
                System.out.println("AI chooses column: " + col);
            } else {
                col = getAIMoveAdvanced(5); // depth 5
                System.out.println("AI (Minimax) chooses column: " + col);
            }

            if (isColumnFull(col)) {
                System.out.println("Column is full. Try again.");
                continue;
            }

            int row = dropPiece(col);
            printBoard();

            if (checkWin(row, col)) {
                System.out.println("Player_" + (currentPlayer == 'X' ? "1" : "2") + " wins!");
                break;
            }

            if (isBoardFull()) {
                System.out.println("It's a tie!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                board[i][j] = '.';
    }

    public static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }

    public static int getPlayerMove() {
        int col;
        while (true) {
            System.out.print("Enter a column (0-6): ");
            col = scanner.nextInt();
            if (col >= 0 && col < COLS)
                break;
            System.out.println("Invalid column. Try again.");
        }
        return col;
    }

    // BASIC AI: random valid column
    public static int getAIMoveBasic() {
        List<Integer> validCols = new ArrayList<>();
        for (int j = 0; j < COLS; j++)
            if (!isColumnFull(j))
                validCols.add(j);
        return validCols.get(random.nextInt(validCols.size()));
    }

    // ADVANCED AI: Minimax with Alpha-Beta pruning
    public static int getAIMoveAdvanced(int depth) {
        int bestCol = -1;
        int bestScore = Integer.MIN_VALUE;

        for (int col = 0; col < COLS; col++) {
            if (isColumnFull(col)) continue;

            int row = simulateDrop(col, 'O');
            int score = minimax(depth - 1, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
            undoMove(row, col);

            if (score > bestScore) {
                bestScore = score;
                bestCol = col;
            }
        }
        return bestCol;
    }

    public static int minimax(int depth, boolean maximizingPlayer, int alpha, int beta) {
        if (depth == 0 || isBoardFull()) {
            return evaluateBoard();
        }

        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int col = 0; col < COLS; col++) {
                if (isColumnFull(col)) continue;
                int row = simulateDrop(col, 'O');
                if (checkWin(row, col)) {
                    undoMove(row, col);
                    return 100000; // AI win
                }
                int eval = minimax(depth - 1, false, alpha, beta);
                undoMove(row, col);
                maxEval = Math.max(maxEval, eval);
                alpha = Math.max(alpha, eval);
                if (beta <= alpha) break;
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int col = 0; col < COLS; col++) {
                if (isColumnFull(col)) continue;
                int row = simulateDrop(col, 'X');
                if (checkWin(row, col)) {
                    undoMove(row, col);
                    return -100000; // Player win
                }
                int eval = minimax(depth - 1, true, alpha, beta);
                undoMove(row, col);
                minEval = Math.min(minEval, eval);
                beta = Math.min(beta, eval);
                if (beta <= alpha) break;
            }
            return minEval;
        }
    }

    // Evaluation function: count potential 2s and 3s for AI and player
    public static int evaluateBoard() {
        int score = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 'O') score += 2;
                else if (board[i][j] == 'X') score -= 2;
            }
        }
        return score;
    }

    public static boolean isColumnFull(int col) {
        return board[0][col] != '.';
    }

    public static int dropPiece(int col) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == '.') {
                board[i][col] = currentPlayer;
                return i;
            }
        }
        return -1;
    }

    public static int simulateDrop(int col, char player) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == '.') {
                board[i][col] = player;
                return i;
            }
        }
        return -1;
    }

    public static void undoMove(int row, int col) {
        board[row][col] = '.';
    }

    public static boolean isBoardFull() {
        for (int j = 0; j < COLS; j++)
            if (board[0][j] == '.')
                return false;
        return true;
    }

    public static boolean checkWin(int row, int col) {
        return checkHorizontal(row, col) || checkVertical(row, col) || checkDiagonal(row, col);
    }

    public static boolean checkHorizontal(int row, int col) {
        int count = 0;
        for (int i = 0; i < COLS; i++) {
            count = (board[row][i] == currentPlayer) ? count + 1 : 0;
            if (count >= 4) return true;
        }
        return false;
    }

    public static boolean checkVertical(int row, int col) {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            count = (board[i][col] == currentPlayer) ? count + 1 : 0;
            if (count >= 4) return true;
        }
        return false;
    }

    public static boolean checkDiagonal(int row, int col) {
        return checkDiagonalDir(row, col, 1, 1) || checkDiagonalDir(row, col, 1, -1);
    }

    public static boolean checkDiagonalDir(int row, int col, int dr, int dc) {
        int count = 0;
        for (int i = -3; i <= 3; i++) {
            int r = row + i * dr, c = col + i * dc;
            if (r >= 0 && r < ROWS && c >= 0 && c < COLS && board[r][c] == currentPlayer)
                count++;
            else
                count = 0;
            if (count >= 4) return true;
        }
        return false;
    }
}
