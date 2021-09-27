package symbolTable;

import java.util.*;
import symbolTable.SymbolTable;

public class ProgramSymbolTable {

	HashMap <String , SymbolTable> classes;

	public ProgramSymbolTable() {
		this.classes = new HashMap<String, SymbolTable>();
	}

	public HashMap <String , SymbolTable> getClasses(){
		return this.classes;
	}

	public void put(SymbolTable cls,String className) throws ItemAlreadyExistsException {
		if(classes.containsKey(className))
			throw new ItemAlreadyExistsException();
		classes.put(className, cls);
	}

	public SymbolTable get(String key) {
		return classes.get(key);
	}

}
