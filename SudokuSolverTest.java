/**
 *
 * @author Pak Ho
 */
public class SudokuSolverTest {
    
    public static void main(String[] args) throws Exception{
        //SudokuSolver Sudoku = new SudokuSolver();
        
        int[][] testSudoku1 = {
            {7,9,0,0,0,0,3,0,0},
            {0,0,0,0,0,6,9,0,0},
            {8,0,0,0,3,0,0,7,6},
            {0,0,0,0,0,5,0,0,2},
            {0,0,5,4,1,8,7,0,0},
            {4,0,0,7,0,0,0,0,0},
            {6,1,0,0,9,0,0,0,8},
            {0,0,2,3,0,0,0,0,0},
            {0,0,9,0,0,0,0,5,4}
        };
        
        SudokuSolver Sudoku = new SudokuSolver(testSudoku1);
        
        System.out.println(Sudoku.solveAndCount());
        System.out.println(Sudoku.getNumOfSudokuMade());
        System.out.println(Sudoku.getSampleSolution().toString());
    }
    
}
