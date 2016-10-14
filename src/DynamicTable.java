import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicTable {
	// Add necessary fields
	int allocatedSize;
	int actualSize;
	int[] table;
	
	public DynamicTable() {
		this.actualSize = 0;
		this.allocatedSize = 1;
		this.table = new int[1];
	
	}

	public void insert(int number) {
		// Implement this
		if (actualSize == allocatedSize) {
			allocatedSize = allocatedSize * 2;
			int[] temp = new int[allocatedSize];
			
			for (int i = 0; i < actualSize; i++) {
				temp[i] = table[i];
			}
			table = temp;

		}
//		System.out.println(actualSize);
//		System.out.println(allocatedSize + " allocatied size");

		table[actualSize++] = number;

	}

	public void delete() {
		if(actualSize-1 == allocatedSize/4){
			allocatedSize = allocatedSize / 2;
			int[] temp = new int[allocatedSize];
			for (int i = 0; i < actualSize-1; i++) {
				temp[i] = table[i];
			}
			table = temp;
		}
		if (actualSize > 0){
		actualSize--;
		}
		if( allocatedSize == 0){
			allocatedSize = 1;
			table = new int[1];
		}
		
		
		// Implement this
	}

	public void printTable() {
		// Implement this
		for (int i = 0; i < actualSize; i++) {
			System.out.print(table[i] + " ");
		}
		System.out.println();
	}

	public void reportSize() {
		// Implement this
		System.out.println(actualSize + " " + allocatedSize);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		DynamicTable table = new DynamicTable();

		String line;

		while ((line = input.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line);
			String cmd = tokens.nextToken();

			if (cmd.equals("I")) {
				table.insert(Integer.parseInt(tokens.nextToken()));
			} else if (cmd.equals("D")) {
				table.delete();
			} else if (cmd.equals("P")) {
				table.printTable();
			} else if (cmd.equals("S")) {
				table.reportSize();
			}
		}
	}
}
