import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {

	int rowNumber, coloumnNumber, size;
	int [][] map;
	int [][] board;
	boolean game = true;
	
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	
	
	MayinTarlasi(int rowNumber, int coloumnNumber) {

		this.rowNumber = rowNumber;
		this.coloumnNumber = coloumnNumber;
		this.map = new int[rowNumber] [coloumnNumber];
		this.board = new int[rowNumber] [coloumnNumber];
		this.size = rowNumber*coloumnNumber;
		
	}
	
	public void prepareGame() {
		int randomRow, randomColoumn, count = 0;
		while(count != (size / 4)) {
			randomRow = random.nextInt(rowNumber);
			randomColoumn = random.nextInt(coloumnNumber);
			
			if(map[randomRow][randomColoumn] != -1) { //-1' e eþit deðilse mayýn yoktur.
				
				map[randomRow][randomColoumn] = -1;
				count++;
				
			}
		
			
		}
		
	}
	
	public void run() {
		
		prepareGame();
	    print(map); //Normalde bu olmayacak, biz test etmek için koyduk. Bu olursa oyun gözükür zaten...
		System.out.println("The game is start!");
		int row,coloumn,success = 0;
		boolean game = true;
		
		while(game) {
			
			print(board);
			System.out.println("Row: ");
			row = scanner.nextInt();
			System.out.println("Coloumn: ");
			coloumn = scanner.nextInt();
			scanner.nextLine();
			
			if(row<0 || row >= rowNumber) {
				
				System.out.println("Invalid coordinate !");
				continue;
				
			}
			if(coloumn<0 || coloumn >= coloumnNumber) {
				
				System.out.println("Invalid coordinate !");
				continue;
				
			}
			
			
			if(map[row][coloumn] != -1) { //yani mayýn(mine) yoksa
			    
				check(row,coloumn);
				success++;
				if(success == size-(size/4)) {
					System.out.println("You successed! You did not press any mines.");
					break;
				}
			
			}
			else { //mayýna bastýn!
				
				game = false;
				System.out.println("Game Over !");
				
			}
		}
		
		
	}
	
	public void check(int r, int c) {
		
		if(map[r][c] == 0) {
			
		if((c<coloumnNumber-1)&&map[r][c+1] == -1) {
			
			board[r][c]++;
			
		}
        if((r<rowNumber-1)&&map[r+1][c] == -1) {
			
        	board[r][c]++;
			
		}
        if((r>0)&&map[r-1][c] == -1) {
			
        	board[r][c]++;
			
		}
        if((c>0)&&map[r][c-1] == -1) {
        	
        	board[r][c]++;
	
        }
        if(board[r][c] == 0) {
        	
        	board[r][c] = -2;
        	
        }
        
		    }
		
	}
	
	public void print(int[][] arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[0].length; j++) {
				if(arr[i][j] >= 0) { //Bunu yapma sebebimiz: -'li sayýlarla ayný hizada bulundurmak(görsel için)
				System.out.print(" "); }
				System.out.print(arr[i][j]+" ");
				
			}
			System.out.println();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
