package ast;

import ast.node.Program;
import ast.node.declaration.ClassDeclaration;
import ast.node.declaration.MethodDeclaration;
import ast.node.declaration.VarDeclaration;
import ast.node.expression.*;
import ast.node.expression.Value.BooleanValue;
import ast.node.expression.Value.IntValue;
import ast.node.expression.Value.StringValue;
import ast.node.statement.*;

public class VisitorImpl implements Visitor {

    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public void visit(Program program) {
        print(program.toString());
        program.getMainClass().accept(this);
        for (ClassDeclaration classDec : program.getClasses()) {
            classDec.accept(this);
        }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        print(classDeclaration.toString());

        classDeclaration.getName().accept(this);
        if(classDeclaration.getParentName() != null) {
            classDeclaration.getParentName().accept(this);
        }
        for(VarDeclaration varDec : classDeclaration.getVarDeclarations()) {
            varDec.accept(this);
        }
        for(MethodDeclaration methodDec : classDeclaration.getMethodDeclarations()) {
            methodDec.accept(this);
        }
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        print(methodDeclaration.toString());

        methodDeclaration.getName().accept(this);

        for(VarDeclaration argDec : methodDeclaration.getArgs()) {
            argDec.accept(this);
        }
        for(VarDeclaration localVarDec : methodDeclaration.getLocalVars()) {
            localVarDec.accept(this);
        }
        for(Statement stmt : methodDeclaration.getBody()) {
            stmt.accept(this);
        }
        methodDeclaration.getReturnValue().accept(this);
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        print(varDeclaration.toString());

        varDeclaration.getIdentifier().accept(this);
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        print(arrayCall.toString());

        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        print(binaryExpression.toString());

        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
    }

    @Override
    public void visit(Identifier identifier) {
        print(identifier.toString());

    }

    @Override
    public void visit(Length length) {
        print(length.toString());
        length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {
        print(methodCall.toString());

        methodCall.getInstance().accept(this);
        methodCall.getMethodName().accept(this);
    }

    @Override
    public void visit(NewArray newArray) {
        print(newArray.toString());
        newArray.getArrayIndex().accept(this);
    }

    @Override
    public void visit(NewClass newClass) {
        print(newClass.toString());
        newClass.getClassName().accept(this);
      }

    @Override
    public void visit(This instance) {
        print(instance.toString());
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        print(unaryExpression.toString());
        unaryExpression.getValue().accept(this);
        }

    @Override
    public void visit(BooleanValue value) {
        print(value.toString());
    }

    @Override
    public void visit(IntValue value) {
        print(value.toString());
        }

    @Override
    public void visit(StringValue value) {
        print(value.toString());
        }

    @Override
    public void visit(Assign assign) {
        print(assign.toString());

        assign.getlValue().accept(this);
        assign.getrValue().accept(this);
        }

    @Override
    public void visit(Block block) {
        print(block.toString());
        for(Statement stms : block.getBody()) {
          stms.accept(this);
        }
    }

    @Override
    public void visit(Conditional conditional) {
        print(conditional.toString());
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {
        print(loop.toString());

        loop.getCondition().accept(this);
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {
        print(write.toString());

        write.getArg().accept(this);
    }
}
