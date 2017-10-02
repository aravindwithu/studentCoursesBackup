package studentCoursesBackup.util;

//Header to import supporting classes.
import java.io.PrintWriter;
import java.util.ArrayList;

/*
* Results class.
* Created by Aravind Venkit for cs542 - Design patterns.
* Results class to process results of the test case.
* Implements FileDisplayInterface and StdoutDisplayInterface interfaces.
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private ArrayList<String> resultArray = new ArrayList<String>();// string array to store results.
	private PrintWriter writer;// writer object to write to file.
	/*
	* Results constructor to intialize Results class.
	* Calls intializeArray.
	*/
	public Results(){
		intializeArray();
	}
	/*
	* intializeArray method.
	* intializes resultArray with empty string.
	*/
	private void intializeArray(){
		for(int i=0; i < resultArray.size(); i++){
			resultArray.set(i, "");
		}
	}
	/*
	* storeNewResult method.
	* Requires 2 arguments 1 -> index, 2 -> value.
	* Stores the given value in given index.
	*/
	public void storeNewResult(String value){
		resultArray.add(value);
	}
	/*
	* printAll method.
	* prints all the values in resultArray to command line.
	*/
	public void printAll(){
		for(int i = 0; i < resultArray.size(); i++){
			writeToStdout(resultArray.get(i));
		}
	}
	/*
	* writeAll method.
	* writes all the values in resultArray to output file.
	*/
	public void writeAll(PrintWriter writer_in){
		writer = writer_in;
		for(int i = 0; i < resultArray.size(); i++){
			writeToFile(resultArray.get(i));
		}
	}
	/*
	* writeToStdout method.
	* Implements StdoutDisplayInterface writeToStdout method.
	* gets String s as argument.
	* prints the given string to command line.
	*/
	public void writeToStdout(String s){
		System.out.println(s);
	}
	/*
	* writeToFile method.
	* Implements FileDisplayInterface writeToFile method.
	* gets String s as argument.
	* writes the given string to output file.
	*/
	public void writeToFile(String s){
			writer.println(s);
	}
}