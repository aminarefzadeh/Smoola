package ast.node.declaration;

import ast.Type.Type;
import ast.Visitor;
import ast.node.expression.Expression;
import ast.node.expression.Identifier;
import ast.node.statement.Statement;

import java.util.ArrayList;

public class MethodDeclaration extends Declaration {
    private Expression returnValue;
    private Type returnType;
    private Identifier name;
    private ArrayList<VarDeclaration> args = new ArrayList<>();
    private ArrayList<VarDeclaration> localVars = new ArrayList<>();
    private ArrayList<Statement> body = new ArrayList<>();
    private int returnLine;

    public int getReturnLine(){return this.returnLine;}
    public void setReturnLine(int newLine){this.returnLine = newLine;}

    public MethodDeclaration(Identifier name ) {
        this.name = name;
    }

    public Expression getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Expression returnValue) {
        this.returnValue = returnValue;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public Identifier getName() {
        return name;
    }

    public void setName(Identifier name) {
        this.name = name;
    }

    public ArrayList<VarDeclaration> getArgs() {
        return this.args;
    }

    public void addArg(VarDeclaration arg) {
        //System.println("adding args to method "+this.name.getName());
        this.args.add(arg);
    }

    public ArrayList<Statement> getBody() {
        return body;
    }

    public void addStatement(Statement statement) {
        this.body.add(statement);
    }

    public ArrayList<VarDeclaration> getLocalVars() {
        return localVars;
    }

    public void addLocalVar(VarDeclaration localVar) {
        this.localVars.add(localVar);
    }

    @Override
    public String toString() {
        return "MethodDeclaration";
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
