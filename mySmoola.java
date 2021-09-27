import ast.VisitorImpl;
import ast.SymTableVisitor;
import ast.Phase3Visitor;
import ast.Phase4Visitor;
import ast.node.Program;
import org.antlr.v4.runtime.*;
import java.io.IOException;
import symbolTable.ProgramSymbolTable;

// Visit https://stackoverflow.com/questions/26451636/how-do-i-use-antlr-generated-parser-and-lexer
public class mySmoola {
    public static void main(String[] args) throws IOException {
		    //System.out.println(args[0]);
        CharStream reader = CharStreams.fromFileName(args[0]);
        SmoolaLexer lexer = new SmoolaLexer(reader);   // SmoolaLexer in your project
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SmoolaParser parser = new SmoolaParser(tokens);   // SmoolaParser in your project
        Program p = parser.program().p; // program is the name of the start rule
        SymTableVisitor v1 = new SymTableVisitor();
        v1.visitProgram(p);
        ProgramSymbolTable pst = v1.pst;
        Phase3Visitor v2 = new Phase3Visitor();
        v2.visitProgram(p,pst);
        Phase4Visitor v3 = new Phase4Visitor();
        v3.visitProgram(p,pst);
    }
}
