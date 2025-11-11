import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Word{
	private	ArrayList<String> wordList; 
	private String word;
	private	char[] goal;
	
	public Word(){
		wordList = new ArrayList<>();
		word = "";
	}
	
	public char[] getGoal(){
		return goal;
	}
	
	public void setGoal(char[] letters){
		goal = letters;
		return;
	}
	
	public String getWord(){
		return word;
	}
	
	public void setWord(String string){
		word = string;
		return;
	}
	
	public ArrayList<String> buildList(){
		return wordList;
	}
	
	public void setList(ArrayList<String> list){
		wordList = list;
		return;
	}
	
	public void load(String file) throws FileNotFoundException{
		String fileName = file;
		File loadFrom = new File(fileName);
		Scanner inputFile = new Scanner(loadFrom);
		
		while(inputFile.hasNext()){
			String nextWord = inputFile.nextLine();
			wordList.add(nextWord.trim());
		}
		inputFile.close();
		return;
	}
	
	public void chooseWord(){
		int size = wordList.size();
		int index;
		Random rand = new Random();
		index = rand.nextInt(size);
		word = wordList.get(index);
		return;
	}
	
	public char[] generateGoal(){
		word = word.toLowerCase();
		goal = word.toCharArray();
		return goal;
	}
	
	public void clearList() {
		wordList.clear();
		return;
	}
}
