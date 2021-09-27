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
import ast.Error;
import symbolTable.*;

public class SymTableVisitor implements Visitor {

    ArrayList<Error> errors = new ArrayList<Error>();
    SymbolTable currentSymTable = null;
    int currentIndex = 0 ;
    public ProgramSymbolTable pst = new ProgramSymbolTable();

    private boolean sortClassInProgram(Program program){
      ArrayList<ClassDeclaration> classes = program.getClasses();
      ArrayList<String> className = new ArrayList<String>();
      ArrayList<Boolean> visited = new ArrayList<Boolean>();
      ArrayList<ClassDeclaration> sorted = new ArrayList<ClassDeclaration>();
      for (ClassDeclaration cls:classes){
        visited.add(Boolean.FALSE);
        className.add(cls.getName().getName());
      }
      for (int i=0;i<classes.size();i++){
        for (int j=0;j<classes.size();j++){
          if(!visited.get(j)){
            ClassDeclaration cls = classes.get(j);
            if (cls.getParentName()==null){
              sorted.add(cls);
              visited.set(j,Boolean.TRUE);
              break;
            }
            else{
              int parentIndex = -1;
              for(int k=0;k<classes.size();k++){
                if((classes.get(k).getName().getName().equals(cls.getParentName().getName()))&&(visited.get(k))){
                  parentIndex = k;
                  break;
                }
              }
              if(parentIndex!=-1){
                sorted.add(cls);
                visited.set(j,Boolean.TRUE);
                break;
              }
            }
          }
        }
      }
      if(sorted.size()!=classes.size()){
        System.out.println("errors in class dependency");
        //return false;
      }
      // else{
      program.setClasses(sorted);
      return true;
      //}
      //indexOf
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

    public boolean visitProgram(Program program) {
        if(sortClassInProgram(program)==false){
          return false;
        }
        HashMap<String, SymbolTableItem> initialItems = new HashMap<String, SymbolTableItem>();
        this.currentSymTable = new SymbolTable(null,initialItems);
        try{
          this.pst.put(this.currentSymTable,program.getMainClass().getName().getName());
        }
        catch(ItemAlreadyExistsException e){
          this.errors.add(new Error(new String("Redefinition of class "+program.getMainClass().getName().getName()),program.getMainClass().getName().getLine()));
        }
        program.getMainClass().accept(this);
        ArrayList<ClassDeclaration> classes = program.getClasses();
        int classSize = classes.size();
        for (int i=0 ; i<classSize ; i++){
          ClassDeclaration currentClass= classes.get(i);
          initialItems = new HashMap<String, SymbolTableItem>();
          if(currentClass.getParentName()!=null){
            SymbolTable parentClass = this.pst.getClasses().get(currentClass.getParentName().getName());
            initialItems.putAll(parentClass.getItems());
          }
          this.currentSymTable = new SymbolTable(null,initialItems);
          try{
            this.pst.put(this.currentSymTable,currentClass.getName().getName());
          }
          catch(ItemAlreadyExistsException e){
            this.errors.add(new Error(new String("Redefinition of class "+currentClass.getName().getName()),currentClass.getName().getLine()));
            Boolean flag=Boolean.TRUE;
            int postIndex = 1;
            String firstName = currentClass.getName().getName();
            while(flag){
              flag=Boolean.FALSE;
              currentClass.getName().setName("#Temporary_"+firstName+"_"+postIndex);
              try{
                this.pst.put(this.currentSymTable,currentClass.getName().getName());
              }
              catch(ItemAlreadyExistsException e1){
                flag=Boolean.TRUE;
              }
              postIndex+=1;
            }
          }
          currentClass.accept(this);
        }

        if(this.errors.size()!=0){
          printErrors();
          return false;
        }
        return true;

    }

    @Override
    public void visit(ClassDeclaration classDeclaration) {
        SymbolTable classSymTable = this.currentSymTable;
        ArrayList<VarDeclaration> vars = classDeclaration.getVarDeclarations();
        ArrayList<MethodDeclaration> mathods = classDeclaration.getMethodDeclarations();

        int maxSize = vars.size();
        for (int i=0 ; i<maxSize ; i++){
          VarDeclaration var= vars.get(i);
          try{
            classSymTable.put(new SymbolTableVariableItem(var.getIdentifier().getName(),var.getType(),0));
          }
          catch(ItemAlreadyExistsException e){
            this.errors.add(new Error(new String("Redefinition of variable "+var.getIdentifier().getName()),var.getIdentifier().getLine()));
            Boolean flag=Boolean.TRUE;
            int postIndex = 1;
            String firstName = var.getIdentifier().getName();
            while(flag){
              flag=Boolean.FALSE;
              var.getIdentifier().setName("#Temporary_"+firstName+"_"+postIndex);
              try{
                classSymTable.put(new SymbolTableVariableItem(var.getIdentifier().getName(),var.getType(),0));
              }
              catch(ItemAlreadyExistsException e1){
                flag=Boolean.TRUE;
              }
              postIndex+=1;
            }
          }
          var.accept(this);
        }

        maxSize = mathods.size();
        for (int i=0 ; i<maxSize ; i++){
          HashMap<String, SymbolTableItem> initialItems = new HashMap<String, SymbolTableItem>();
          MethodDeclaration item = mathods.get(i);
          this.currentSymTable = new SymbolTable(classSymTable,initialItems);
          ArrayList <Type> argsType = new ArrayList <Type>();
          for(int j=0 ; j<item.getArgs().size();j++){
            argsType.add(item.getArgs().get(j).getType());
          }

          try{
            SymbolTableMethodItem methodItem = new SymbolTableMethodItem(item.getName().getName() , argsType , item.getReturnType());
            classSymTable.put(methodItem);
          }
          catch(ItemAlreadyExistsException e){
            this.errors.add(new Error(new String("Redefinition of method "+item.getName().getName()),item.getName().getLine()));
            Boolean flag=Boolean.TRUE;
            int postIndex = 1;
            String firstName = item.getName().getName();
            while(flag){
              flag=Boolean.FALSE;
              item.getName().setName(new String("#Temporary_"+firstName+"_"+postIndex));
              try{
                SymbolTableMethodItem methodItem = new SymbolTableMethodItem(item.getName().getName() , argsType , item.getReturnType());
                classSymTable.put(methodItem);
              }
              catch(ItemAlreadyExistsException e1){
                flag=Boolean.TRUE;
              }
              postIndex+=1;
            }
          }
          // if(currentSymTable == null)
          //   System.out.println("fuck\n");
          // if(item.getName().getName() == null)
          //   System.out.println("fuck2\n");
          // if(classSymTable == null)
          //   System.out.println("fast _ hasfkldahjfklhahsfdkhlakshkdfhlahdslkfhakhrgfhailuzrlihwalihrfahseoorhsxfo\n");
          // else
            classSymTable.putMethod(this.currentSymTable,item.getName().getName());
          item.accept(this);
          this.currentSymTable = classSymTable;
        }
      this.currentSymTable = classSymTable;
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration) {
        HashMap<String, SymbolTableItem> initialItems = new HashMap<String, SymbolTableItem>();

        int maxSize = methodDeclaration.getArgs().size();
        this.currentIndex = 1;
        for (int i=0 ; i<maxSize ; i++){
          VarDeclaration var= methodDeclaration.getArgs().get(i);
          try{
            this.currentSymTable.put(new SymbolTableVariableItem(var.getIdentifier().getName(),var.getType(),this.currentIndex++));
          }
          catch(ItemAlreadyExistsException e){
            this.errors.add(new Error(new String("Redefinition of variable "+var.getIdentifier().getName()),var.getIdentifier().getLine()));
            Boolean flag=Boolean.TRUE;
            int postIndex = 1;
            String firstName = var.getIdentifier().getName();
            while(flag){
              flag=Boolean.FALSE;
              var.getIdentifier().setName("#Temporary_"+firstName+"_"+postIndex);
              try{
                this.currentSymTable.put(new SymbolTableVariableItem(var.getIdentifier().getName(),var.getType(),this.currentIndex-1));
              }
              catch(ItemAlreadyExistsException e1){
                flag=Boolean.TRUE;
              }
              postIndex+=1;
            }
          }
          var.accept(this);
        }

        maxSize = methodDeclaration.getLocalVars().size();
        for (int i=0 ; i<maxSize ; i++){
          VarDeclaration var= methodDeclaration.getLocalVars().get(i);
          try{
            this.currentSymTable.put(new SymbolTableVariableItem(var.getIdentifier().getName(),var.getType(),this.currentIndex++));
          }
          catch(ItemAlreadyExistsException e){
            this.errors.add(new Error(new String("Redefinition of variable "+var.getIdentifier().getName()),var.getIdentifier().getLine()));
            Boolean flag=Boolean.TRUE;
            int postIndex = 1;
            String firstName = var.getIdentifier().getName();
            while(flag){
              flag=Boolean.FALSE;
              var.getIdentifier().setName("#Temporary_"+firstName+"_"+postIndex);
              try{
                this.currentSymTable.put(new SymbolTableVariableItem(var.getIdentifier().getName(),var.getType(),this.currentIndex-1));
              }
              catch(ItemAlreadyExistsException e1){
                flag=Boolean.TRUE;
              }
              postIndex+=1;
            }
          }
        }

        for(Statement stmt : methodDeclaration.getBody()) {
            stmt.accept(this);
        }
        methodDeclaration.getReturnValue().accept(this);
    }

    @Override
    public void visit(NewArray newArray) {
        if (newArray.getArrayIndex().getConstant()<=0){
          this.errors.add(new Error(new String("Array length should not be zero or negative"),newArray.getLine()));
        }
    }


    // --------------------------------------------------------- //


    @Override
    public void visit(Program program) {
        this.visitProgram(program);
    }


    @Override
    public void visit(VarDeclaration varDeclaration) {
        varDeclaration.getIdentifier().accept(this);
    }

    @Override
    public void visit(ArrayCall arrayCall) {
        arrayCall.getInstance().accept(this);
        arrayCall.getIndex().accept(this);
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
        //System.out.println("binaryExpression at line "+binaryExpression.getLine()+"\n");
    }

    @Override
    public void visit(Identifier identifier) {
    }

    @Override
    public void visit(Length length) {
        length.getExpression().accept(this);
    }

    @Override
    public void visit(MethodCall methodCall) {
        methodCall.getInstance().accept(this);
        methodCall.getMethodName().accept(this);
    }


    @Override
    public void visit(NewClass newClass) {
        newClass.getClassName().accept(this);
    }

    @Override
    public void visit(This instance) {
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        unaryExpression.getValue().accept(this);
        //System.out.println("unaryExpression at line "+unaryExpression.getLine()+"\n");
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
    }

    @Override
    public void visit(Block block) {
        for(Statement stms : block.getBody()) {
          stms.accept(this);
        }
    }

    @Override
    public void visit(Conditional conditional) {
        conditional.getExpression().accept(this);
        conditional.getConsequenceBody().accept(this);
        if(conditional.getAlternativeBody()!=null)
          conditional.getAlternativeBody().accept(this);
    }

    @Override
    public void visit(While loop) {
        loop.getCondition().accept(this);
        loop.getBody().accept(this);
    }

    @Override
    public void visit(Write write) {
        write.getArg().accept(this);
    }
}
