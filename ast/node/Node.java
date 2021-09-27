package ast.node;

import ast.Visitor;

public abstract class Node {
    protected int line = -1;
    public void accept(Visitor visitor) {}
    public void setLine(int line){this.line = line;}
    public int getLine(){return this.line;}
}
