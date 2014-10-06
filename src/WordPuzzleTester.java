import java.util.ArrayList;


public class WordPuzzleTester {

	public static void main(String[] arg){
		
		
		int rows = 8;
		int columns = 8;
		char[][] map;
		ArrayList<String> words = new ArrayList<>();
		
		WordPuzzleReader r = new WordPuzzleReader(rows, columns);

		r.openFile();
		r.readFile();
		r.closeFile();
		
		
		map = r.returnTable();
		words = r.returnWords();
		r.print();
		
		Address f = new Address(rows, columns, map, words);
		f.searchList();
		
		//f.search8();
		
		
		
		
	}
	
	
}
