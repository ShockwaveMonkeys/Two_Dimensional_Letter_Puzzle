/*
 * Created: 	Oct 02, 2014
 * Author: 		Younggun Chung
 * Team name: 	ShockwaveMonkeys
 * Project:		Two Dimensional Letter Puzzle V2
 * 
 * purpose:		word searching algorithm on 2d array char puzzle
 * 
 * comment:		1) must need to get data from input class.
 * 				2) int row: puzzle's size of row
 * 				3) int col: puzzle's size of column
 * 				4) char[][] puzzle: puzzle's char table
 * 				5) String word: a word for searching on the puzzle 
 * 
 * memo:		1) if you want to test this class, you can try "main" at bottom line
 * 
 */

public class Address {
	
	public void search8(int row, int col, char[][] puzzle, String word){
		int i=0, j=0, w=0;		// using in for loop. i->col, j->row, w->word.charAt(w)
		int wordChecker;		// counter in level 3;
		
		if(word.length() < 3){		// if length of word is less than 3, it is too small to searching word on puzzle
			System.out.print("Seriously? the length of word is too short!");
			return;
		}
		
		// level 0
		for(i=0; i < col; i++){			//	for loop: puzzle's column 
			for(j=0; j < row; j++){		//	for loop: puzzle's row
				// level 1
				if(word.charAt(0) == puzzle[i][j]){		// if word's first char and char on puzzle is matched
					
					// level 2-1. (-)row checker ================================================================
					if( (j+word.length()) <= row ){		// if right side has enough word space 
						wordChecker = 1;
						
						// level 3;
						for(w=1; w < word.length(); w++){
							if(puzzle[i][j+w] != word.charAt(w))
								break;
							else
								++wordChecker;
						}	// for; level 3
											
						if(word.length() == wordChecker){
							/*	table for output.txt file 
							 * |	|	original address	|	destination address	|
							 * +----+-----------------------+-----------------------+
							 * |col	|	i+1					|	i+1					|
							 * |row	|	j+1					|	j+word.length()		|
							 */	
							System.out.println(word + ": [(" + (i+1) + "," + (j+1) + ")-(" + (i+1) + "," + (j+word.length()) + ")]" + " (-)row");
						}
					}	// if; level 2-1; row
					
					
					// level 2-2. (-)reverse-row checker ================================================================
					if( (j-word.length()) >= -1){		// if left side has enough word space 
						wordChecker = 1;						
						
						// level 3;
						for(w=1; w < word.length(); w++){
							if(puzzle[i][j-w] != word.charAt(w))
								break;
							else
								++wordChecker;
						}	// for; level 3
											
						if(word.length() == wordChecker){
							/*	table for output.txt file 
							 * |	|	original address	|	destination address	|
							 * +----+-----------------------+-----------------------+
							 * |col	|	i+1					|	i+1					|
							 * |row	|	j+1					|	j-word.length()+2	|
							 */	
							System.out.println(word + ": [(" + (i+1) + "," + (j+1) + ")-(" + (i+1) + "," + (j-word.length()+2) + ")]" + " (-)reverse-row");
							
						}
					}	// if; level 2-2; reverse row
					
					
					// level 2-3. (|)column checker ================================================================
					if( (i+word.length()) <= col ){		// if bottom side has enough word space 
						wordChecker = 1;
						
						// level 3;
						for(w=1; w < word.length(); w++){
							if(puzzle[i+w][j] != word.charAt(w))
								break;
							else
								++wordChecker;
						}	// for; level 3
											
						if(word.length() == wordChecker){
							/*	table for output.txt file 
							 * |	|	original address	|	destination address	|
							 * +----+-----------------------+-----------------------+
							 * |col	|	i+1					|	i+word.length()		|
							 * |row	|	j+1					|	j+1					|
							 */	
							System.out.println(word + ": [(" + (i+1) + "," + (j+1) + ")-(" + (i+word.length()) + "," + (j+1) + ")]" + " (|)column");
						}
					}	// if; level 2-3; column
					
					
					// level 2-4. (|)reverse-column checker ================================================================
					if( (i-word.length()) >= -1){		// if top side has enough word space 
						wordChecker = 1;
						
						// level 3;
						for(w=1; w < word.length(); w++){
							if(puzzle[i-w][j] != word.charAt(w))
								break;
							else
								++wordChecker;
						}	// for; level 3
											
						if(word.length() == wordChecker){
							/*	table for output.txt file 
							 * |	|	original address	|	destination address	|
							 * +----+-----------------------+-----------------------+
							 * |col	|	i+1					|	i-word.length()+2	|
							 * |row	|	j+1					|	j+1					|
							 */	
							System.out.println(word + ": [(" + (i+1) + "," + (j+1) + ")-(" + (i-word.length()+2) + "," + (j+1) + ")]" + " (|)reverse column");
						}
					}	// if; level 2-4; reverse column
					
					
					// level 2-5. (\)diagonal checker (1) ================================================================
					if( ((i+word.length()) <= col) && ((j+word.length()) <= row) ){		// if right bottom side has enough word space 
						wordChecker = 1;
						
						// level 3;
						for(w=1; w < word.length(); w++){
							if(puzzle[i+w][j+w] != word.charAt(w))
								break;
							else
								++wordChecker;
						}	// for; level 3
											
						if(word.length() == wordChecker){
							/*	table for output.txt file 
							 * |	|	original address	|	destination address	|
							 * +----+-----------------------+-----------------------+
							 * |col	|	i+1					|	i+word.length()		|
							 * |row	|	j+1					|	j+word.length()		|
							 */	
							System.out.println(word + ": [(" + (i+1) + "," + (j+1) + ")-(" + (i+word.length()) + "," + (j+word.length()) + ")]" + " (\\)diagonal");
						}
					}	// if; level 2-5; diagonal (1)
					
					
					// level 2-6. (\)reverse-diagonal checker (2) ================================================================
					if( ((i-word.length()) >= -1) && ((j-word.length()) >= -1) ){		// if left top side has enough word space 
						wordChecker = 1;
						
						// level 3;
						for(w=1; w < word.length(); w++){
							if(puzzle[i-w][j-w] != word.charAt(w))
								break;
							else
								++wordChecker;
						}	// for; level 3
											
						if(word.length() == wordChecker){
							/*	table for output.txt file 
							 * |	|	original address	|	destination address	|
							 * +----+-----------------------+-----------------------+
							 * |col	|	i+1					|	i-word.length()+2	|
							 * |row	|	j+1					|	j-word.length()+2	|
							 */	
							System.out.println(word + ": [(" + (i+1) + "," + (j+1) + ")-(" + (i-word.length()+2) + "," + (j-word.length()+2) + ")]" + " (\\)revese-diagonal");
						}
					}	// if; level 2-6; reverse diagonal (2)
					
					
					// level 2-7. (/)diagonal checker (3) ================================================================
					if( ((i+word.length()) <= col) && ((j-word.length()) >= -1) ){		// if left bottom side has enough word space 
						wordChecker = 1;
						
						// level 3;
						for(w=1; w < word.length(); w++){
							if(puzzle[i+w][j-w] != word.charAt(w))
								break;
							else
								++wordChecker;
						}	// for; level 3
											
						if(word.length() == wordChecker){
							/*	table for output.txt file 
							 * |	|	original address	|	destination address	|
							 * +----+-----------------------+-----------------------+
							 * |col	|	i+1					|	i+word.length()		|
							 * |row	|	j+1					|	j-word.length()+2	|
							 */	
							System.out.println(word + ": [(" + (i+1) + "," + (j+1) + ")-(" + (i+word.length()) + "," + (j-word.length()+2) + ")]" + " (/)diagoanl");
						}
					}	// if; level 2-7; diagonal (3)
					
					
					// level 2-8. (/)reverse-diagonal checker (4) ================================================================
					if( ((i-word.length()) >= -1) && ((j+word.length()) <= row) ){		// if right top side has enough word space 
						wordChecker = 1;
						
						// level 3;
						for(w=1; w < word.length(); w++){
							if(puzzle[i-w][j+w] != word.charAt(w))
								break;
							else
								++wordChecker;
						}	// for; level 3
											
						if(word.length() == wordChecker){
							/*	table for output.txt file 
							 * |	|	original address	|	destination address	|
							 * +----+-----------------------+-----------------------+
							 * |col	|	i+1					|	i-word.length()+2	|
							 * |row	|	j+1					|	j+word.length()		|
							 */	
							System.out.println(word + ": [(" + (i+1) + "," + (j+1) + ")-(" + (i-word.length()+2) + "," + (j+word.length()) + ")]" + " (/)reverse-diagoanl");
						}
					}	// if; level 2-8; diagonal (4)
				}	// if; level 1
				
			}	// for; j
		}	// for; i; level 0
		
	}	// search8
	

//	// test method
//	public static void main(String args[]){
//		char puzzle_test[][] = {
//				{'f', 'd', 'o', 'g', 'c', 'b', 't', 'e'},
//				{'i', 't', 'g', 'a', 's', 'a', 'u', 'b'},
//				{'s', 'a', 'a', 'b', 'c', 'a', 't', 't'},
//				{'h', 'c', 'f', 'i', 'h', 's', 'i', 'f'}
//		};
//		
//		int row_test = 8;
//		int col_test = 4;
//		String word_test = "cat";
//		
//		Address test = new Address();
//		test.search8(row_test, col_test, puzzle_test, word_test);
//		test.search8(row_test, col_test, puzzle_test, "dog");
//		test.search8(row_test, col_test, puzzle_test, "fish");
//	}

	
}	// class
