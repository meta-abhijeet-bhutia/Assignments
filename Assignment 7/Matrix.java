package matrix;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {

	private ArrayList<Position> positions;
	private final int rows;
	private final int cols;

	public ArrayList<Position> getMatrix() {
		return positions;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	Matrix(int[][] matrix) {
		this.rows = matrix.length;
		if (matrix.length > 0)
			this.cols = matrix[0].length;
		else
			throw new AssertionError();

		this.positions = new ArrayList<Position>();
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					positions.add(new Position(i, j, matrix[i][j]));
				}
			}
	}

	/**
	 * 
	 * @return Return transpose of Matrix
	 * 
	 *         COMPLEXITY - O(n) where n => Number of nonzero Elements of Matrix
	 */
	public int[][] getTranspose() {
		int[][] transpose = new int[this.cols][this.rows];
		for (Position position : this.positions) {
			transpose[position.getCol()][position.getRow()] = position
					.getValue();
		}
		return transpose;
	}

	/**
	 * 
	 * @return If the Matrix objects holds Symmetrical Matrix return true
	 *         otherwise false
	 * 
	 *         COMPLEXITY - O(n^2) where n => Number of nonzero Elements of
	 *         Matrix
	 */
	public boolean isSymmetrical() {
		int count = 0;
		int diagonal = 0;
		if (rows != cols)
			return false;
		for (Position position1 : this.positions) {
			if (position1.getRow() == position1.getCol()) {
				diagonal += 1;
			} else {
				for (int j = this.positions.indexOf(position1) + 1; j < this.positions
						.size(); j++) {
					Position position2 = this.positions.get(j);
					if (!position1.equals(position2)
							&& position1.getRow() == position2.getCol()
							&& position1.getCol() == position2.getRow()
							&& position1.getValue() == position2.getValue())
						count += 1;
				}
			}
		}

		if (2 * count + diagonal == this.positions.size())
			return true;
		return false;
	}

	/**
	 * 
	 * @param firstMatrix
	 *            Matrix object Represent Matrix 1
	 * @param secondMatrix
	 *            Matrix object Represent Matrix 2
	 * @return addition of Both matrix and return a matrix of 2D array in result
	 * 
	 *         COMPLEXITY - O(n^2) where n => Number of nonzero Elements of
	 *         Matrix
	 */
	public static int[][] addTwoMatrix(Matrix firstMatrix, Matrix secondMatrix) {
		if (firstMatrix.getRows() != secondMatrix.getRows()
				|| firstMatrix.getCols() != secondMatrix.getCols())
			throw new AssertionError();
		
		int[][] result = new int[firstMatrix.getRows()][firstMatrix.getCols()];
		boolean flag;
		boolean[] flagForM2 = new boolean[secondMatrix.getMatrix().size()];

		for (Position position1 : firstMatrix.getMatrix()) {
			flag = true;
			for (Position position2 : secondMatrix.getMatrix()) {
				if (position1.getRow() == position2.getRow()
						&& position1.getCol() == position2.getCol()) {

					result[position1.getRow()][position1.getCol()] = position1
							.getValue() + position2.getValue();
					flagForM2[secondMatrix.getMatrix().indexOf(position2)] = true;
					flag = false;
					break;
				}
			}
			if (flag) {
				result[position1.getRow()][position1.getCol()] = position1
						.getValue();
			}
		}

		for (int i = 0; i < secondMatrix.getMatrix().size(); i++) {
			if (!flagForM2[i]) {
				Position position2 = secondMatrix.getMatrix().get(i);
				result[position2.getRow()][position2.getCol()] = position2
						.getValue();
			}
		}
		return result;
	}

	/**
	 * 
	 * @param firstMatrix
	 *            Matrix object Represents First Matrix
	 * @param secondMatrix
	 *            Matrix object Represents Second Matrix
	 * @return Multiplication of Both Matrix and return 2D Array in result
	 * 
	 *         COMPLEXITY - O(n^2) where n => Number of nonzero Elements of
	 *         Matrix
	 */
	public static int[][] multiplyTwoMatrix(Matrix firstMatrix,
			Matrix secondMatrix) {
		if (firstMatrix.getCols() != secondMatrix.getRows()) {
			throw new AssertionError();
		}

		int[][] result = new int[firstMatrix.getRows()][secondMatrix.getCols()];

		for (Position position1 : firstMatrix.getMatrix()) {
			for (Position position2 : secondMatrix.getMatrix()) {
				if (position1.getCol() == position2.getRow()) {
					result[position1.getRow()][position2.getCol()] += position1
							.getValue() * position2.getValue();
				}
			}
		}
		return result;
	}

	// To Display Positions
	public void displayPoints() {
		for (Position p : this.positions) {
			System.out.println(p.getRow() + "," + p.getCol() + " --> "
					+ p.getValue());
		}
	}

	// To display a Matrix with given string s
	public void display(String s, int[][] matrix) {
		System.out.println("\n" + s);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " , ");
			}
			System.out.println();
		}
	}
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Size of Matrix:");
	int size=sc.nextInt();
	int[][] arr = new int[size][size];
	int[][] brr = new int[size][size];
	System.out.println("Enter Choice:\n1. Transpose\n2. Symmetrical\n3. Add two Matrix\n4. Multiply\n5. Exit");
	int choice=sc.nextInt();
	System.out.println("Enter values of first matrix");
	for(int i=0;i<size;i++)
	{
		for(int j=0;j<size;j++)
		{
			arr[i][j]=sc.nextInt();
		}
		
	}
	Matrix s1 = new Matrix(arr);
	
	switch(choice)
	{
		case 1:
			int[][] b = s1.getTranspose();
			s1.display("Transpose", b);
			break;
		case 2:
			boolean check = s1.isSymmetrical();
			System.out.println(check);
			break;
		case 3:
			System.out.println("Enter values of second matrix");
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					brr[i][j]=sc.nextInt();
				}
				
			}
			Matrix s2 = new Matrix(brr);
			b =  Matrix.addTwoMatrix(s1, s2);
			s1.display("Addition", b);
			break;
		case 4:
			System.out.println("Enter values of second matrix");
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					brr[i][j]=sc.nextInt();
				}
				
			}
			Matrix s3 = new Matrix(brr);
			b = Matrix.multiplyTwoMatrix(s1, s3);
			s1.display("Multiplication", b);
			break;
		case 5:
			System.exit(0);
			break;
		default:System.out.println("Wrong Choice");
	}
sc.close();
}
}