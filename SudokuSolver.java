/**
 *
 * @author Pak Ho
 */
public class SudokuSolver extends Sudoku {
    
    private int[][] solvedSudoku;
    private int[][] sampleSolution;
    private double numOfSudokuMade = 0.0;
    
    public SudokuSolver(){
        
        super();
    }
    
    public SudokuSolver(int[][] sudoku) throws Exception { 
        
        super(sudoku);
    }
    
    public double getNumOfSudokuMade(){
        return numOfSudokuMade;
    }
    
    public int[][] getSampleSolution(){
        return sampleSolution;
    }
    
    public double solveAndCount() throws Exception{
        
        solvedSudoku = new int[9][9];
        return depthFirstSearch(0, 0, 0);
    }
    
    private double depthFirstSearch(int curRow, int curCol, int numOfResult) throws Exception {
        
        //System.out.println("Row " + curRow + " Col " + curCol);
        
        double newNumOfResult = numOfResult;
        
        if(curRow > 8){
            numOfSudokuMade++;
            sampleSolution = solvedSudoku.clone();
            Sudoku tempSudoku = new Sudoku(solvedSudoku);
            tempSudoku.printSudoku();
            //tempSudoku.printSudoku();
            
            if(tempSudoku.isValidSudoku()){
                
                return numOfResult + 1;
            } else {
                return numOfResult;
            }
        } else {
            if(this.getVal(curRow, curCol) != 0){
                solvedSudoku[curRow][curCol] = this.getVal(curRow, curCol);
                if(curCol == 8){
                    newNumOfResult = depthFirstSearch(curRow+1, 0, numOfResult);
                } else {
                    newNumOfResult = depthFirstSearch(curRow, curCol+1, numOfResult);
                }
            } else {
                for(int i = 1; i < 10; i++){
                    solvedSudoku[curRow][curCol] = i;
                    if(curCol == 8){
                        newNumOfResult = depthFirstSearch(curRow+1, 0, numOfResult);
                    } else {
                        newNumOfResult = depthFirstSearch(curRow, curCol+1, numOfResult);
                    }
                }
            }
            return newNumOfResult;
        }
        
        /*
        if(!(this.getVal(nextRow, nextCol) == 0)){
            
            solvedSudoku[nextRow][nextCol] = this.getVal(nextRow, nextCol);
            
            if(nextCol == 8){
                    return depthFirstSearch(nextRow+1, 0, numOfResult);
                } else {
                    return depthFirstSearch(nextRow, nextCol+1, numOfResult);
                }
        } else {
            
            for(int i = 1; i < 10; i++){
                
                solvedSudoku[nextRow][nextCol] = i;
                
                if(nextCol == 8){
                    return depthFirstSearch(nextRow+1, 0, numOfResult);
                } else {
                    return depthFirstSearch(nextRow, nextCol+1, numOfResult);
                }
            }
        }
        
        return numOfResult;
                */
    }
}
