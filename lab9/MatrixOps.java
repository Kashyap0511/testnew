package org.nitk.it112.lab9;
import java.util.Scanner;

class Matrix {
	int rows;
	int columns;
	int[][] matrix;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

}

public class MatrixOps {
	private Matrix matrixA;
	private Matrix matrixB;
	private Matrix matrixC;

	public static void main(String[] args) {
		MatrixOps mops = new MatrixOps();
		int userInput = 1;

		while (userInput != 6) {
			String menuMessage = "Matrix Ops\n" + "1. For entering matrix A data \n"
					+ "2. For entering matrix B data \n" + "3. For matrix addition \n" + "4. For matrix subtraction \n"
					+ "5. For matrix multiplication \n" + "6. For exiting \n" + "Enter your choice: ";
			System.out.println("Menu "+menuMessage);
			Scanner scanInput = new Scanner(System.in);
			userInput = scanInput.nextInt();
			switch (userInput) {
			case 1: {
				mops.matrixA = createMatrix(scanInput);
				break;
			}
			case 2: {
				mops.matrixB = createMatrix(scanInput);
				break;
			}
			case 3: {
				int opVal = 3;
				boolean matrixValidity = getMatrixValidity(opVal, mops.matrixA, mops.matrixB);
				if (matrixValidity) {
					mops.matrixC = addMatrices(mops.matrixA, mops.matrixB);
					getMatrixElements(mops.matrixC);
				} else {
					System.out.println("The number of rows and columns in both matrices should be equal");
				}
				break;
			}
			case 4: {
				int opVal = 4;
				boolean matrixValidity = getMatrixValidity(opVal, mops.matrixA, mops.matrixB);
				if (matrixValidity) {
					mops.matrixC = subtractMatrices(mops.matrixA, mops.matrixB);
					getMatrixElements(mops.matrixC);
				} else {
					System.out.println("The number of rows and columns in both matrices should be equal");
				}
				break;
			}
			case 5: {
				int opVal = 5;
				boolean matrixValidity = getMatrixValidity(opVal, mops.matrixA, mops.matrixB);
				if (matrixValidity) {
					mops.matrixC = multiplyMatrices(mops.matrixA, mops.matrixB);
					System.out.println("Matrix Multiplication Result");
					getMatrixElements(mops.matrixC);
				} else {
					System.out.println("The number of rows and columns in both matrices should be equal");
				}
				break;
			}case 6:{
				System.out.println("Exiting Matrix Calculator");
				break;
			}default:
				// throw new IllegalArgumentException("Unexpected value: " + userInput);
				System.out.println("You have entered an invalid choice!!");
				break;
			}
		}

	}

	private static Matrix addMatrices(Matrix matrixA2, Matrix matrixB2) {
		Matrix matrixC = new Matrix();
		int[][] matrixAElements = matrixA2.getMatrix();
		int[][] matrixBElements = matrixB2.getMatrix();
		int[][] matrixCElements = new int[matrixA2.getRows()][matrixA2.getColumns()];
		for (int i = 0; i < matrixA2.getRows(); i++) {
			for (int j = 0; j < matrixA2.getColumns(); j++) {
				matrixCElements[i][j] = matrixAElements[i][j] + matrixBElements[i][j];
			}
		}
		matrixC.setRows(matrixA2.getRows());
		matrixC.setColumns(matrixA2.getColumns());
		matrixC.setMatrix(matrixCElements);
		return matrixC;
	}

	private static Matrix multiplyMatrices(Matrix matrixA2, Matrix matrixB2) {
		Matrix matrixC = new Matrix();
		int[][] matrixAElements = matrixA2.getMatrix();
		int[][] matrixBElements = matrixB2.getMatrix();
		int[][] matrixCElements = new int[matrixA2.getRows()][matrixB2.getColumns()];
		for (int i = 0; i < matrixA2.getRows(); i++) {
			for (int j = 0; j < matrixB2.getColumns(); j++) {
				for (int k = 0; k < matrixA2.getColumns(); k++) {
					matrixCElements[i][k] += matrixAElements[i][j] * matrixBElements[j][k];
				}
			}
		}
		matrixC.setRows(matrixA2.getRows());
		matrixC.setColumns(matrixB2.getColumns());
		matrixC.setMatrix(matrixCElements);
		return matrixC;
	}

	private static Matrix subtractMatrices(Matrix matrixA2, Matrix matrixB2) {
		Matrix matrixC = new Matrix();
		int[][] matrixAElements = matrixA2.getMatrix();
		int[][] matrixBElements = matrixB2.getMatrix();
		int[][] matrixCElements = new int[matrixA2.getRows()][matrixA2.getColumns()];
		for (int i = 0; i < matrixA2.getRows(); i++) {
			for (int j = 0; j < matrixA2.getColumns(); j++) {
				matrixCElements[i][j] = matrixAElements[i][j] - matrixBElements[i][j];
			}
		}
		matrixC.setRows(matrixA2.getRows());
		matrixC.setColumns(matrixA2.getColumns());
		matrixC.setMatrix(matrixCElements);
		return matrixC;
	}

	private static boolean getMatrixValidity(int opVal, Matrix matrixA2, Matrix matrixB2) {
		boolean matrixValidity = false;
		// opVal is addition(3) or subtraction(4)
		if (opVal == 3 || opVal == 4) {
			if (matrixA2.getRows() == matrixB2.getRows() || matrixA2.getColumns() == matrixB2.getColumns())
				matrixValidity = true;
		} else if (opVal == 5) {
			if (matrixA2.getColumns() == matrixB2.getRows())
				matrixValidity = true;
		}
		return matrixValidity;
	}

	private static Matrix createMatrix(Scanner scanInput) {
		Matrix matrix = new Matrix();
		System.out.println("Enter number of rows for matrix:");
		matrix.setRows(scanInput.nextInt());
		System.out.println("Enter number of columns for matrix:");
		matrix.setColumns(scanInput.nextInt());
		System.out.println(
				"Enter elements by rows for " + matrix.getRows() +" by " +matrix.getColumns()+" matrix");
		int[][] myMatrix = new int[matrix.getRows()][matrix.getColumns()];
		for (int i = 0; i < matrix.getRows(); i++)
			for (int j = 0; j < matrix.getColumns(); j++)
				myMatrix[i][j] = scanInput.nextInt();
		matrix.setMatrix(myMatrix);
		getMatrixElements(matrix);
		return matrix;
	}

	private static void getMatrixElements(Matrix matrix) {
		System.out.println("Matrix elements are ");
		int[][] storedMatrix = matrix.getMatrix();
		for (int i = 0; i < matrix.getRows(); i++) {
			for (int j = 0; j < matrix.getColumns(); j++)
				System.out.print(storedMatrix[i][j] + " ");
			System.out.println();
		}
	}

}
