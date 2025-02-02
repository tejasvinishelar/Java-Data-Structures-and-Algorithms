
public class PA13CShelar
{
	static int sudoku1[][]=new int[9][9];
	static int n=3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] magicmatrixSudoku1=new int[n][n];
		int[][] magicmatrixSudoku2=new int[n][n];
		int[][] magicmatrixSudoku3=new int[n][n];
		int[][] magicmatrixSudoku4=new int[n][n];
		
		magicmatrixSudoku1=getmagicmatrix(n);
		magicmatrixSudoku2=getRotatedMagicMatrix(magicmatrixSudoku1);
		magicmatrixSudoku3=getRotatedMagicMatrix(magicmatrixSudoku2);
		magicmatrixSudoku4=getRotatedHorizontallyMagicMatrix(magicmatrixSudoku1);
		getsudoku(magicmatrixSudoku1);
		getsudoku(magicmatrixSudoku2);
		getsudoku(magicmatrixSudoku3);
		getsudoku(magicmatrixSudoku4);
	}
	private static int[][] getRotatedHorizontallyMagicMatrix(int[][] magicmatrixSudoku) {
		int subGrid[][] = new int[n][n];
		for(int i=0;i<magicmatrixSudoku[0].length;i++) {
			for(int j=0;j<magicmatrixSudoku[0].length;j++) {
				if(i==2) {
					subGrid[0][j]=magicmatrixSudoku[i][j];
				}else {
				subGrid[i+1][j]=magicmatrixSudoku[i][j];
				}
			}
		}
		return subGrid;
	}
	private static int[][] getRotatedMagicMatrix(int[][] magicmatrixSudoku) {
		// TODO Auto-generated method stub
		int subGrid[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j==2) {
					subGrid[i][0]=magicmatrixSudoku[i][j];
				}else {
				subGrid[i][j+1]=magicmatrixSudoku[i][j];
				}
			}
		}
		return subGrid;
	}
		
	private static void getsudoku(int[][] subGrid1) {
		// TODO Auto-generated method stub
		int subGrid2[][],subGrid3[][],subGrid4[][],subGrid5[][],subGrid6[][],subGrid7[][],subGrid8[][],subGrid9[][];
		subGrid2=getHorizontalSubgrid(subGrid1);
		subGrid3=getHorizontalSubgrid(subGrid2);
		subGrid4=getVerticalSubgrid(subGrid1);
		subGrid5=getVerticalSubgrid(subGrid2);
		subGrid6=getVerticalSubgrid(subGrid3);
		subGrid7=getVerticalSubgrid(subGrid4);
		subGrid8=getVerticalSubgrid(subGrid5);
		subGrid9=getVerticalSubgrid(subGrid6);
		
		//sudoku1=fillSubGrid(subGrid1);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(i<3&&j<3) {
					sudoku1[i][j]=subGrid1[i][j];
				}else if(i<3&&j<6) {
					sudoku1[i][j]=subGrid2[i][j-3];
				}else if(i<3&&j<9) {
					sudoku1[i][j]=subGrid3[i][j-6];
				}else if(i<6&&j<3) {
					sudoku1[i][j]=subGrid4[i-3][j];
				}else if(i<6&&j<6) {
					sudoku1[i][j]=subGrid5[i-3][j-3];
				}else if(i<6&&j<9) {
					sudoku1[i][j]=subGrid6[i-3][j-6];
				}else if(i<9&&j<3) {
					sudoku1[i][j]=subGrid7[i-6][j];
				}else if(i<9&&j<6) {
					sudoku1[i][j]=subGrid8[i-6][j-3];
				}else if(i<9&&j<9) {
					sudoku1[i][j]=subGrid9[i-6][j-6];
				}
			}
		}
		System.out.println("\n\n9X9 Sudoku : ");
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(" "+sudoku1[i][j]);
			}
			System.out.println(" ");
			
		}
	}
	private static int[][] getVerticalSubgrid(int[][] subGrid4) {
		// TODO Auto-generated method stub
		int subGrid[][] =new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j==2) {
					subGrid[i][0]=subGrid4[i][j];
				}else {
				subGrid[i][j+1]=subGrid4[i][j];
				}
			}
		}
		
		return subGrid;
	}
	private static int[][] getHorizontalSubgrid(int[][] subGrid1) {
		// TODO Auto-generated method stub
		int subGrid2[][]=new int[n][n];
		for(int i=0;i<subGrid1[0].length;i++) {
			for(int j=0;j<subGrid1[0].length;j++) {
				if(i==2) {
					subGrid2[0][j]=subGrid1[i][j];
				}else {
				subGrid2[i+1][j]=subGrid1[i][j];
				}
			}
		}
		return subGrid2;
	}
	private static int[][] getmagicmatrix(int n) {
		// TODO Auto-generated method stub
		int magicmatrix[][]=new int[n][n];
		int counter = 1;
		int row = 0;
		int col = (n - 1) / 2;
		magicmatrix[row][col] = counter;
 
		while (true) {
				if (magicmatrix[(row-1)<0 ? (row-1+n) : row-1][(col+1)%n] == 0) {
				row = (row-1)<0 ? (row-1+n) : row - 1;
				col = (col+1) % n;
			} else { row=(row + 1)%n; }
 
			counter=counter+1;
			magicmatrix[row][col]=counter;
			if (counter==n*n) break;
		}
 
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				System.out.print(magicmatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\nMagical No : " + (n*n*n+n)/2);
		return magicmatrix;
	}
}
