package symbolTable;

import java.util.*;

public class SymbolTable {

	SymbolTable pre;
	HashMap<String, SymbolTableItem> items;
	HashMap<String, SymbolTable> methods ;

	// Static members region

	//private static Stack<SymbolTable> stack = new Stack<SymbolTable>();

	// Use it in pass 1 scope start
	// public static void push(SymbolTable symbolTable) {
	// 	if(top != null)
	// 		stack.push(top);
	// 	top = symbolTable;
	// }

	// Use it in pass1 scope end
	// public static void pop() {
	// 	top = stack.pop();
	// }

	// End of static members region

	public SymbolTable(SymbolTable pre , HashMap<String, SymbolTableItem> items) {
		this.pre = pre;
		this.methods =  new HashMap<String, SymbolTable>() ;
		if(items==null){
			this.items = new HashMap<String, SymbolTableItem>();
		}
		else{
			this.items = items;
		}
	}

	public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
		if(items.containsKey(item.getKey()))
			throw new ItemAlreadyExistsException();
		items.put(item.getKey(), item);
	}

	public SymbolTableItem getInCurrentScope(String key) {
		return items.get(key);
	}



	public void putMethod(SymbolTable method , String name) {
		this.methods.put(name, method);
	}

	public SymbolTable getMethod(String name) {
		return this.methods.get(name);
	}

	public SymbolTableItem get(String key) throws ItemNotFoundException {
		SymbolTableItem value = items.get(key);
		if(value == null && pre != null)
			return pre.get(key);
		else if(value == null)
			throw new ItemNotFoundException();
		else
			return value;
	}



	public HashMap<String, SymbolTableItem> getItems(){
		return this.items;
	}

	public SymbolTable getPreSymbolTable() {
		return pre;
	}
}
