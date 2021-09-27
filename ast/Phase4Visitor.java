package ast;

import java.util.*;
import java.io.*;
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Phase4Visitor implements Visitor {

    ProgramSymbolTable programSymTable;
    Program program ;   // used in isSubType
    SymbolTable currentSymTable = null;   // used in identifier
    ClassDeclaration currentClassDeclaration = null;    // used in this
    FileWriter fr = null ;
    int label_index = 0 ;

    private String findTypeName(Type type){
      if(type instanceof IntType)
        return "I";
      else if(type instanceof BooleanType)
        return "Z";
      else if(type instanceof StringType)
        return "Ljava/lang/String;";
      else if(type instanceof ArrayType)
        return "[I";
      else
        return "L"+((UserDefinedType)(type)).getName().getName()+";";
    }

    public void visitProgram(Program program , ProgramSymbolTable symTable) {
      this.program = program ;
      this.programSymTable = symTable;
      File file = new File("UpModule.j");
      try {
          this.fr = new FileWriter(file);
          this.fr.write(".class public UpModule\n");
          this.fr.write(".super java/lang/Object \n");
          this.fr.write(".method public <init>()V\n");
          this.fr.write(".limit locals 1\n");
          this.fr.write(".limit stack 32\n");
          this.fr.write("aload_0\n");
          this.fr.write("invokespecial java/lang/Object/<init>()V\n");
          this.fr.write("return\n");
          this.fr.write(".end method\n");

          this.fr.write(".method public static main([Ljava/lang/String;)V\n");
          this.fr.write(".limit locals 1\n");
          this.fr.write(".limit stack 32\n");
          this.fr.write("new "+program.getMainClass().getName().getName()+"\n");
          this.fr.write("dup\n");
          this.fr.write("invokespecial "+program.getMainClass().getName().getName()+"/<init>()V\n");
          this.fr.write("invokevirtual "+program.getMainClass().getName().getName()+"/main()I\n");
          this.fr.write("pop\n");
          this.fr.write("return\n");
          this.fr.write(".end method\n");

      } catch (IOException e) {
          e.printStackTrace();
      }finally{
          //close resources
          try {
                this.fr.close();
              }
          catch (IOException e) {
                e.printStackTrace();
              }
      }
      this.currentSymTable = symTable.get(program.getMainClass().getName().getName());
      this.currentClassDeclaration = program.getMainClass() ;
      program.getMainClass().accept(this);
      for (ClassDeclaration classDec : program.getClasses()) {
        this.currentSymTable = symTable.get(classDec.getName().getName());
        this.currentClassDeclaration = classDec ;
        classDec.accept(this);
      }
    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {

      File file = new File(classDeclaration.getName().getName()+".j");
      this.label_index = 0;
      try {
          this.fr = new FileWriter(file);
          this.fr.write(".class public ");
          this.fr.write(classDeclaration.getName().getName());
          this.fr.write("\n");
          this.fr.write(".super ");
          if(classDeclaration.getParentName()==null)
            this.fr.write("java/lang/Object");
          else
            this.fr.write(classDeclaration.getParentName().getName());
          this.fr.write("\n");
          for(VarDeclaration varDec : classDeclaration.getVarDeclarations()) {
               this.fr.write(".field public ");
               this.fr.write(varDec.getIdentifier().getName());
               this.fr.write(" ");
               this.fr.write(findTypeName(varDec.getType()));
               this.fr.write("\n");
          }
          this.fr.write(".method public <init>()V\n");
          this.fr.write(".limit locals 1\n");
          this.fr.write(".limit stack 32\n");
          this.fr.write("aload_0\n");
          this.fr.write("invokespecial ");
          if(classDeclaration.getParentName()==null)
            this.fr.write("java/lang/Object/<init>()V\n");
          else
            this.fr.write(classDeclaration.getParentName().getName()+"/<init>()V\n");
          this.fr.write("return\n");
          this.fr.write(".end method\n");
          for(MethodDeclaration methodDec : classDeclaration.getMethodDeclarations()) {
            SymbolTable pre = this.currentSymTable ;
            this.currentSymTable = pre.getMethod(methodDec.getName().getName());
            methodDec.accept(this);
            this.currentSymTable = pre;
          }

      } catch (IOException e) {
          e.printStackTrace();
      }finally{
          //close resources
          try {
                this.fr.close();
              }
          catch (IOException e) {
                e.printStackTrace();
              }
        }
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
      try {
        this.fr.write(".method public ");
        this.fr.write(methodDeclaration.getName().getName());
        this.fr.write("(");
        for(VarDeclaration argDec : methodDeclaration.getArgs()) {
            this.fr.write(findTypeName(argDec.getType()));
        }
        this.fr.write(")");
        if(methodDeclaration.getReturnType()!=null)
          this.fr.write(findTypeName(methodDeclaration.getReturnType()));
        else
          this.fr.write("V");
        this.fr.write("\n");
        this.fr.write(".limit locals ");
        this.fr.write(""+(currentSymTable.getItems().size()+1));
        this.fr.write("\n");
        this.fr.write(".limit stack 32\n");
        for(Statement stmt : methodDeclaration.getBody()) {
            stmt.accept(this);
        }
        methodDeclaration.getReturnValue().accept(this);
        if(methodDeclaration.getReturnType() instanceof IntType || methodDeclaration.getReturnType() instanceof BooleanType)
          this.fr.write("ireturn\n");
        else
          this.fr.write("areturn\n");
        this.fr.write(".end method\n");
      }
      catch (IOException e) {
          e.printStackTrace();
      }
    }

    @Override
    public void visit(NewArray newArray) {
        // newArray.setType(new ArrayType());
        try {
          this.fr.write("bipush "+newArray.getArrayIndex().getConstant()+"\n");
          this.fr.write("newarray int\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
        try{
          this.fr.write("iaload\n");
        }
        catch(IOException e){
          return;
        }
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        // binaryExpression.getLeft().accept(this);
        // binaryExpression.getRight().accept(this);
        if(binaryExpression.getBinaryOperator() == BinaryOperator.or){
          try{
            int label_index = this.label_index;
            this.label_index += 1;
            binaryExpression.getLeft().accept(this);
            this.fr.write("ifeq nElse"+label_index+"\n");
            this.fr.write("iconst_1\ngoto nExit"+label_index+"\n");
            this.fr.write("nElse"+label_index+":\n");
            binaryExpression.getRight().accept(this);
            this.fr.write("nExit"+label_index+":\n");
          }
          catch(IOException e){
            return;
          }
        }
        else if (binaryExpression.getBinaryOperator() == BinaryOperator.and){
          try{
            int label_index = this.label_index;
            this.label_index += 1;
            binaryExpression.getLeft().accept(this);
            this.fr.write("ifeq nElse"+label_index+"\n");
            binaryExpression.getRight().accept(this);
            this.fr.write("goto nExit"+label_index+"\n");
            this.fr.write("nElse"+label_index+":\n");
            this.fr.write("iconst_0\n");
            this.fr.write("nExit"+label_index+":\n");
          }
          catch(IOException e){
            return;
          }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.eq){
          if(binaryExpression.getLeft().getType() instanceof IntType || binaryExpression.getLeft().getType() instanceof BooleanType){
            binaryExpression.getLeft().accept(this);
            binaryExpression.getRight().accept(this);
            try{
              int label_index = this.label_index;
              this.label_index += 1;
              this.fr.write("if_icmpeq nElse"+label_index+"\n");
              this.fr.write("iconst_0\ngoto nExit"+label_index+"\n");
              this.fr.write("nElse"+label_index+":\n");
              this.fr.write("iconst_1\n");
              this.fr.write("nExit"+label_index+":\n");
            }
            catch(IOException e){
              return;
            }
          }
          else if(binaryExpression.getLeft().getType() instanceof UserDefinedType || binaryExpression.getLeft().getType() instanceof StringType){
            binaryExpression.getLeft().accept(this);
            binaryExpression.getRight().accept(this);
            try{
              this.fr.write("invokevirtual java/lang/Object/Equals(Ljava/lang/Object;)Z\n");
              int label_index = this.label_index;
              this.label_index += 1;
              this.fr.write("ifeq nElse"+label_index+"\n");
              this.fr.write("iconst_0\ngoto nExit"+label_index+"\n");
              this.fr.write("nElse"+label_index+":\n");
              this.fr.write("iconst_1\n");
              this.fr.write("nExit"+label_index+":\n");
            }
            catch(IOException e){
              return;
            }
          }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.neq){
          if(binaryExpression.getLeft().getType() instanceof IntType || binaryExpression.getLeft().getType() instanceof BooleanType){
            binaryExpression.getLeft().accept(this);
            binaryExpression.getRight().accept(this);
            try{
              int label_index = this.label_index;
              this.label_index += 1;
              this.fr.write("if_icmpne nElse"+label_index+"\n");
              this.fr.write("iconst_0\ngoto nExit"+label_index+"\n");
              this.fr.write("nElse"+label_index+":\n");
              this.fr.write("iconst_1\n");
              this.fr.write("nExit"+label_index+":\n");
            }
            catch(IOException e){
              return;
            }
          }
          else if(binaryExpression.getLeft().getType() instanceof UserDefinedType || binaryExpression.getLeft().getType() instanceof StringType){
            binaryExpression.getLeft().accept(this);
            binaryExpression.getRight().accept(this);
            try{
              this.fr.write("invokevirtual java/lang/Object/Equals(Ljava/lang/Object;)Z\n");
              int label_index = this.label_index;
              this.label_index += 1;
              this.fr.write("ifne nElse"+label_index+"\n");
              this.fr.write("iconst_0\ngoto nExit"+label_index+"\n");
              this.fr.write("nElse"+label_index+":\n");
              this.fr.write("iconst_1\n");
              this.fr.write("nExit"+label_index+":\n");
            }
            catch(IOException e){
              return;
            }
          }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.assign){
          if(binaryExpression.getLeft() instanceof Identifier){
            Identifier identifier = ((Identifier)(binaryExpression.getLeft()));
            try{
              if(this.currentSymTable.getInCurrentScope(identifier.getName()) != null){
                if(this.currentSymTable.getInCurrentScope(identifier.getName()) instanceof SymbolTableVariableItem){
                  binaryExpression.getRight().accept(this);
                  this.fr.write("dup\n");
                  SymbolTableVariableItem i = ((SymbolTableVariableItem)(this.currentSymTable.getInCurrentScope(identifier.getName())));
                  if(identifier.getType() instanceof IntType || identifier.getType() instanceof BooleanType)
                    this.fr.write("istore_"+i.getIndex()+"\n");
                  else{
                    this.fr.write("astore_"+i.getIndex()+"\n");
                  }
                }
              }
                else if (this.currentSymTable.getPreSymbolTable().getInCurrentScope(identifier.getName()) != null){
                  if(this.currentSymTable.getPreSymbolTable().getInCurrentScope(identifier.getName()) instanceof SymbolTableVariableItem){
                    SymbolTableVariableItem i = ((SymbolTableVariableItem)(this.currentSymTable.getPreSymbolTable().getInCurrentScope(identifier.getName())));
                    binaryExpression.getRight().accept(this);
                    this.fr.write("dup\n");
                    this.fr.write("aload_0\n");
                    this.fr.write("swap\n");
                    identifier.getType();
                    this.fr.write("putfield ");
                    this.fr.write(currentClassDeclaration.getName().getName());
                    this.fr.write("/");
                    this.fr.write(identifier.getName());
                    this.fr.write(" " + findTypeName(i.getType()));
                    this.fr.write("\n");
                    //this.fr.write("//this part is for duplication\n");
                    //binaryExpression.getRight().accept(this);
                    //this.fr.write("//this part is for duplication\n");
                  }
                }
            }
            catch(Exception e){
              System.out.println("Error");
              return;
            }
          }
          else if(binaryExpression.getLeft() instanceof ArrayCall){
            ArrayCall arrayCall = ((ArrayCall)(binaryExpression.getLeft()));
            try{
              binaryExpression.getRight().accept(this);
              this.fr.write("dup\n");
              arrayCall.getInstance().accept(this);
              this.fr.write("swap\n");
              arrayCall.getIndex().accept(this);
              this.fr.write("swap\n");
              this.fr.write("iastore\n");
              //this.fr.write("//this part is for duplication\n");
              //binaryExpression.getRight().accept(this);
              //this.fr.write("//this part is for duplication\n");
            }
            catch(IOException e){
              return;
            }
          }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.lt){
          binaryExpression.getLeft().accept(this);
          binaryExpression.getRight().accept(this);
          try{
            int label_index = this.label_index;
            this.label_index += 1;
            this.fr.write("if_icmplt nElse"+label_index+"\n");
            this.fr.write("iconst_0\ngoto nExit"+label_index+"\n");
            this.fr.write("nElse"+label_index+":\n");
            this.fr.write("iconst_1\n");
            this.fr.write("nExit"+label_index+":\n");
          }
          catch(IOException e){
            return;
          }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.gt){
          binaryExpression.getLeft().accept(this);
          binaryExpression.getRight().accept(this);
          try{
            int label_index = this.label_index;
            this.label_index += 1;
            this.fr.write("if_icmpgt nElse"+label_index+"\n");
            this.fr.write("iconst_0\ngoto nExit"+label_index+"\n");
            this.fr.write("nElse"+label_index+":\n");
            this.fr.write("iconst_1\n");
            this.fr.write("nExit"+label_index+":\n");
          }
          catch(IOException e){
            return;
          }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.add){
          binaryExpression.getLeft().accept(this);
          binaryExpression.getRight().accept(this);
          try{
            this.fr.write("iadd\n");
          }
          catch(IOException e){
            return;
          }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.sub){
          binaryExpression.getLeft().accept(this);
          binaryExpression.getRight().accept(this);
          try{
            this.fr.write("isub\n");
          }
          catch(IOException e){
            return;
          }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.mult){
          binaryExpression.getLeft().accept(this);
          binaryExpression.getRight().accept(this);
          try{
            this.fr.write("imult\n");
          }
          catch(IOException e){
            return;
          }
        }
        else if(binaryExpression.getBinaryOperator() == BinaryOperator.div){
          binaryExpression.getLeft().accept(this);
          binaryExpression.getRight().accept(this);
          try{
            this.fr.write("idiv\n");
          }
          catch(IOException e){
            return;
          }
        }
    }

    @Override
    public void visit(Identifier identifier) {
      try{
        if(this.currentSymTable.getInCurrentScope(identifier.getName()) != null){
          if(this.currentSymTable.getInCurrentScope(identifier.getName()) instanceof SymbolTableVariableItem){
            SymbolTableVariableItem i = ((SymbolTableVariableItem)(this.currentSymTable.getInCurrentScope(identifier.getName())));
            if(identifier.getType() instanceof IntType || identifier.getType() instanceof BooleanType)
              this.fr.write("iload_"+i.getIndex()+"\n");
            else{
              this.fr.write("aload_"+i.getIndex()+"\n");
            }
          }
        }
        else if (this.currentSymTable.getPreSymbolTable().getInCurrentScope(identifier.getName()) != null){
          if(this.currentSymTable.getPreSymbolTable().getInCurrentScope(identifier.getName()) instanceof SymbolTableVariableItem){
            SymbolTableVariableItem i = ((SymbolTableVariableItem)(this.currentSymTable.getPreSymbolTable().getInCurrentScope(identifier.getName())));
            this.fr.write("aload_0\n");
            identifier.getType();
            this.fr.write("getfield ");
            this.fr.write(currentClassDeclaration.getName().getName());
            this.fr.write("/");
            this.fr.write(identifier.getName());
            this.fr.write(" " + findTypeName(i.getType()));
            this.fr.write("\n");
          }
        }
      }
      catch(Exception e){
        return;
      }
    }

    @Override
    public void visit(Length length) {
        length.getExpression().accept(this);
        try{
          this.fr.write("arraylength\n");
        }
        catch(IOException e){
          return;
        }
    }

    @Override
    public void visit(MethodCall methodCall) {
        methodCall.getInstance().accept(this);
        for(Expression exp : methodCall.getArgs()){
          exp.accept(this);
        }
        SymbolTable calledClass = null ;
        try{
          calledClass = this.programSymTable.get( ((UserDefinedType)(methodCall.getInstance().getType())).getName().getName());
        }
        catch(Exception e){
          System.out.println("Error");
          return;
        }
        SymbolTableMethodItem calledMethod ;
        try{
          calledMethod = (SymbolTableMethodItem)(calledClass.get(methodCall.getMethodName().getName()));
        }
        catch(ItemNotFoundException e){
          System.out.println("Error");
          return;
        }
        try{
          this.fr.write("invokevirtual ");
          this.fr.write(((UserDefinedType)(methodCall.getInstance().getType())).getName().getName());
          this.fr.write("/");
          this.fr.write(methodCall.getMethodName().getName());
          this.fr.write("(");
          for(int i=0 ;i<calledMethod.getArgs().size();i++){
            this.fr.write(findTypeName(calledMethod.getArgs().get(i)));
          }
          this.fr.write(")");
          this.fr.write(findTypeName(calledMethod.getReturnType()));
          this.fr.write("\n");
        }
        catch(IOException e){
          System.out.println("Error");
          return;
        }
        //
        // if(methodCall.getArgs().size() != calledMethod.getArgs().size() && methodCall.getArgs().size()!=0){
        //   this.errors.add(new Error(new String("invalid argumants for method "+methodCall.getMethodName().getName()+" in class "+((UserDefinedType)(methodCall.getInstance().getType())).getName().getName()),methodCall.getLine()));
        //   methodCall.setType(null);
        //   return;
        // }
        // for(int i=0 ;i<methodCall.getArgs().size();i++){
        //   if(!this.isSubType(methodCall.getArgs().get(i).getType() , calledMethod.getArgs().get(i))) {
        //     this.errors.add(new Error(new String("invalid argumants for method "+methodCall.getMethodName().getName()+" in class "+((UserDefinedType)(methodCall.getInstance().getType())).getName().getName()),methodCall.getLine()));
        //     methodCall.setType(null);
        //     return;
        //   }
        // }
        // //System.out.println("type of method call set to " + calledMethod.getReturnType().toString());
        // methodCall.setType(calledMethod.getReturnType());
    }

    @Override
    public void visit(NewClass newClass) {
        try{
          this.fr.write("new "+newClass.getClassName().getName()+"\n");
          this.fr.write("dup\n");
          this.fr.write("invokespecial "+newClass.getClassName().getName()+"/<init>()V\n");
        }
        catch(IOException e){
          return;
        }
    }

    @Override
    public void visit(This instance) {
      try{
        this.fr.write("aload_0\n");
      }
      catch(IOException e){
        return;
      }
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        unaryExpression.getValue().accept(this);
        try{
          if(unaryExpression.getUnaryOperator() == UnaryOperator.not){
            int label_index = this.label_index;
            this.label_index += 1;
            this.fr.write("ifeq nElse"+label_index+"\n");
            this.fr.write("iconst_0\ngoto nExit"+label_index+"\n");
            this.fr.write("nElse"+label_index+":\n");
            this.fr.write("iconst_1\n");
            this.fr.write("nExit"+label_index+":\n");
          }
          else{
            this.fr.write("ineg\n");
          }
        }
        catch(IOException e){
          return;
        }
    }

    @Override
    public void visit(BooleanValue value) {
      try{
        if(value.isConstant())
          this.fr.write("iconst_1\n");
        else
          this.fr.write("iconst_0\n");
      }
      catch(IOException e){
        return;
      }
    }

    @Override
    public void visit(IntValue value) {
      try{
        this.fr.write("bipush "+value.getConstant()+"\n");
      }
      catch(IOException e){
        return;
      }
    }

    @Override
    public void visit(StringValue value) {
      try{
        this.fr.write("ldc "+value.getConstant()+"\n");
      }
      catch(IOException e){
        return;
      }
    }

    @Override
    public void visit(Assign assign) {
        assign.getlValue().accept(this);
        try{
          this.fr.write("pop\n");
        }
        catch(IOException e){
          return;
        }
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
        try{
            int label_index = this.label_index;
            this.label_index += 1;
            conditional.getExpression().accept(this);
            if(conditional.getAlternativeBody()!=null){
              this.fr.write("ifeq nElse"+label_index+"\n");
              conditional.getConsequenceBody().accept(this);
              this.fr.write("goto nAfter"+label_index+"\n");
              this.fr.write("nElse"+label_index+":\n");
              conditional.getAlternativeBody().accept(this);
            }
            else{
              this.fr.write("ifeq nAfter"+label_index+"\n");
              conditional.getConsequenceBody().accept(this);
            }
            this.fr.write("nAfter"+label_index+":\n");
        }
        catch(IOException e){
          return;
        }

    }

    @Override
    public void visit(While loop) {
      try{
          int label_index = this.label_index;
          this.label_index += 1;
          this.fr.write("nStart"+label_index+":\n");
          loop.getCondition().accept(this);
          this.fr.write("ifeq nExit"+label_index+"\n");
          loop.getBody().accept(this);
          this.fr.write("goto nStart"+label_index+"\n");
          this.fr.write("nExit"+label_index+":\n");
      }
      catch(IOException e){
        return;
      }
    }

    @Override
    public void visit(Write write) {
        try{
          this.fr.write("getstatic java/lang/System/out Ljava/io/PrintStream;\n");
          write.getArg().accept(this);
          if(write.getArg().getType() instanceof IntType)
            this.fr.write("invokevirtual java/io/PrintStream/print(I)V\n");
          else if (write.getArg().getType() instanceof StringType)
            this.fr.write("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n");
          else if (write.getArg().getType() instanceof UserDefinedType){
            UserDefinedType printObjectType = ((UserDefinedType)(write.getArg().getType()));
            this.fr.write("invokevirtual ");
            this.fr.write(printObjectType.getName().getName());
            this.fr.write("/");
            this.fr.write("toString()Ljava/lang/String;\n");
            this.fr.write("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n");
          }
          else if(write.getArg().getType() instanceof BooleanType){
            int label_index = this.label_index;
            this.label_index += 1;
            this.fr.write("ifeq nElse"+label_index+"\n");
            this.fr.write("ldc \"true\"\ngoto nExit"+label_index+"\n");
            this.fr.write("nElse"+label_index+":\n");
            this.fr.write("ldc \"false\"\n");
            this.fr.write("nExit"+label_index+":\n");
            this.fr.write("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n");
          }
          else if(write.getArg().getType() instanceof ArrayType){
            this.fr.write("new Tool\ndup\ninvokespecial Tool/<init>()V\nswap\ninvokevirtual Tool/print([I)I\npop\n");
          }
        }
        catch(IOException e){
          return;
        }
    }
}
