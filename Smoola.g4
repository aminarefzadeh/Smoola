grammar Smoola;

@header{
    import ast.node.*;
    import ast.node.declaration.*;
    import ast.node.expression.*;
    import ast.node.expression.Value.*;
    import ast.node.statement.*;
    import ast.Type.*;
    import ast.Type.ArrayType.*;
    import ast.Type.PrimitiveType.*;
    import ast.Type.UserDefinedType.*;
}

program returns [Program p]:
    { $p = new Program(); }
    mainClass {
        $p.setMainClass($mainClass.cd);
    }
    (classDeclaration {
        $p.addClass($classDeclaration.cd);
    })*
    EOF
;

mainClass returns [ClassDeclaration cd]:
    'class' identifier { $cd = new ClassDeclaration($identifier.id,null); } '{'
        'def' identifier {
            MethodDeclaration md = new MethodDeclaration($identifier.id);
            md.setReturnType(new IntType());
        } '(' ')' ':' 'int' '{'
            (statement { md.addStatement($statement.s); } )*
            l='return' expression { md.setReturnValue($expression.e); md.setReturnLine($l.getLine()); } ';'
        '}'
        { $cd.addMethodDeclaration(md); }
    '}'
;

classDeclaration returns [ClassDeclaration cd]:
    'class' name = identifier ('extends' identifier { $cd = new ClassDeclaration($name.id,$identifier.id); } | { $cd = new ClassDeclaration($name.id,null); })
    '{'
        (varDeclaration { $cd.addVarDeclaration($varDeclaration.vd); } )*
        (methodDeclaration { $cd.addMethodDeclaration($methodDeclaration.md); } )*
    '}'
;

varDeclaration returns [VarDeclaration vd]:
    'var' identifier ':' type ';' { $vd = new VarDeclaration($identifier.id, $type.t); }
;

methodDeclaration returns [MethodDeclaration md]:
    'def' identifier { $md = new MethodDeclaration($identifier.id); } (
        '(' ')' |
        ('(' identifier ':' type {
            $md.addArg(new VarDeclaration($identifier.id, $type.t));
        } (',' identifier ':' type {
            $md.addArg(new VarDeclaration($identifier.id, $type.t));
        })* ')')
    )
    ':' type { $md.setReturnType($type.t); } '{'
        (varDeclaration { $md.addLocalVar($varDeclaration.vd); } )*
        (statement { $md.addStatement($statement.s); } )*
        l='return' expression { $md.setReturnValue($expression.e); $md.setReturnLine($l.getLine());} ';'
    '}'
;

statement returns [Statement s] :
    statementBlock { $s = $statementBlock.sBlock; } |
    statementCondition { $s = $statementCondition.sCond; } |
    statementLoop { $s = $statementLoop.sLoop; } |
    statementWrite { $s = $statementWrite.sWr; } |
    statementAssignment { $s = $statementAssignment.sAssign; }
;

statementBlock returns [Block sBlock]:
    { $sBlock = new Block(); }
    '{' (statement { $sBlock.addStatement($statement.s); })* '}'
;

statementCondition returns [Conditional sCond]:
    'if' l='('expression')' 'then' statement { $sCond = new Conditional($expression.e, $statement.s); $sCond.setLine($l.getLine());}
    ('else' statement { $sCond.setAlternativeBody($statement.s); } )?
;

statementLoop returns [While sLoop]:
    'while' l='(' expression ')' statement { $sLoop = new While($expression.e, $statement.s); $sLoop.setLine($l.getLine());}
;

statementWrite returns [Write sWr]:
    'writeln' l='(' expression ')' ';'{ $sWr = new Write($expression.e); $sWr.setLine($l.getLine());}
;

statementAssignment returns [Assign sAssign]:
    expression ';' { $sAssign = new Assign($expression.e); $sAssign.setLine($expression.e.getLine());}
;

expression returns [Expression e]:
    expressionAssignment {
        $e = $expressionAssignment.e;
    }
;

expressionAssignment returns [Expression e]
    : expressionOr l='=' expressionAssignment {
        $e = new BinaryExpression(
            $expressionOr.e,
            $expressionAssignment.e,
            BinaryOperator.assign
        );
        $e.setLine($l.getLine());
    }
    | expressionOr {
        $e = $expressionOr.e;
    }
;

expressionOr returns [Expression e]:
    expressionAnd expressionOrTemp {
        if ($expressionOrTemp.e == null) {
            $e = $expressionAnd.e;
        }
        else {
            $e = new BinaryExpression(
                $expressionAnd.e,
                $expressionOrTemp.e,
                BinaryOperator.or
            );
            $e.setLine($expressionOrTemp.line);
        }
    }
;

expressionOrTemp returns [Expression e , int line]
    : l='||' expressionAnd expressionOrTemp {
        $line = $l.getLine();
        if ($expressionOrTemp.e == null) {
            $e = $expressionAnd.e;
        }
        else {
            $e = new BinaryExpression(
                $expressionAnd.e,
                $expressionOrTemp.e,
                BinaryOperator.or
            );
            $e.setLine($expressionOrTemp.line);
        }
    }
    | { $e = null; $line = -1;}
;

expressionAnd returns [Expression e]:
    expressionEq expressionAndTemp {
        if ($expressionAndTemp.e == null) {
            $e = $expressionEq.e;
        }
        else {
            $e = new BinaryExpression(
                $expressionEq.e,
                $expressionAndTemp.e,
                BinaryOperator.and
            );
            $e.setLine($expressionAndTemp.line);
        }
    }
;

expressionAndTemp returns [Expression e , int line]
    : l='&&' expressionEq expressionAndTemp {
        $line = $l.getLine();
        if ($expressionAndTemp.e == null) {
            $e = $expressionEq.e;
        }
        else {
            $e = new BinaryExpression(
                $expressionEq.e,
                $expressionAndTemp.e,
                BinaryOperator.and
            );
            $e.setLine($expressionAndTemp.line);
        }
    }
    | { $e = null; $line = -1; }
;

expressionEq returns [Expression e]:
    expressionCmp expressionEqTemp {
        if ($expressionEqTemp.e == null) {
            $e = $expressionCmp.e;
        }
        else {
            $e = new BinaryExpression(
                $expressionCmp.e,
                $expressionEqTemp.e,
                $expressionEqTemp.o
            );
            $e.setLine($expressionEqTemp.line);
        }
    }
;

expressionEqTemp returns [Expression e, BinaryOperator o , int line]
    :
        ( l='==' { $o = BinaryOperator.eq; $line=$l.getLine();}
        | l='<>' { $o = BinaryOperator.neq; $line=$l.getLine();})
        expressionCmp expressionEqTemp {
            if ($expressionEqTemp.e == null) {
                $e = $expressionCmp.e;
            }
            else {
                $e = new BinaryExpression(
                    $expressionCmp.e,
                    $expressionEqTemp.e,
                    $o
                );
                $e.setLine($expressionEqTemp.line);
            }
        }
    | { $e = null; $line=-1;}
;

expressionCmp returns [Expression e]:
    expressionAdd expressionCmpTemp {
        if ($expressionCmpTemp.e == null) {
            $e = $expressionAdd.e;
        }
        else {
            $e = new BinaryExpression(
                $expressionAdd.e,
                $expressionCmpTemp.e,
                $expressionCmpTemp.o
            );
            $e.setLine($expressionCmpTemp.line);
        }
    }
;

expressionCmpTemp returns [Expression e, BinaryOperator o, int line]
    :
        ( l='<' { $o = BinaryOperator.lt; $line=$l.getLine();}
        | l='>' { $o = BinaryOperator.gt; $line=$l.getLine();})
        expressionAdd expressionCmpTemp {
            if ($expressionCmpTemp.e == null) {
                $e = $expressionAdd.e;
            }
            else {
                $e = new BinaryExpression(
                    $expressionAdd.e,
                    $expressionCmpTemp.e,
                    $o
                );
                $e.setLine($expressionCmpTemp.line);
            }
        }
    | { $e = null; $line=-1;}
;

expressionAdd returns [Expression e]:
    expressionMult expressionAddTemp {
        if ($expressionAddTemp.e == null) {
            $e = $expressionMult.e;
        }
        else {
            $e = new BinaryExpression(
                $expressionMult.e,
                $expressionAddTemp.e,
                $expressionAddTemp.o
            );
            $e.setLine($expressionAddTemp.line);
        }
    }
;

expressionAddTemp returns [Expression e, BinaryOperator o, int line]
    :
        ( l='+' { $o = BinaryOperator.add; $line=$l.getLine();}
        | l='-' { $o = BinaryOperator.sub; $line=$l.getLine();})
        expressionMult expressionAddTemp {
            if ($expressionAddTemp.e == null) {
                $e = $expressionMult.e;
            }
            else {
                $e = new BinaryExpression(
                    $expressionMult.e,
                    $expressionAddTemp.e,
                    $o
                );
                $e.setLine($expressionAddTemp.line);
            }
        }
    | { $e = null; $line=-1;}
;

expressionMult returns [Expression e]:
    expressionUnary expressionMultTemp {
        if ($expressionMultTemp.e == null) {
            $e = $expressionUnary.e;
        }
        else {
            $e = new BinaryExpression(
                $expressionUnary.e,
                $expressionMultTemp.e,
                $expressionMultTemp.o
            );
            $e.setLine($expressionMultTemp.line);
        }
    }
;

expressionMultTemp returns [Expression e, BinaryOperator o, int line]
    :
        ( l='*' { $o = BinaryOperator.mult; $line=$l.getLine();}
        | l='/' { $o = BinaryOperator.div; $line=$l.getLine();})
        expressionUnary expressionMultTemp {
            if ($expressionMultTemp.e == null) {
                $e = $expressionUnary.e;
            }
            else {
                $e = new BinaryExpression(
                    $expressionUnary.e,
                    $expressionMultTemp.e,
                    $o
                );
                $e.setLine($expressionMultTemp.line);
            }
        }
    | { $e = null; $line=-1;}
;

expressionUnary returns [Expression e]
    :
        { UnaryOperator o; int line;}
        ( l='!' { o = UnaryOperator.not; line = $l.getLine();}
        | l='-' { o = UnaryOperator.minus; line = $l.getLine();}) expressionUnary {
            $e = new UnaryExpression(o, $expressionUnary.e);
            $e.setLine(line);
        }
    | expressionMem {
        $e = $expressionMem.e;
    }
;

expressionMem returns [Expression e]:
    expressionMethods expressionMemTemp {
        if ($expressionMemTemp.e == null) {
            $e = $expressionMethods.e;
        }
        else {
            $e = new ArrayCall(
                $expressionMethods.e,
                $expressionMemTemp.e
            );
        }
    }
;

expressionMemTemp returns [Expression e]
    : '[' expression ']' {
        $e = $expression.e;
    }
    | { $e = null; }
;

expressionMethods returns [Expression e]:
    expressionOther expressionMethodsTemp[$expressionOther.e] {
        if ($expressionMethodsTemp.mc == null) {
            $e = $expressionOther.e;
        }
        else {
            $e = $expressionMethodsTemp.mc;
        }
    }
;

expressionMethodsTemp [Expression instance] returns [Expression mc]
    : { $mc = new MethodCall($instance, new Identifier("")); } l='.' {$mc.setLine($l.getLine());}
        ( identifier { ((MethodCall)($mc)).setMethodName($identifier.id); } '(' ')'
        | identifier { ((MethodCall)($mc)).setMethodName($identifier.id); } '(' (expression { ((MethodCall)($mc)).addArg($expression.e); } (',' expression { ((MethodCall)($mc)).addArg($expression.e); })*) ')'
        | 'length' { $mc = new Length($instance); $mc.setLine($l.getLine()); })
        expressionMethodsTemp[$mc] {
            if ($expressionMethodsTemp.mc != null) {
                $mc = $expressionMethodsTemp.mc;
            }
        }
    | { $mc = null; }
;

expressionOther returns [Expression e]
    : CONST_NUM {
        $e = new IntValue(Integer.parseInt($CONST_NUM.getText()), new IntType());
    }
    | CONST_STR {
        $e = new StringValue($CONST_STR.getText(), new StringType());
    }
    | 'new ' l='int' '[' CONST_NUM ']' {
        $e = new NewArray(
            new IntValue(
                Integer.parseInt($CONST_NUM.getText()),
                new IntType()
                )
              );
              $e.setLine($l.getLine());
              ArrayType a = new ArrayType();
              a.setSize(Integer.parseInt($CONST_NUM.getText()));
              $e.setType(a);
    }
    | 'new ' identifier '(' ')' {
        $e = new NewClass($identifier.id);
    }
    | 'this' {
        $e = new This();
    }
    | 'true' {
        $e = new BooleanValue(true, new BooleanType());
    }
    | 'false' {
        $e = new BooleanValue(false, new BooleanType());
    }
    | identifier {
        $e = $identifier.id;
    }
    | identifier '[' expression ']' {
        $e = new ArrayCall(
            $identifier.id,
            $expression.e
        );
    }
    | '(' expression ')' {
        $e = $expression.e;
    }
;

type returns [Type t]
    : 'int' { $t = new IntType(); }
    | 'boolean' { $t = new BooleanType(); }
    | 'string' { $t = new StringType(); }
    | 'int' '[' ']' { $t = new ArrayType(); }
    | identifier { $t = new UserDefinedType(); ((UserDefinedType)($t)).setName($identifier.id);}
;

identifier returns [Identifier id]:
    ID { $id = new Identifier($ID.getText()); $id.setLine($ID.getLine());}
;

CONST_NUM:
    [0-9]+
;

CONST_STR:
    '"' ~('\r' | '\n' | '"')* '"'
;

NL:
    '\r'? '\n' -> skip
;

ID:
    [a-zA-Z_][a-zA-Z0-9_]*
;

COMMENT:
    '#'(~[\r\n])* -> skip
;

WS:
    [ \t] -> skip
;
