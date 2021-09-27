package symbolTable;

import ast.Type.Type;

import java.util.ArrayList;

public class SymbolTableMethodItem extends SymbolTableItem {

    ArrayList<Type> argTypes = new ArrayList<>();
    private Type returnType ;

    public SymbolTableMethodItem(String name, ArrayList<Type> argTypes , Type returnType) {
        this.name = name;
        this.argTypes = argTypes;
        this.returnType = returnType;
    }

    public ArrayList<Type> getArgs(){
      return this.argTypes;
    }

    public Type getReturnType(){
      return this.returnType;
    }

    @Override
    public String getKey() {
        return name;
    }
}
