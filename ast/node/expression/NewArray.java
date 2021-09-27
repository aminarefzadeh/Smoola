package ast.node.expression;

import ast.Visitor;
import ast.node.expression.Value.IntValue;

public class NewArray extends Expression {
    private IntValue arrayIndex;

    public NewArray (IntValue arrayIndex){
      this.arrayIndex = arrayIndex;
    }
    public IntValue getArrayIndex() {
        return arrayIndex;
    }

    public void setArrayIndex(IntValue arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    @Override
    public String toString() {
        return "NewArray";
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
