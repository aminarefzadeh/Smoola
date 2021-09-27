package ast;

import java.util.*;
import ast.node.Program;
import ast.node.declaration.ClassDeclaration;
import ast.node.declaration.MethodDeclaration;
import ast.node.declaration.VarDeclaration;
import ast.node.expression.*;
import ast.node.expression.Value.BooleanValue;
import ast.node.expression.Value.IntValue;
import ast.node.expression.Value.StringValue;
import ast.node.statement.*;
import ast.Type.*;
import ast.Type.ArrayType.*;
import ast.Type.PrimitiveType.*;
import ast.Type.UserDefinedType.*;
import ast.Error;
import symbolTable.*;


public class Phase3Visitor implements Visitor {

    ArrayList<Error> errors = new ArrayList<Error>();
    ProgramSymbolTable programSymTable;
    Program program ;   // used in isSubType
    SymbolTable currentSymTable = null;   // used in identifier
    ClassDeclaration currentClassDeclaration = null;    // used in this

    private boolean isSubType(Type t1, Type t2){
      if(t1 == null || t2 == null)
        return true;

      else if (t1 instanceof StringType)
        return t2 instanceof StringType;

      else if (t1 instanceof IntType)
        return t2 instanceof IntType;

      else if (t1 instanceof BooleanType)
        return t2 instanceof BooleanType;

      else if (t1 instanceof ArrayType)
        return t2 instanceof ArrayType;

      else if (!(t2 instanceof UserDefinedType))
        return false;

      else{
        UserDefinedType tt1 = (UserDefinedType) t1;
        UserDefinedType tt2 = (UserDefinedType) t2;
        if(tt1.getClassDeclaration()==null || tt2.getClassDeclaration()==null)
          return true;
        if (tt1.getName().getName() == tt2.getName().getName())
          return true;
        else{
          Identifier parrentName = tt1.getClassDeclaration().getParentName();
          while(true){
            if (parrentName == null)
              return false;
            else{
              for (ClassDeclaration classDec : this.program.getClasses()){
                if (classDec.getName().getName() == parrentName.getName()){
                  if(classDec.getName().getName() == tt2.getName().getName())
                    return true;
                  parrentName = classDec.getParentName();
                  continue;
                }
              }
            }
          }
        }
      }
    }

    private void printErrors(){
      int n = this.errors.size();
      for (int i = 0; i < n-1; i++)
          for (int j = 0; j < n-i-1; j++)
              if (this.errors.get(j).getLine() > this.errors.get(j+1).getLine())
              {
                  // swap temp and arr[i]
                  Error temp = this.errors.get(j);
                  this.errors.set(j,this.errors.get(j+1));
                  this.errors.set(j+1,temp);
              }
      for (Error er : this.errors){
        System.out.println("line:"+er.getLine()+":"+er.getMessage());
      }
    }

    private String printBinaryOperator(BinaryOperator e1){
      if(e1 == BinaryOperator.add)
        return new String("+");
      if(e1 == BinaryOperator.sub)
        return new String("-");
      if(e1 == BinaryOperator.mult)
        return new String("*");
      if(e1 == BinaryOperator.div)
        return new String("/");
      if(e1 == BinaryOperator.and)
        return new String("&&");
      if(e1 == BinaryOperator.or)
        return new String("||");
      if(e1 == BinaryOperator.eq)
        return new String("==");
      if(e1 == BinaryOperator.neq)
        return new String("<>");
      if(e1 == BinaryOperator.lt)
        return new String("<");
      if(e1 == BinaryOperator.gt)
        return new String(">");
      if(e1 == BinaryOperator.assign)
        return new String("=");
      return new String("=");
    }

    private String printUnaryOperator(UnaryOperator e1){
      if(e1 == UnaryOperator.not)
        return "!";
      if(e1 == UnaryOperator.minus)
        return "-";
      return "-";
    }

    public boolean visitProgram(Program program , ProgramSymbolTable symTable) {
      this.program = program ;
      this.programSymTable = symTable;
      this.currentSymTable = symTable.get(program.getMainClass().getName().getName());
      this.currentClassDeclaration = program.getMainClass() ;
      program.getMainClass().accept(this);
      for (ClassDeclaration classDec : program.getClasses()) {
        this.currentSymTable = symTable.get(classDec.getName().getName());
        this.currentClassDeclaration = classDec ;
        classDec.accept(this);
      }
      if(this.errors.size()!=0){
        printErrors();
        return false;
      }
      return true;
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {

      // for(VarDeclaration varDec : classDeclaration.getVarDeclarations()) {
      //     varDec.accept(this);
      // }
      for(MethodDeclaration methodDec : classDeclaration.getMethodDeclarations()) {
        SymbolTable pre = this.currentSymTable ;
        this.currentSymTable = pre.getMethod(methodDec.getName().getName());
        methodDec.accept(this);
        this.currentSymTable = pre;
      }
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        // methodDeclaration.getName().accept(this);
        // for(VarDeclaration argDec : methodDeclaration.getArgs()) {
        //     argDec.accept(this);
        // }
        // for(VarDeclaration localVarDec : methodDeclaration.getLocalVars()) {
        //     localVarDec.accept(this);
        // }
        for(Statement stmt : methodDeclaration.getBody()) {
            stmt.accept(this);
        }
        methodDeclaration.getReturnValue().accept(this);
        if(!isSubType(methodDeclaration.getReturnValue().getType(),methodDeclaration.getReturnType())) {
          this.errors.add(new Error(new String(methodDeclaration.getName().getName()+" return type must be "+methodDeclaration.getReturnType().toString()),methodDeclaration.getReturnLine()));
        }
    }

    @Override
    public void visit(NewArray newArray) {
        newArray.setType(new ArrayType());
    }

    @Override
    public void visit(Program program) {
        return;
    }

    @Override
    public void visit(VarDeclaration varDeclaration) {
        // nothing to do
        return;
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
        if(!this.isSubType(arrayCall.getInstance().getType() , new ArrayType() )){
          arrayCall.setType(null);
        }
        else if(!this.isSubType(arrayCall.getIndex().getType() , new IntType())){
          arrayCall.setType(null);
        }
        else
          arrayCall.setType(new IntType());
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
        if(binaryExpression.getBinaryOperator() == BinaryOperator.or || binaryExpression.getBinaryOperator() == BinaryOperator.and){
          if(!this.isSubType(binaryExpression.getLeft().getType() , new BooleanType()) || !this.isSubType(binaryExpression.getRight().getType() , new BooleanType())){
            this.errors.add(new Error(new String("unsupported operand type for " + this.printBinaryOperator(binaryExpression.getBinaryOperator())),binaryExpression.getLine()));
            binaryExpression.setType(null);
          }
          else{
            binaryExpression.setType(new BooleanType());
          }
        }

        else if(binaryExpression.getBinaryOperator() == BinaryOperator.eq || binaryExpression.getBinaryOperator() == BinaryOperator.neq){
          if(!this.isSubType(binaryExpression.getLeft().getType() , binaryExpression.getRight().getType()) || !this.isSubType(binaryExpression.getRight().getType() , binaryExpression.getLeft().getType())) {
            this.errors.add(new Error(new String("unsupported operand type for " + this.printBinaryOperator(binaryExpression.getBinaryOperator())),binaryExpression.getLine()));
            binaryExpression.setType(null);
          }
          else
            binaryExpression.setType(new BooleanType());
        }

        else if(binaryExpression.getBinaryOperator() == BinaryOperator.assign){
          if(!(binaryExpression.getLeft() instanceof Identifier) && !(binaryExpression.getLeft() instanceof ArrayCall)){
            this.errors.add(new Error(new String("left side of assignment must be a valid lvalue"),binaryExpression.getLine()));
          }
          else if(!this.isSubType(binaryExpression.getRight().getType() , binaryExpression.getLeft().getType())) {
            this.errors.add(new Error(new String("right side of assignment must be a subtype"),binaryExpression.getLine()));
            binaryExpression.setType(null);
          }
          else{
            binaryExpression.setType(binaryExpression.getLeft().getType());
          }
        }

        else if(binaryExpression.getBinaryOperator() == BinaryOperator.lt || binaryExpression.getBinaryOperator() == BinaryOperator.gt){
          if(!this.isSubType(binaryExpression.getLeft().getType() , new IntType()) || !this.isSubType(binaryExpression.getRight().getType() , new IntType())){
            this.errors.add(new Error(new String("unsupported operand type for " + this.printBinaryOperator(binaryExpression.getBinaryOperator())),binaryExpression.getLine()));
            binaryExpression.setType(null);
          }
          else
            binaryExpression.setType(new BooleanType());
        }

        else{
          if(!this.isSubType(binaryExpression.getLeft().getType() , new IntType()) || !this.isSubType(binaryExpression.getRight().getType() , new IntType())){
            this.errors.add(new Error(new String("unsupported operand type for " + this.printBinaryOperator(binaryExpression.getBinaryOperator())),binaryExpression.getLine()));
            binaryExpression.setType(null);
          }
          else{
            binaryExpression.setType(new IntType());
          }
        }
    }

    @Override
    public void visit(Identifier identifier) {
      try{
        this.currentSymTable.get(identifier.getName());
        Type identifierType ;
        if(this.currentSymTable.get(identifier.getName()) instanceof SymbolTableVariableItem)
          identifierType = ((SymbolTableVariableItem)(this.currentSymTable.get(identifier.getName()))).getType();
        else
          identifierType = ((SymbolTableMethodItem)(this.currentSymTable.get(identifier.getName()))).getReturnType();
        identifier.setType(identifierType);
      }
      catch(ItemNotFoundException e){
        this.errors.add(new Error(new String("variable "+identifier.getName()+" is not declared"),identifier.getLine()));
        identifier.setType(null);
      }
    }

    @Override
    public void visit(Length length) {
        length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {
        methodCall.getInstance().accept(this);
        //methodCall.getMethodName().accept(this);
        for(Expression exp : methodCall.getArgs()){
          exp.accept(this);
        }
        SymbolTable calledClass ;
        if(methodCall.getInstance().getType() == null){
          methodCall.setType(null);
          return;
        }
        try{
          calledClass = this.programSymTable.get( ((UserDefinedType)(methodCall.getInstance().getType())).getName().getName());
        }
        catch(Exception e){
          this.errors.add(new Error(new String("undefined class"),methodCall.getLine()));
          methodCall.setType(null);
          return;
        }
        if(calledClass == null){
          this.errors.add(new Error(new String("class "+((UserDefinedType)(methodCall.getInstance().getType())).getName().getName()+" is not declared"),methodCall.getLine()));
          methodCall.setType(null);
          return;
        }
        SymbolTableMethodItem calledMethod ;
        try{
          calledMethod = (SymbolTableMethodItem)(calledClass.get(methodCall.getMethodName().getName()));
        }
        catch(ItemNotFoundException e){
          this.errors.add(new Error(new String("there is no method named "+methodCall.getMethodName().getName()+" in class "+((UserDefinedType)(methodCall.getInstance().getType())).getName().getName()),methodCall.getLine()));
          methodCall.setType(null);
          return;
        }

        if(methodCall.getArgs().size() != calledMethod.getArgs().size() && methodCall.getArgs().size()!=0){
          this.errors.add(new Error(new String("invalid argumants for method "+methodCall.getMethodName().getName()+" in class "+((UserDefinedType)(methodCall.getInstance().getType())).getName().getName()),methodCall.getLine()));
          methodCall.setType(null);
          return;
        }
        for(int i=0 ;i<methodCall.getArgs().size();i++){
          if(!this.isSubType(methodCall.getArgs().get(i).getType() , calledMethod.getArgs().get(i))) {
            this.errors.add(new Error(new String("invalid argumants for method "+methodCall.getMethodName().getName()+" in class "+((UserDefinedType)(methodCall.getInstance().getType())).getName().getName()),methodCall.getLine()));
            methodCall.setType(null);
            return;
          }
        }
        //System.out.println("type of method call set to " + calledMethod.getReturnType().toString());
        methodCall.setType(calledMethod.getReturnType());
    }

    @Override
    public void visit(NewClass newClass) {
        //newClass.getClassName().accept(this);
        //System.out.println("here2");
        UserDefinedType returnType = new UserDefinedType();
        returnType.setName(newClass.getClassName());
        returnType.setClassDeclaration(null);
        SymbolTable calledClass ;
        try{
          calledClass = this.programSymTable.get(newClass.getClassName().getName());
        }
        catch(Exception e){
          this.errors.add(new Error(new String("undefined class"),newClass.getClassName().getLine()));
          //System.out.println("error1");
          newClass.setType(returnType);
          return;
        }
        if(calledClass == null){
          this.errors.add(new Error(new String("class "+ newClass.getClassName().getName()+" is not declared"),newClass.getClassName().getLine()));
          //System.out.println("error2");
          newClass.setType(returnType);
          return;
        }
        for (ClassDeclaration cls : this.program.getClasses()){
          if (cls.getName().getName() == newClass.getClassName().getName()){
            returnType.setClassDeclaration(cls);
          }
        }
        newClass.setType(returnType);
    }

    @Override
    public void visit(This instance) {
      UserDefinedType thisClassType = new UserDefinedType() ;
      thisClassType.setClassDeclaration(this.currentClassDeclaration);
      thisClassType.setName(this.currentClassDeclaration.getName());
      instance.setType(thisClassType);
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        unaryExpression.getValue().accept(this);
        if(unaryExpression.getUnaryOperator() == UnaryOperator.not){
          if(!this.isSubType(unaryExpression.getValue().getType() , new BooleanType())){
            this.errors.add(new Error(new String("unsupported operand type for " + this.printUnaryOperator(unaryExpression.getUnaryOperator())),unaryExpression.getLine()));
            unaryExpression.setType(null);
          }
          else{
            unaryExpression.setType(new BooleanType());
          }
        }
        else{
          if(!this.isSubType(unaryExpression.getValue().getType() , new IntType())){
            this.errors.add(new Error(new String("unsupported operand type for " + this.printUnaryOperator(unaryExpression.getUnaryOperator())),unaryExpression.getLine()));
            unaryExpression.setType(null);
          }
          else{
            unaryExpression.setType(new IntType());
          }
        }
    }

    @Override
    public void visit(BooleanValue value) {
    }

    @Override
    public void visit(IntValue value) {
    }

    @Override
    public void visit(StringValue value) {
    }

    @Override
    public void visit(Assign assign) {
        assign.getlValue().accept(this);
        //assign.getrValue().accept(this);
        // if(!(assign.getlValue() instanceof Identifier) && !(assign.getlValue() instanceof ArrayCall)){
        //   this.errors.add(new Error(new String("left side of assignment must be a valid lvalue"),assign.getLine()));
        // }
        // else if(!this.isSubType(assign.getrValue().getType(),assign.getlValue().getType())){
        //   this.errors.add(new Error(new String("right side of assignment must be a subtype"),assign.getLine()));
        // }
    }

    @Override
    public void visit(Block block) {
      ArrayList<Statement> body = block.getBody();
        for(Statement stms : body) {
          stms.accept(this);
        }
    }

    @Override
    public void visit(Conditional conditional) {
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        if(conditional.getAlternativeBody()!=null)
          conditional.getAlternativeBody().accept(this);
        if(!this.isSubType(conditional.getExpression().getType() , new BooleanType())){
          this.errors.add(new Error(new String("condition type must be boolean"),conditional.getLine()));
        }
    }

    @Override
    public void visit(While loop) {
        loop.getCondition().accept(this);
        loop.getBody().accept(this);
        if(!this.isSubType(loop.getCondition().getType() , new BooleanType())){
          this.errors.add(new Error(new String("condition type must be boolean"),loop.getLine()));
        }
    }

    @Override
    public void visit(Write write) {
        write.getArg().accept(this);
        // if(!this.isSubType(write.getArg().getType() , new IntType()) && !this.isSubType(write.getArg().getType() , new StringType()) && !this.isSubType(write.getArg().getType() , new ArrayType())){
        //   this.errors.add(new Error(new String("unsupported type for writeln"),write.getLine()));
        // }
    }
}
