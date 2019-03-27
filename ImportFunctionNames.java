//Rename functions according to a predefined function list in text format
// Sample File:
//
// Line 1: "007225E0;FrameScript__GetLocalizedText"
// Line 2: "00819210;FrameScript__Execute"
// Line 3: "..."
// 
//@author Jannis Höschele
//@category Functions
//@keybinding 
//@menupath 
//@toolbar 

import ghidra.app.script.GhidraScript;
import ghidra.program.model.util.*;
import ghidra.program.model.reloc.*;
import ghidra.program.model.data.*;
import ghidra.program.model.block.*;
import ghidra.program.model.symbol.*;
import ghidra.program.model.scalar.*;
import ghidra.program.model.mem.*;
import ghidra.program.model.listing.*;
import ghidra.program.model.lang.*;
import ghidra.program.model.pcode.*;
import ghidra.program.model.address.*;
import java.io.*;

public class ImportFunctionNames extends GhidraScript {

    public void run() throws Exception {
        // Change FilePath here
	    File inputFile = new File("C:\\Users\\Administrator\\Desktop\\Cloud\\Projekte\\Wow-3.3.5a-Reversing\\Functions3.3.5a.txt");

	    FunctionManager functionManager = currentProgram.getFunctionManager();
	    AddressFactory addressFactory = currentProgram.getAddressFactory();

	    try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
    		String line;
    		while ((line = br.readLine()) != null) {
			    String[] splittedLine = line.split(";");
			    println("Address: " + splittedLine[0] + " FunctionName: " + splittedLine[1]);

			    Function activeFunction = functionManager.getFunctionAt(addressFactory.getAddress(splittedLine[0]));
			    if(activeFunction != null){
				    println("CurrentFunctionName: " + activeFunction.getName() + " FunctionName: " + splittedLine[1]);
				    activeFunction.setName(splittedLine[1], SourceType.USER_DEFINED);
			    }
    		}
	    }
    }
}