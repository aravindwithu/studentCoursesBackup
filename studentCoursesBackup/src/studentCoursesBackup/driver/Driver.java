package studentCoursesBackup.driver;

//Header to import supporting classes.
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.FileProcessor;
import java.io.PrintWriter;

/**
* Driver class contains main method.
* Created for cs542 - Design patterns, Assignment 2.
* To create a observer pattern based on BST tree data structure.
* @author Aravind Venkit
*/
public class Driver 
{
	public static void main(String[] args) 
	{
		// Object declared for TreeBuilder class.
	    TreeBuilder treeBuilder;
	    // Object declared for Results class (Original).
	    Results results_orig;
	   	// Object declared for Results class (Back up 1).
	    Results backup_results_1;
	    // Object declared for Results class (Back up 2).
	    Results backup_results_2;
	    // Object declared for FileProcessor class.
	    FileProcessor file;
	    // Object declared for PrintWriter class.
	    PrintWriter writer;

	    try{
	    	// command line validation for input file and output file respectively.
	    	String inputFile = "", deleteFile = "", output1File = "", output2File = "", output3File = "";
		    if(5 == args.length){// validates given arguments array length to 5.
		    	if(!args[0].equals("${arg0}")){// validates 1st input file argument value.
		    		inputFile = args[0];
		    	}
		    	else{
		    		throw new Exception("Please provide input file.");
		    	}

		    	if(!args[1].equals("${arg1}")){// validates 2nd delete file argument value.
					deleteFile = args[1];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[2].equals("${arg2}")){// validates 3rd output1 file argument value.
					output1File = args[2];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[3].equals("${arg3}")){// validates 4th output2 file argument value.
					output2File = args[3];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	if(!args[4].equals("${arg4}")){// validates 5th output3 file argument value.
					output3File = args[4];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}
		    }
		    else{
		    	throw new Exception("Please pass exactly 5 arguments one for input and another for output files.");
		    }

		    // Intiates the TreeBuilder class object
			treeBuilder = new TreeBuilder();
		    // Object intialized for FileProcessor with respective input file.
			file = new FileProcessor(inputFile);
			// The input values are read from file and stored treeBuilder object in BST format.
			String line;
		    while ((line = file.readLine(true)) != null)
		    {
		    	// Read line is split into array of string based on '":" charecter.
		    	String[] lineValues = line.split(":");
		    	int bNumberValue = 0; // bNumber declared and intiated to 0.
		    	try{
		    		bNumberValue =  Integer.parseInt(lineValues[0]);
		    	}
		    	catch(Exception ex){// To catch the in parse invalid error.
		    		throw new Exception("Invalid Bnumber: "+ line +", Please provide valid 4 digit Bnumber.");
		    	}

		    	// To validate the given bnumber is of 4 digits.
		    	if(String.valueOf(bNumberValue).length() != 4){
		    		throw new Exception("Invalid Bnumber: "+ line +", Please provide valid 4 digit Bnumber.");
		    	}
		 	
		 		// To validate the given Course is valid and not empty.
		    	if(lineValues.length != 2){
		    		throw new Exception("Invalid Course: "+ line +", Please provide valid Course.");
		    	}

		    	// Course from read line is assigned courseValue variable.
		    	String courseValue = lineValues[1];

		    	// To validate the given Course is of single charecter.
		    	if(courseValue.length() !=1){
		    		throw new Exception("Invalid Course: "+ line +", Please provide valid Course of single charecter from A to K.");
		    	}

		    	// To validate the given Course is with in range of A to K.
		    	int courseASCII = (int)courseValue.charAt(0);
		    	if(65>courseASCII || 75<courseASCII){
		    		throw new Exception("Invalid Course: "+ line +", Please provide valid Course of single charecter from A to K.");
		    	}

		    	// insertNode from TreeBuilder class is called using treeBuilder object.
		    	treeBuilder.insertNode(bNumberValue, courseValue);
		    }
		    // closes the file reader.
		    file.readLine(false);

		    // file object is cleared and re-intialized to import delete file.
		    file =  null;
		    file = new FileProcessor(deleteFile);
			// The input values are read from file and stored in my array list.
			line = "";
		    while ((line = file.readLine(true)) != null)
		    {
		    	// Read line is split into array of string based on '":" charecter.
		    	String[] lineValues = line.split(":");
		    	int bNumberValue = 0; // bNumber declared and intiated to 0.
		    	try{
		    		bNumberValue =  Integer.parseInt(lineValues[0]);
		    	}
		    	catch(Exception ex){// To catch the in parse invalid error.
		    		throw new Exception("Invalid Bnumber: "+ line +", Please provide valid 4 digit Bnumber.");
		    	}

		    	// To validate the given bnumber is of 4 digits.
		    	if(String.valueOf(bNumberValue).length() != 4){
		    		throw new Exception("Invalid Bnumber: "+ line +", Please provide valid 4 digit Bnumber.");
		    	}
		 	
		 		// To validate the given Course is valid and not empty.
		    	if(lineValues.length != 2){
		    		throw new Exception("Invalid Course: "+ line +", Please provide valid Course.");
		    	}

		    	// Course from read line is assigned courseValue variable.
		    	String courseValue = lineValues[1];

		    	// To validate the given Course is of single charecter.
		    	if(courseValue.length() !=1){
		    		throw new Exception("Invalid Course: "+ line +", Please provide valid Course of single charecter from A to K.");
		    	}

		    	// To validate the given Course is with in range of A to K.
		    	int courseASCII = (int)courseValue.charAt(0);
		    	if(65>courseASCII || 75<courseASCII){
		    		throw new Exception("Invalid Course: "+ line +", Please provide valid Course of single charecter from A to K.");
		    	}

		    	// deleteNode from TreeBuilder class is called using treeBuilder object.
		    	treeBuilder.deleteNode(bNumberValue, courseValue);
		    }
		    // closes the file reader.
		    file.readLine(false);

		    // Object declared for Results class.
		    results_orig = new Results();
		   	// Object declared for Results class.
		    backup_results_1 = new Results();
		    // Object declared for Results class.
		    backup_results_2 = new Results();

		    treeBuilder.printNodes(results_orig, backup_results_1, backup_results_2);

		   	// Object for PrintWriter is intialized with respective output file name and encoding format.
		   	// To write original Tree to the output file.
		   	writer = new PrintWriter(output1File, "UTF-8");
		    // writeAll method from Results class is called with writer object to write the test case results to the output file.
		    results_orig.writeAll(writer);
		    // writer object is closed.
		    writer.close();

		    // To write backup 1 Tree to the output file.
		    writer = null;
		    // Object for PrintWriter is intialized with respective output file course and encoding format.
		   	writer = new PrintWriter(output2File, "UTF-8");
		    // writeAll method from Results class is called with writer object to write the test case results to the output file.
		    backup_results_1.writeAll(writer);
		    // writer object is closed.
		    writer.close();

		    // To write backup 2 Tree to the output file.
		   	writer = null;
		    // Object for PrintWriter is intialized with respective output file course and encoding format.
		   	writer = new PrintWriter(output3File, "UTF-8");
		    // writeAll method from Results class is called with writer object to write the test case results to the output file.
		    backup_results_2.writeAll(writer);
		    // writer object is closed.
		    writer.close();

		    System.out.println("Output files generated successfully.");
	    }
	    catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.
		    treeBuilder = null;
		    results_orig = null;
		    backup_results_1 = null;
		    backup_results_2 = null;
		    file = null;
		    writer = null;
	    }
	}
}