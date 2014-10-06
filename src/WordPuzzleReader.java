

	import java.io.File;
	import java.util.ArrayList;
	import java.util.Scanner;

	/*
	 * This class read a text file
	 */
	public class WordPuzzleReader {

		private Scanner read;
		private int row;
		private int col;
		private char[][] table;
		private ArrayList<String> words = new ArrayList<String>();
		
		/*
		 * Constructor
		 * 
		 */
		public WordPuzzleReader(int row, int col){
			this.row = row;
			this.col = col;
			table = new char[this.row][this.col];
			
			
		}
		
		/*
		 * Open files within project
		 */
		public void openFile(){
				
			try{
				read = new Scanner(new File("puzzle.txt"));
			}
			catch(Exception e){
				
				System.out.println("File does not exist ");
			}
		}
		
		/*
		 * Reads File line by line until it gets to the last line of words to search
		 */
		public void readFile(){
			int j = 0;
			
			while(read.hasNextLine()){
				String line = read.nextLine();
				if(line.length() == 0){
					readWords();
					break;
				}
				readLine(line, j);
				j++;

			}
			
		
		}

		/*
		 * Reads eachline in the document as a character
		 * 	 
		 */
		public void readLine(String line, int col){
			int i = 0;
			int num = 0;
			int length = line.length();
			//System.out.println(length);
			while(i < length){
				char temp = line.charAt(i);
				
				if(temp != ' '){
				  table[col][num] = temp;
				  num++;
				}
				i++;
			}
		}
		
		/*
		 * Reads the last line of words to be searched in the text file
		 * 	 
		 */
		public void readWords(){
		
			while(read.hasNext()){
				String word = read.next();
				//System.out.println(word);
				words.add(word);
			}
		}
		
		
		
		/*
		 * Closes text file 
		 */
		public void closeFile(){
			read.close();
		}
			
		/*
		 * Prints the words and coordinates of words found in the puzzle
		 */
		public void print(){
			for(char[] x : table){
				System.out.println(x);
			}
			
			System.out.println(words);
			//System.out.println(table);
			
		}
		
		/* Returns the map of the crossword
		 *  
		 */
		public char[][] returnTable(){
			
			return table;
			
		}
		
		public ArrayList<String> returnWords(){
			
			return words;
		}

		
		
	}

	

