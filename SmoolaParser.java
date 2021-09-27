// Generated from Smoola.g4 by ANTLR 4.7.1

    import ast.node.*;
    import ast.node.declaration.*;
    import ast.node.expression.*;
    import ast.node.expression.Value.*;
    import ast.node.statement.*;
    import ast.Type.*;
    import ast.Type.ArrayType.*;
    import ast.Type.PrimitiveType.*;
    import ast.Type.UserDefinedType.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmoolaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, CONST_NUM=41, CONST_STR=42, NL=43, ID=44, COMMENT=45, 
		WS=46;
	public static final int
		RULE_program = 0, RULE_mainClass = 1, RULE_classDeclaration = 2, RULE_varDeclaration = 3, 
		RULE_methodDeclaration = 4, RULE_statement = 5, RULE_statementBlock = 6, 
		RULE_statementCondition = 7, RULE_statementLoop = 8, RULE_statementWrite = 9, 
		RULE_statementAssignment = 10, RULE_expression = 11, RULE_expressionAssignment = 12, 
		RULE_expressionOr = 13, RULE_expressionOrTemp = 14, RULE_expressionAnd = 15, 
		RULE_expressionAndTemp = 16, RULE_expressionEq = 17, RULE_expressionEqTemp = 18, 
		RULE_expressionCmp = 19, RULE_expressionCmpTemp = 20, RULE_expressionAdd = 21, 
		RULE_expressionAddTemp = 22, RULE_expressionMult = 23, RULE_expressionMultTemp = 24, 
		RULE_expressionUnary = 25, RULE_expressionMem = 26, RULE_expressionMemTemp = 27, 
		RULE_expressionMethods = 28, RULE_expressionMethodsTemp = 29, RULE_expressionOther = 30, 
		RULE_type = 31, RULE_identifier = 32;
	public static final String[] ruleNames = {
		"program", "mainClass", "classDeclaration", "varDeclaration", "methodDeclaration", 
		"statement", "statementBlock", "statementCondition", "statementLoop", 
		"statementWrite", "statementAssignment", "expression", "expressionAssignment", 
		"expressionOr", "expressionOrTemp", "expressionAnd", "expressionAndTemp", 
		"expressionEq", "expressionEqTemp", "expressionCmp", "expressionCmpTemp", 
		"expressionAdd", "expressionAddTemp", "expressionMult", "expressionMultTemp", 
		"expressionUnary", "expressionMem", "expressionMemTemp", "expressionMethods", 
		"expressionMethodsTemp", "expressionOther", "type", "identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'{'", "'def'", "'('", "')'", "':'", "'int'", "'return'", 
		"';'", "'}'", "'extends'", "'var'", "','", "'if'", "'then'", "'else'", 
		"'while'", "'writeln'", "'='", "'||'", "'&&'", "'=='", "'<>'", "'<'", 
		"'>'", "'+'", "'-'", "'*'", "'/'", "'!'", "'['", "']'", "'.'", "'length'", 
		"'new '", "'this'", "'true'", "'false'", "'boolean'", "'string'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "CONST_NUM", "CONST_STR", "NL", "ID", "COMMENT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Smoola.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmoolaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program p;
		public MainClassContext mainClass;
		public ClassDeclarationContext classDeclaration;
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SmoolaParser.EOF, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ProgramContext)_localctx).p =  new Program(); 
			setState(67);
			((ProgramContext)_localctx).mainClass = mainClass();

			        _localctx.p.setMainClass(((ProgramContext)_localctx).mainClass.cd);
			    
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(69);
				((ProgramContext)_localctx).classDeclaration = classDeclaration();

				        _localctx.p.addClass(((ProgramContext)_localctx).classDeclaration.cd);
				    
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainClassContext extends ParserRuleContext {
		public ClassDeclaration cd;
		public IdentifierContext identifier;
		public StatementContext statement;
		public Token l;
		public ExpressionContext expression;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterMainClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitMainClass(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__0);
			setState(80);
			((MainClassContext)_localctx).identifier = identifier();
			 ((MainClassContext)_localctx).cd =  new ClassDeclaration(((MainClassContext)_localctx).identifier.id,null); 
			setState(82);
			match(T__1);
			setState(83);
			match(T__2);
			setState(84);
			((MainClassContext)_localctx).identifier = identifier();

			            MethodDeclaration md = new MethodDeclaration(((MainClassContext)_localctx).identifier.id);
			            md.setReturnType(new IntType());
			        
			setState(86);
			match(T__3);
			setState(87);
			match(T__4);
			setState(88);
			match(T__5);
			setState(89);
			match(T__6);
			setState(90);
			match(T__1);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << CONST_NUM) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				{
				setState(91);
				((MainClassContext)_localctx).statement = statement();
				 md.addStatement(((MainClassContext)_localctx).statement.s); 
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			((MainClassContext)_localctx).l = match(T__7);
			setState(100);
			((MainClassContext)_localctx).expression = expression();
			 md.setReturnValue(((MainClassContext)_localctx).expression.e); md.setReturnLine(((MainClassContext)_localctx).l.getLine()); 
			setState(102);
			match(T__8);
			setState(103);
			match(T__9);
			 _localctx.cd.addMethodDeclaration(md); 
			setState(105);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public ClassDeclaration cd;
		public IdentifierContext name;
		public IdentifierContext identifier;
		public VarDeclarationContext varDeclaration;
		public MethodDeclarationContext methodDeclaration;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__0);
			setState(108);
			((ClassDeclarationContext)_localctx).name = ((ClassDeclarationContext)_localctx).identifier = identifier();
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(109);
				match(T__10);
				setState(110);
				((ClassDeclarationContext)_localctx).identifier = identifier();
				 ((ClassDeclarationContext)_localctx).cd =  new ClassDeclaration(((ClassDeclarationContext)_localctx).name.id,((ClassDeclarationContext)_localctx).identifier.id); 
				}
				break;
			case T__1:
				{
				 ((ClassDeclarationContext)_localctx).cd =  new ClassDeclaration(((ClassDeclarationContext)_localctx).name.id,null); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(116);
			match(T__1);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(117);
				((ClassDeclarationContext)_localctx).varDeclaration = varDeclaration();
				 _localctx.cd.addVarDeclaration(((ClassDeclarationContext)_localctx).varDeclaration.vd); 
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(125);
				((ClassDeclarationContext)_localctx).methodDeclaration = methodDeclaration();
				 _localctx.cd.addMethodDeclaration(((ClassDeclarationContext)_localctx).methodDeclaration.md); 
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclaration vd;
		public IdentifierContext identifier;
		public TypeContext type;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__11);
			setState(136);
			((VarDeclarationContext)_localctx).identifier = identifier();
			setState(137);
			match(T__5);
			setState(138);
			((VarDeclarationContext)_localctx).type = type();
			setState(139);
			match(T__8);
			 ((VarDeclarationContext)_localctx).vd =  new VarDeclaration(((VarDeclarationContext)_localctx).identifier.id, ((VarDeclarationContext)_localctx).type.t); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodDeclaration md;
		public IdentifierContext identifier;
		public TypeContext type;
		public VarDeclarationContext varDeclaration;
		public StatementContext statement;
		public Token l;
		public ExpressionContext expression;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__2);
			setState(143);
			((MethodDeclarationContext)_localctx).identifier = identifier();
			 ((MethodDeclarationContext)_localctx).md =  new MethodDeclaration(((MethodDeclarationContext)_localctx).identifier.id); 
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(145);
				match(T__3);
				setState(146);
				match(T__4);
				}
				break;
			case 2:
				{
				{
				setState(147);
				match(T__3);
				setState(148);
				((MethodDeclarationContext)_localctx).identifier = identifier();
				setState(149);
				match(T__5);
				setState(150);
				((MethodDeclarationContext)_localctx).type = type();

				            _localctx.md.addArg(new VarDeclaration(((MethodDeclarationContext)_localctx).identifier.id, ((MethodDeclarationContext)_localctx).type.t));
				        
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(152);
					match(T__12);
					setState(153);
					((MethodDeclarationContext)_localctx).identifier = identifier();
					setState(154);
					match(T__5);
					setState(155);
					((MethodDeclarationContext)_localctx).type = type();

					            _localctx.md.addArg(new VarDeclaration(((MethodDeclarationContext)_localctx).identifier.id, ((MethodDeclarationContext)_localctx).type.t));
					        
					}
					}
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(163);
				match(T__4);
				}
				}
				break;
			}
			setState(167);
			match(T__5);
			setState(168);
			((MethodDeclarationContext)_localctx).type = type();
			 _localctx.md.setReturnType(((MethodDeclarationContext)_localctx).type.t); 
			setState(170);
			match(T__1);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(171);
				((MethodDeclarationContext)_localctx).varDeclaration = varDeclaration();
				 _localctx.md.addLocalVar(((MethodDeclarationContext)_localctx).varDeclaration.vd); 
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << CONST_NUM) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				{
				setState(179);
				((MethodDeclarationContext)_localctx).statement = statement();
				 _localctx.md.addStatement(((MethodDeclarationContext)_localctx).statement.s); 
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			((MethodDeclarationContext)_localctx).l = match(T__7);
			setState(188);
			((MethodDeclarationContext)_localctx).expression = expression();
			 _localctx.md.setReturnValue(((MethodDeclarationContext)_localctx).expression.e); _localctx.md.setReturnLine(((MethodDeclarationContext)_localctx).l.getLine());
			setState(190);
			match(T__8);
			setState(191);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement s;
		public StatementBlockContext statementBlock;
		public StatementConditionContext statementCondition;
		public StatementLoopContext statementLoop;
		public StatementWriteContext statementWrite;
		public StatementAssignmentContext statementAssignment;
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public StatementConditionContext statementCondition() {
			return getRuleContext(StatementConditionContext.class,0);
		}
		public StatementLoopContext statementLoop() {
			return getRuleContext(StatementLoopContext.class,0);
		}
		public StatementWriteContext statementWrite() {
			return getRuleContext(StatementWriteContext.class,0);
		}
		public StatementAssignmentContext statementAssignment() {
			return getRuleContext(StatementAssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				((StatementContext)_localctx).statementBlock = statementBlock();
				 ((StatementContext)_localctx).s =  ((StatementContext)_localctx).statementBlock.sBlock; 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				((StatementContext)_localctx).statementCondition = statementCondition();
				 ((StatementContext)_localctx).s =  ((StatementContext)_localctx).statementCondition.sCond; 
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				((StatementContext)_localctx).statementLoop = statementLoop();
				 ((StatementContext)_localctx).s =  ((StatementContext)_localctx).statementLoop.sLoop; 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				((StatementContext)_localctx).statementWrite = statementWrite();
				 ((StatementContext)_localctx).s =  ((StatementContext)_localctx).statementWrite.sWr; 
				}
				break;
			case T__3:
			case T__26:
			case T__29:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				((StatementContext)_localctx).statementAssignment = statementAssignment();
				 ((StatementContext)_localctx).s =  ((StatementContext)_localctx).statementAssignment.sAssign; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementBlockContext extends ParserRuleContext {
		public Block sBlock;
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementBlock(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statementBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((StatementBlockContext)_localctx).sBlock =  new Block(); 
			setState(211);
			match(T__1);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__29) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << CONST_NUM) | (1L << CONST_STR) | (1L << ID))) != 0)) {
				{
				{
				setState(212);
				((StatementBlockContext)_localctx).statement = statement();
				 _localctx.sBlock.addStatement(((StatementBlockContext)_localctx).statement.s); 
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementConditionContext extends ParserRuleContext {
		public Conditional sCond;
		public Token l;
		public ExpressionContext expression;
		public StatementContext statement;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementCondition(this);
		}
	}

	public final StatementConditionContext statementCondition() throws RecognitionException {
		StatementConditionContext _localctx = new StatementConditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statementCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__13);
			setState(223);
			((StatementConditionContext)_localctx).l = match(T__3);
			setState(224);
			((StatementConditionContext)_localctx).expression = expression();
			setState(225);
			match(T__4);
			setState(226);
			match(T__14);
			setState(227);
			((StatementConditionContext)_localctx).statement = statement();
			 ((StatementConditionContext)_localctx).sCond =  new Conditional(((StatementConditionContext)_localctx).expression.e, ((StatementConditionContext)_localctx).statement.s); _localctx.sCond.setLine(((StatementConditionContext)_localctx).l.getLine());
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(229);
				match(T__15);
				setState(230);
				((StatementConditionContext)_localctx).statement = statement();
				 _localctx.sCond.setAlternativeBody(((StatementConditionContext)_localctx).statement.s); 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementLoopContext extends ParserRuleContext {
		public While sLoop;
		public Token l;
		public ExpressionContext expression;
		public StatementContext statement;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementLoop(this);
		}
	}

	public final StatementLoopContext statementLoop() throws RecognitionException {
		StatementLoopContext _localctx = new StatementLoopContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statementLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__16);
			setState(236);
			((StatementLoopContext)_localctx).l = match(T__3);
			setState(237);
			((StatementLoopContext)_localctx).expression = expression();
			setState(238);
			match(T__4);
			setState(239);
			((StatementLoopContext)_localctx).statement = statement();
			 ((StatementLoopContext)_localctx).sLoop =  new While(((StatementLoopContext)_localctx).expression.e, ((StatementLoopContext)_localctx).statement.s); _localctx.sLoop.setLine(((StatementLoopContext)_localctx).l.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementWriteContext extends ParserRuleContext {
		public Write sWr;
		public Token l;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementWrite(this);
		}
	}

	public final StatementWriteContext statementWrite() throws RecognitionException {
		StatementWriteContext _localctx = new StatementWriteContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statementWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(T__17);
			setState(243);
			((StatementWriteContext)_localctx).l = match(T__3);
			setState(244);
			((StatementWriteContext)_localctx).expression = expression();
			setState(245);
			match(T__4);
			setState(246);
			match(T__8);
			 ((StatementWriteContext)_localctx).sWr =  new Write(((StatementWriteContext)_localctx).expression.e); _localctx.sWr.setLine(((StatementWriteContext)_localctx).l.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementAssignmentContext extends ParserRuleContext {
		public Assign sAssign;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterStatementAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitStatementAssignment(this);
		}
	}

	public final StatementAssignmentContext statementAssignment() throws RecognitionException {
		StatementAssignmentContext _localctx = new StatementAssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statementAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			((StatementAssignmentContext)_localctx).expression = expression();
			setState(250);
			match(T__8);
			 ((StatementAssignmentContext)_localctx).sAssign =  new Assign(((StatementAssignmentContext)_localctx).expression.e); _localctx.sAssign.setLine(((StatementAssignmentContext)_localctx).expression.e.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression e;
		public ExpressionAssignmentContext expressionAssignment;
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			((ExpressionContext)_localctx).expressionAssignment = expressionAssignment();

			        ((ExpressionContext)_localctx).e =  ((ExpressionContext)_localctx).expressionAssignment.e;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAssignmentContext extends ParserRuleContext {
		public Expression e;
		public ExpressionOrContext expressionOr;
		public Token l;
		public ExpressionAssignmentContext expressionAssignment;
		public ExpressionOrContext expressionOr() {
			return getRuleContext(ExpressionOrContext.class,0);
		}
		public ExpressionAssignmentContext expressionAssignment() {
			return getRuleContext(ExpressionAssignmentContext.class,0);
		}
		public ExpressionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAssignment(this);
		}
	}

	public final ExpressionAssignmentContext expressionAssignment() throws RecognitionException {
		ExpressionAssignmentContext _localctx = new ExpressionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expressionAssignment);
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				((ExpressionAssignmentContext)_localctx).expressionOr = expressionOr();
				setState(257);
				((ExpressionAssignmentContext)_localctx).l = match(T__18);
				setState(258);
				((ExpressionAssignmentContext)_localctx).expressionAssignment = expressionAssignment();

				        ((ExpressionAssignmentContext)_localctx).e =  new BinaryExpression(
				            ((ExpressionAssignmentContext)_localctx).expressionOr.e,
				            ((ExpressionAssignmentContext)_localctx).expressionAssignment.e,
				            BinaryOperator.assign
				        );
				        _localctx.e.setLine(((ExpressionAssignmentContext)_localctx).l.getLine());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				((ExpressionAssignmentContext)_localctx).expressionOr = expressionOr();

				        ((ExpressionAssignmentContext)_localctx).e =  ((ExpressionAssignmentContext)_localctx).expressionOr.e;
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOrContext extends ParserRuleContext {
		public Expression e;
		public ExpressionAndContext expressionAnd;
		public ExpressionOrTempContext expressionOrTemp;
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOr(this);
		}
	}

	public final ExpressionOrContext expressionOr() throws RecognitionException {
		ExpressionOrContext _localctx = new ExpressionOrContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			((ExpressionOrContext)_localctx).expressionAnd = expressionAnd();
			setState(267);
			((ExpressionOrContext)_localctx).expressionOrTemp = expressionOrTemp();

			        if (((ExpressionOrContext)_localctx).expressionOrTemp.e == null) {
			            ((ExpressionOrContext)_localctx).e =  ((ExpressionOrContext)_localctx).expressionAnd.e;
			        }
			        else {
			            ((ExpressionOrContext)_localctx).e =  new BinaryExpression(
			                ((ExpressionOrContext)_localctx).expressionAnd.e,
			                ((ExpressionOrContext)_localctx).expressionOrTemp.e,
			                BinaryOperator.or
			            );
			            _localctx.e.setLine(((ExpressionOrContext)_localctx).expressionOrTemp.line);
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOrTempContext extends ParserRuleContext {
		public Expression e;
		public int line;
		public Token l;
		public ExpressionAndContext expressionAnd;
		public ExpressionOrTempContext expressionOrTemp;
		public ExpressionAndContext expressionAnd() {
			return getRuleContext(ExpressionAndContext.class,0);
		}
		public ExpressionOrTempContext expressionOrTemp() {
			return getRuleContext(ExpressionOrTempContext.class,0);
		}
		public ExpressionOrTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOrTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOrTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOrTemp(this);
		}
	}

	public final ExpressionOrTempContext expressionOrTemp() throws RecognitionException {
		ExpressionOrTempContext _localctx = new ExpressionOrTempContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionOrTemp);
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				((ExpressionOrTempContext)_localctx).l = match(T__19);
				setState(271);
				((ExpressionOrTempContext)_localctx).expressionAnd = expressionAnd();
				setState(272);
				((ExpressionOrTempContext)_localctx).expressionOrTemp = expressionOrTemp();

				        ((ExpressionOrTempContext)_localctx).line =  ((ExpressionOrTempContext)_localctx).l.getLine();
				        if (((ExpressionOrTempContext)_localctx).expressionOrTemp.e == null) {
				            ((ExpressionOrTempContext)_localctx).e =  ((ExpressionOrTempContext)_localctx).expressionAnd.e;
				        }
				        else {
				            ((ExpressionOrTempContext)_localctx).e =  new BinaryExpression(
				                ((ExpressionOrTempContext)_localctx).expressionAnd.e,
				                ((ExpressionOrTempContext)_localctx).expressionOrTemp.e,
				                BinaryOperator.or
				            );
				            _localctx.e.setLine(((ExpressionOrTempContext)_localctx).expressionOrTemp.line);
				        }
				    
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionOrTempContext)_localctx).e =  null; ((ExpressionOrTempContext)_localctx).line =  -1;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAndContext extends ParserRuleContext {
		public Expression e;
		public ExpressionEqContext expressionEq;
		public ExpressionAndTempContext expressionAndTemp;
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAnd(this);
		}
	}

	public final ExpressionAndContext expressionAnd() throws RecognitionException {
		ExpressionAndContext _localctx = new ExpressionAndContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressionAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			((ExpressionAndContext)_localctx).expressionEq = expressionEq();
			setState(279);
			((ExpressionAndContext)_localctx).expressionAndTemp = expressionAndTemp();

			        if (((ExpressionAndContext)_localctx).expressionAndTemp.e == null) {
			            ((ExpressionAndContext)_localctx).e =  ((ExpressionAndContext)_localctx).expressionEq.e;
			        }
			        else {
			            ((ExpressionAndContext)_localctx).e =  new BinaryExpression(
			                ((ExpressionAndContext)_localctx).expressionEq.e,
			                ((ExpressionAndContext)_localctx).expressionAndTemp.e,
			                BinaryOperator.and
			            );
			            _localctx.e.setLine(((ExpressionAndContext)_localctx).expressionAndTemp.line);
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAndTempContext extends ParserRuleContext {
		public Expression e;
		public int line;
		public Token l;
		public ExpressionEqContext expressionEq;
		public ExpressionAndTempContext expressionAndTemp;
		public ExpressionEqContext expressionEq() {
			return getRuleContext(ExpressionEqContext.class,0);
		}
		public ExpressionAndTempContext expressionAndTemp() {
			return getRuleContext(ExpressionAndTempContext.class,0);
		}
		public ExpressionAndTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAndTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAndTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAndTemp(this);
		}
	}

	public final ExpressionAndTempContext expressionAndTemp() throws RecognitionException {
		ExpressionAndTempContext _localctx = new ExpressionAndTempContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressionAndTemp);
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				((ExpressionAndTempContext)_localctx).l = match(T__20);
				setState(283);
				((ExpressionAndTempContext)_localctx).expressionEq = expressionEq();
				setState(284);
				((ExpressionAndTempContext)_localctx).expressionAndTemp = expressionAndTemp();

				        ((ExpressionAndTempContext)_localctx).line =  ((ExpressionAndTempContext)_localctx).l.getLine();
				        if (((ExpressionAndTempContext)_localctx).expressionAndTemp.e == null) {
				            ((ExpressionAndTempContext)_localctx).e =  ((ExpressionAndTempContext)_localctx).expressionEq.e;
				        }
				        else {
				            ((ExpressionAndTempContext)_localctx).e =  new BinaryExpression(
				                ((ExpressionAndTempContext)_localctx).expressionEq.e,
				                ((ExpressionAndTempContext)_localctx).expressionAndTemp.e,
				                BinaryOperator.and
				            );
				            _localctx.e.setLine(((ExpressionAndTempContext)_localctx).expressionAndTemp.line);
				        }
				    
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionAndTempContext)_localctx).e =  null; ((ExpressionAndTempContext)_localctx).line =  -1; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionEqContext extends ParserRuleContext {
		public Expression e;
		public ExpressionCmpContext expressionCmp;
		public ExpressionEqTempContext expressionEqTemp;
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionEq(this);
		}
	}

	public final ExpressionEqContext expressionEq() throws RecognitionException {
		ExpressionEqContext _localctx = new ExpressionEqContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionEq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			((ExpressionEqContext)_localctx).expressionCmp = expressionCmp();
			setState(291);
			((ExpressionEqContext)_localctx).expressionEqTemp = expressionEqTemp();

			        if (((ExpressionEqContext)_localctx).expressionEqTemp.e == null) {
			            ((ExpressionEqContext)_localctx).e =  ((ExpressionEqContext)_localctx).expressionCmp.e;
			        }
			        else {
			            ((ExpressionEqContext)_localctx).e =  new BinaryExpression(
			                ((ExpressionEqContext)_localctx).expressionCmp.e,
			                ((ExpressionEqContext)_localctx).expressionEqTemp.e,
			                ((ExpressionEqContext)_localctx).expressionEqTemp.o
			            );
			            _localctx.e.setLine(((ExpressionEqContext)_localctx).expressionEqTemp.line);
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionEqTempContext extends ParserRuleContext {
		public Expression e;
		public BinaryOperator o;
		public int line;
		public Token l;
		public ExpressionCmpContext expressionCmp;
		public ExpressionEqTempContext expressionEqTemp;
		public ExpressionCmpContext expressionCmp() {
			return getRuleContext(ExpressionCmpContext.class,0);
		}
		public ExpressionEqTempContext expressionEqTemp() {
			return getRuleContext(ExpressionEqTempContext.class,0);
		}
		public ExpressionEqTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionEqTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionEqTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionEqTemp(this);
		}
	}

	public final ExpressionEqTempContext expressionEqTemp() throws RecognitionException {
		ExpressionEqTempContext _localctx = new ExpressionEqTempContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionEqTemp);
		try {
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__21:
					{
					setState(294);
					((ExpressionEqTempContext)_localctx).l = match(T__21);
					 ((ExpressionEqTempContext)_localctx).o =  BinaryOperator.eq; ((ExpressionEqTempContext)_localctx).line = ((ExpressionEqTempContext)_localctx).l.getLine();
					}
					break;
				case T__22:
					{
					setState(296);
					((ExpressionEqTempContext)_localctx).l = match(T__22);
					 ((ExpressionEqTempContext)_localctx).o =  BinaryOperator.neq; ((ExpressionEqTempContext)_localctx).line = ((ExpressionEqTempContext)_localctx).l.getLine();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(300);
				((ExpressionEqTempContext)_localctx).expressionCmp = expressionCmp();
				setState(301);
				((ExpressionEqTempContext)_localctx).expressionEqTemp = expressionEqTemp();

				            if (((ExpressionEqTempContext)_localctx).expressionEqTemp.e == null) {
				                ((ExpressionEqTempContext)_localctx).e =  ((ExpressionEqTempContext)_localctx).expressionCmp.e;
				            }
				            else {
				                ((ExpressionEqTempContext)_localctx).e =  new BinaryExpression(
				                    ((ExpressionEqTempContext)_localctx).expressionCmp.e,
				                    ((ExpressionEqTempContext)_localctx).expressionEqTemp.e,
				                    _localctx.o
				                );
				                _localctx.e.setLine(((ExpressionEqTempContext)_localctx).expressionEqTemp.line);
				            }
				        
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionEqTempContext)_localctx).e =  null; ((ExpressionEqTempContext)_localctx).line = -1;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionCmpContext extends ParserRuleContext {
		public Expression e;
		public ExpressionAddContext expressionAdd;
		public ExpressionCmpTempContext expressionCmpTemp;
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionCmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionCmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionCmp(this);
		}
	}

	public final ExpressionCmpContext expressionCmp() throws RecognitionException {
		ExpressionCmpContext _localctx = new ExpressionCmpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressionCmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			((ExpressionCmpContext)_localctx).expressionAdd = expressionAdd();
			setState(308);
			((ExpressionCmpContext)_localctx).expressionCmpTemp = expressionCmpTemp();

			        if (((ExpressionCmpContext)_localctx).expressionCmpTemp.e == null) {
			            ((ExpressionCmpContext)_localctx).e =  ((ExpressionCmpContext)_localctx).expressionAdd.e;
			        }
			        else {
			            ((ExpressionCmpContext)_localctx).e =  new BinaryExpression(
			                ((ExpressionCmpContext)_localctx).expressionAdd.e,
			                ((ExpressionCmpContext)_localctx).expressionCmpTemp.e,
			                ((ExpressionCmpContext)_localctx).expressionCmpTemp.o
			            );
			            _localctx.e.setLine(((ExpressionCmpContext)_localctx).expressionCmpTemp.line);
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionCmpTempContext extends ParserRuleContext {
		public Expression e;
		public BinaryOperator o;
		public int line;
		public Token l;
		public ExpressionAddContext expressionAdd;
		public ExpressionCmpTempContext expressionCmpTemp;
		public ExpressionAddContext expressionAdd() {
			return getRuleContext(ExpressionAddContext.class,0);
		}
		public ExpressionCmpTempContext expressionCmpTemp() {
			return getRuleContext(ExpressionCmpTempContext.class,0);
		}
		public ExpressionCmpTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionCmpTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionCmpTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionCmpTemp(this);
		}
	}

	public final ExpressionCmpTempContext expressionCmpTemp() throws RecognitionException {
		ExpressionCmpTempContext _localctx = new ExpressionCmpTempContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expressionCmpTemp);
		try {
			setState(322);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__23:
					{
					setState(311);
					((ExpressionCmpTempContext)_localctx).l = match(T__23);
					 ((ExpressionCmpTempContext)_localctx).o =  BinaryOperator.lt; ((ExpressionCmpTempContext)_localctx).line = ((ExpressionCmpTempContext)_localctx).l.getLine();
					}
					break;
				case T__24:
					{
					setState(313);
					((ExpressionCmpTempContext)_localctx).l = match(T__24);
					 ((ExpressionCmpTempContext)_localctx).o =  BinaryOperator.gt; ((ExpressionCmpTempContext)_localctx).line = ((ExpressionCmpTempContext)_localctx).l.getLine();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(317);
				((ExpressionCmpTempContext)_localctx).expressionAdd = expressionAdd();
				setState(318);
				((ExpressionCmpTempContext)_localctx).expressionCmpTemp = expressionCmpTemp();

				            if (((ExpressionCmpTempContext)_localctx).expressionCmpTemp.e == null) {
				                ((ExpressionCmpTempContext)_localctx).e =  ((ExpressionCmpTempContext)_localctx).expressionAdd.e;
				            }
				            else {
				                ((ExpressionCmpTempContext)_localctx).e =  new BinaryExpression(
				                    ((ExpressionCmpTempContext)_localctx).expressionAdd.e,
				                    ((ExpressionCmpTempContext)_localctx).expressionCmpTemp.e,
				                    _localctx.o
				                );
				                _localctx.e.setLine(((ExpressionCmpTempContext)_localctx).expressionCmpTemp.line);
				            }
				        
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionCmpTempContext)_localctx).e =  null; ((ExpressionCmpTempContext)_localctx).line = -1;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAddContext extends ParserRuleContext {
		public Expression e;
		public ExpressionMultContext expressionMult;
		public ExpressionAddTempContext expressionAddTemp;
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAdd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAdd(this);
		}
	}

	public final ExpressionAddContext expressionAdd() throws RecognitionException {
		ExpressionAddContext _localctx = new ExpressionAddContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expressionAdd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			((ExpressionAddContext)_localctx).expressionMult = expressionMult();
			setState(325);
			((ExpressionAddContext)_localctx).expressionAddTemp = expressionAddTemp();

			        if (((ExpressionAddContext)_localctx).expressionAddTemp.e == null) {
			            ((ExpressionAddContext)_localctx).e =  ((ExpressionAddContext)_localctx).expressionMult.e;
			        }
			        else {
			            ((ExpressionAddContext)_localctx).e =  new BinaryExpression(
			                ((ExpressionAddContext)_localctx).expressionMult.e,
			                ((ExpressionAddContext)_localctx).expressionAddTemp.e,
			                ((ExpressionAddContext)_localctx).expressionAddTemp.o
			            );
			            _localctx.e.setLine(((ExpressionAddContext)_localctx).expressionAddTemp.line);
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionAddTempContext extends ParserRuleContext {
		public Expression e;
		public BinaryOperator o;
		public int line;
		public Token l;
		public ExpressionMultContext expressionMult;
		public ExpressionAddTempContext expressionAddTemp;
		public ExpressionMultContext expressionMult() {
			return getRuleContext(ExpressionMultContext.class,0);
		}
		public ExpressionAddTempContext expressionAddTemp() {
			return getRuleContext(ExpressionAddTempContext.class,0);
		}
		public ExpressionAddTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionAddTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionAddTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionAddTemp(this);
		}
	}

	public final ExpressionAddTempContext expressionAddTemp() throws RecognitionException {
		ExpressionAddTempContext _localctx = new ExpressionAddTempContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionAddTemp);
		try {
			setState(339);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__25:
					{
					setState(328);
					((ExpressionAddTempContext)_localctx).l = match(T__25);
					 ((ExpressionAddTempContext)_localctx).o =  BinaryOperator.add; ((ExpressionAddTempContext)_localctx).line = ((ExpressionAddTempContext)_localctx).l.getLine();
					}
					break;
				case T__26:
					{
					setState(330);
					((ExpressionAddTempContext)_localctx).l = match(T__26);
					 ((ExpressionAddTempContext)_localctx).o =  BinaryOperator.sub; ((ExpressionAddTempContext)_localctx).line = ((ExpressionAddTempContext)_localctx).l.getLine();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(334);
				((ExpressionAddTempContext)_localctx).expressionMult = expressionMult();
				setState(335);
				((ExpressionAddTempContext)_localctx).expressionAddTemp = expressionAddTemp();

				            if (((ExpressionAddTempContext)_localctx).expressionAddTemp.e == null) {
				                ((ExpressionAddTempContext)_localctx).e =  ((ExpressionAddTempContext)_localctx).expressionMult.e;
				            }
				            else {
				                ((ExpressionAddTempContext)_localctx).e =  new BinaryExpression(
				                    ((ExpressionAddTempContext)_localctx).expressionMult.e,
				                    ((ExpressionAddTempContext)_localctx).expressionAddTemp.e,
				                    _localctx.o
				                );
				                _localctx.e.setLine(((ExpressionAddTempContext)_localctx).expressionAddTemp.line);
				            }
				        
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionAddTempContext)_localctx).e =  null; ((ExpressionAddTempContext)_localctx).line = -1;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMultContext extends ParserRuleContext {
		public Expression e;
		public ExpressionUnaryContext expressionUnary;
		public ExpressionMultTempContext expressionMultTemp;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMult(this);
		}
	}

	public final ExpressionMultContext expressionMult() throws RecognitionException {
		ExpressionMultContext _localctx = new ExpressionMultContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expressionMult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			((ExpressionMultContext)_localctx).expressionUnary = expressionUnary();
			setState(342);
			((ExpressionMultContext)_localctx).expressionMultTemp = expressionMultTemp();

			        if (((ExpressionMultContext)_localctx).expressionMultTemp.e == null) {
			            ((ExpressionMultContext)_localctx).e =  ((ExpressionMultContext)_localctx).expressionUnary.e;
			        }
			        else {
			            ((ExpressionMultContext)_localctx).e =  new BinaryExpression(
			                ((ExpressionMultContext)_localctx).expressionUnary.e,
			                ((ExpressionMultContext)_localctx).expressionMultTemp.e,
			                ((ExpressionMultContext)_localctx).expressionMultTemp.o
			            );
			            _localctx.e.setLine(((ExpressionMultContext)_localctx).expressionMultTemp.line);
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMultTempContext extends ParserRuleContext {
		public Expression e;
		public BinaryOperator o;
		public int line;
		public Token l;
		public ExpressionUnaryContext expressionUnary;
		public ExpressionMultTempContext expressionMultTemp;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMultTempContext expressionMultTemp() {
			return getRuleContext(ExpressionMultTempContext.class,0);
		}
		public ExpressionMultTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMultTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMultTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMultTemp(this);
		}
	}

	public final ExpressionMultTempContext expressionMultTemp() throws RecognitionException {
		ExpressionMultTempContext _localctx = new ExpressionMultTempContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressionMultTemp);
		try {
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__27:
					{
					setState(345);
					((ExpressionMultTempContext)_localctx).l = match(T__27);
					 ((ExpressionMultTempContext)_localctx).o =  BinaryOperator.mult; ((ExpressionMultTempContext)_localctx).line = ((ExpressionMultTempContext)_localctx).l.getLine();
					}
					break;
				case T__28:
					{
					setState(347);
					((ExpressionMultTempContext)_localctx).l = match(T__28);
					 ((ExpressionMultTempContext)_localctx).o =  BinaryOperator.div; ((ExpressionMultTempContext)_localctx).line = ((ExpressionMultTempContext)_localctx).l.getLine();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(351);
				((ExpressionMultTempContext)_localctx).expressionUnary = expressionUnary();
				setState(352);
				((ExpressionMultTempContext)_localctx).expressionMultTemp = expressionMultTemp();

				            if (((ExpressionMultTempContext)_localctx).expressionMultTemp.e == null) {
				                ((ExpressionMultTempContext)_localctx).e =  ((ExpressionMultTempContext)_localctx).expressionUnary.e;
				            }
				            else {
				                ((ExpressionMultTempContext)_localctx).e =  new BinaryExpression(
				                    ((ExpressionMultTempContext)_localctx).expressionUnary.e,
				                    ((ExpressionMultTempContext)_localctx).expressionMultTemp.e,
				                    _localctx.o
				                );
				                _localctx.e.setLine(((ExpressionMultTempContext)_localctx).expressionMultTemp.line);
				            }
				        
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionMultTempContext)_localctx).e =  null; ((ExpressionMultTempContext)_localctx).line = -1;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionUnaryContext extends ParserRuleContext {
		public Expression e;
		public Token l;
		public ExpressionUnaryContext expressionUnary;
		public ExpressionMemContext expressionMem;
		public ExpressionUnaryContext expressionUnary() {
			return getRuleContext(ExpressionUnaryContext.class,0);
		}
		public ExpressionMemContext expressionMem() {
			return getRuleContext(ExpressionMemContext.class,0);
		}
		public ExpressionUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionUnary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionUnary(this);
		}
	}

	public final ExpressionUnaryContext expressionUnary() throws RecognitionException {
		ExpressionUnaryContext _localctx = new ExpressionUnaryContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expressionUnary);
		try {
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				 UnaryOperator o; int line;
				setState(363);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__29:
					{
					setState(359);
					((ExpressionUnaryContext)_localctx).l = match(T__29);
					 o = UnaryOperator.not; line = ((ExpressionUnaryContext)_localctx).l.getLine();
					}
					break;
				case T__26:
					{
					setState(361);
					((ExpressionUnaryContext)_localctx).l = match(T__26);
					 o = UnaryOperator.minus; line = ((ExpressionUnaryContext)_localctx).l.getLine();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(365);
				((ExpressionUnaryContext)_localctx).expressionUnary = expressionUnary();

				            ((ExpressionUnaryContext)_localctx).e =  new UnaryExpression(o, ((ExpressionUnaryContext)_localctx).expressionUnary.e);
				            _localctx.e.setLine(line);
				        
				}
				break;
			case T__3:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case CONST_NUM:
			case CONST_STR:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				((ExpressionUnaryContext)_localctx).expressionMem = expressionMem();

				        ((ExpressionUnaryContext)_localctx).e =  ((ExpressionUnaryContext)_localctx).expressionMem.e;
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMemContext extends ParserRuleContext {
		public Expression e;
		public ExpressionMethodsContext expressionMethods;
		public ExpressionMemTempContext expressionMemTemp;
		public ExpressionMethodsContext expressionMethods() {
			return getRuleContext(ExpressionMethodsContext.class,0);
		}
		public ExpressionMemTempContext expressionMemTemp() {
			return getRuleContext(ExpressionMemTempContext.class,0);
		}
		public ExpressionMemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMem(this);
		}
	}

	public final ExpressionMemContext expressionMem() throws RecognitionException {
		ExpressionMemContext _localctx = new ExpressionMemContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionMem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			((ExpressionMemContext)_localctx).expressionMethods = expressionMethods();
			setState(374);
			((ExpressionMemContext)_localctx).expressionMemTemp = expressionMemTemp();

			        if (((ExpressionMemContext)_localctx).expressionMemTemp.e == null) {
			            ((ExpressionMemContext)_localctx).e =  ((ExpressionMemContext)_localctx).expressionMethods.e;
			        }
			        else {
			            ((ExpressionMemContext)_localctx).e =  new ArrayCall(
			                ((ExpressionMemContext)_localctx).expressionMethods.e,
			                ((ExpressionMemContext)_localctx).expressionMemTemp.e
			            );
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMemTempContext extends ParserRuleContext {
		public Expression e;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionMemTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMemTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMemTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMemTemp(this);
		}
	}

	public final ExpressionMemTempContext expressionMemTemp() throws RecognitionException {
		ExpressionMemTempContext _localctx = new ExpressionMemTempContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expressionMemTemp);
		try {
			setState(383);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(T__30);
				setState(378);
				((ExpressionMemTempContext)_localctx).expression = expression();
				setState(379);
				match(T__31);

				        ((ExpressionMemTempContext)_localctx).e =  ((ExpressionMemTempContext)_localctx).expression.e;
				    
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionMemTempContext)_localctx).e =  null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMethodsContext extends ParserRuleContext {
		public Expression e;
		public ExpressionOtherContext expressionOther;
		public ExpressionMethodsTempContext expressionMethodsTemp;
		public ExpressionOtherContext expressionOther() {
			return getRuleContext(ExpressionOtherContext.class,0);
		}
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public ExpressionMethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionMethods; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMethods(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMethods(this);
		}
	}

	public final ExpressionMethodsContext expressionMethods() throws RecognitionException {
		ExpressionMethodsContext _localctx = new ExpressionMethodsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expressionMethods);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			((ExpressionMethodsContext)_localctx).expressionOther = expressionOther();
			setState(386);
			((ExpressionMethodsContext)_localctx).expressionMethodsTemp = expressionMethodsTemp(((ExpressionMethodsContext)_localctx).expressionOther.e);

			        if (((ExpressionMethodsContext)_localctx).expressionMethodsTemp.mc == null) {
			            ((ExpressionMethodsContext)_localctx).e =  ((ExpressionMethodsContext)_localctx).expressionOther.e;
			        }
			        else {
			            ((ExpressionMethodsContext)_localctx).e =  ((ExpressionMethodsContext)_localctx).expressionMethodsTemp.mc;
			        }
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionMethodsTempContext extends ParserRuleContext {
		public Expression instance;
		public Expression mc;
		public Token l;
		public IdentifierContext identifier;
		public ExpressionContext expression;
		public ExpressionMethodsTempContext expressionMethodsTemp;
		public ExpressionMethodsTempContext expressionMethodsTemp() {
			return getRuleContext(ExpressionMethodsTempContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionMethodsTempContext(ParserRuleContext parent, int invokingState, Expression instance) {
			super(parent, invokingState);
			this.instance = instance;
		}
		@Override public int getRuleIndex() { return RULE_expressionMethodsTemp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionMethodsTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionMethodsTemp(this);
		}
	}

	public final ExpressionMethodsTempContext expressionMethodsTemp(Expression instance) throws RecognitionException {
		ExpressionMethodsTempContext _localctx = new ExpressionMethodsTempContext(_ctx, getState(), instance);
		enterRule(_localctx, 58, RULE_expressionMethodsTemp);
		int _la;
		try {
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				 ((ExpressionMethodsTempContext)_localctx).mc =  new MethodCall(_localctx.instance, new Identifier("")); 
				setState(390);
				((ExpressionMethodsTempContext)_localctx).l = match(T__32);
				_localctx.mc.setLine(((ExpressionMethodsTempContext)_localctx).l.getLine());
				setState(415);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(392);
					((ExpressionMethodsTempContext)_localctx).identifier = identifier();
					 ((MethodCall)(_localctx.mc)).setMethodName(((ExpressionMethodsTempContext)_localctx).identifier.id); 
					setState(394);
					match(T__3);
					setState(395);
					match(T__4);
					}
					break;
				case 2:
					{
					setState(397);
					((ExpressionMethodsTempContext)_localctx).identifier = identifier();
					 ((MethodCall)(_localctx.mc)).setMethodName(((ExpressionMethodsTempContext)_localctx).identifier.id); 
					setState(399);
					match(T__3);
					{
					setState(400);
					((ExpressionMethodsTempContext)_localctx).expression = expression();
					 ((MethodCall)(_localctx.mc)).addArg(((ExpressionMethodsTempContext)_localctx).expression.e); 
					setState(408);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__12) {
						{
						{
						setState(402);
						match(T__12);
						setState(403);
						((ExpressionMethodsTempContext)_localctx).expression = expression();
						 ((MethodCall)(_localctx.mc)).addArg(((ExpressionMethodsTempContext)_localctx).expression.e); 
						}
						}
						setState(410);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(411);
					match(T__4);
					}
					break;
				case 3:
					{
					setState(413);
					match(T__33);
					 ((ExpressionMethodsTempContext)_localctx).mc =  new Length(_localctx.instance); _localctx.mc.setLine(((ExpressionMethodsTempContext)_localctx).l.getLine()); 
					}
					break;
				}
				setState(417);
				((ExpressionMethodsTempContext)_localctx).expressionMethodsTemp = expressionMethodsTemp(_localctx.mc);

				            if (((ExpressionMethodsTempContext)_localctx).expressionMethodsTemp.mc != null) {
				                ((ExpressionMethodsTempContext)_localctx).mc =  ((ExpressionMethodsTempContext)_localctx).expressionMethodsTemp.mc;
				            }
				        
				}
				break;
			case T__4:
			case T__8:
			case T__12:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__30:
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				 ((ExpressionMethodsTempContext)_localctx).mc =  null; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionOtherContext extends ParserRuleContext {
		public Expression e;
		public Token CONST_NUM;
		public Token CONST_STR;
		public Token l;
		public IdentifierContext identifier;
		public ExpressionContext expression;
		public TerminalNode CONST_NUM() { return getToken(SmoolaParser.CONST_NUM, 0); }
		public TerminalNode CONST_STR() { return getToken(SmoolaParser.CONST_STR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionOtherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionOther; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterExpressionOther(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitExpressionOther(this);
		}
	}

	public final ExpressionOtherContext expressionOther() throws RecognitionException {
		ExpressionOtherContext _localctx = new ExpressionOtherContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expressionOther);
		try {
			setState(459);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				((ExpressionOtherContext)_localctx).CONST_NUM = match(CONST_NUM);

				        ((ExpressionOtherContext)_localctx).e =  new IntValue(Integer.parseInt(((ExpressionOtherContext)_localctx).CONST_NUM.getText()), new IntType());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
				((ExpressionOtherContext)_localctx).CONST_STR = match(CONST_STR);

				        ((ExpressionOtherContext)_localctx).e =  new StringValue(((ExpressionOtherContext)_localctx).CONST_STR.getText(), new StringType());
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(427);
				match(T__34);
				setState(428);
				((ExpressionOtherContext)_localctx).l = match(T__6);
				setState(429);
				match(T__30);
				setState(430);
				((ExpressionOtherContext)_localctx).CONST_NUM = match(CONST_NUM);
				setState(431);
				match(T__31);

				        ((ExpressionOtherContext)_localctx).e =  new NewArray(
				            new IntValue(
				                Integer.parseInt(((ExpressionOtherContext)_localctx).CONST_NUM.getText()),
				                new IntType()
				                )
				              );
				              _localctx.e.setLine(((ExpressionOtherContext)_localctx).l.getLine());
				              ArrayType a = new ArrayType();
				              a.setSize(Integer.parseInt(((ExpressionOtherContext)_localctx).CONST_NUM.getText()));
				              _localctx.e.setType(a);
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(433);
				match(T__34);
				setState(434);
				((ExpressionOtherContext)_localctx).identifier = identifier();
				setState(435);
				match(T__3);
				setState(436);
				match(T__4);

				        ((ExpressionOtherContext)_localctx).e =  new NewClass(((ExpressionOtherContext)_localctx).identifier.id);
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(439);
				match(T__35);

				        ((ExpressionOtherContext)_localctx).e =  new This();
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(441);
				match(T__36);

				        ((ExpressionOtherContext)_localctx).e =  new BooleanValue(true, new BooleanType());
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(443);
				match(T__37);

				        ((ExpressionOtherContext)_localctx).e =  new BooleanValue(false, new BooleanType());
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(445);
				((ExpressionOtherContext)_localctx).identifier = identifier();

				        ((ExpressionOtherContext)_localctx).e =  ((ExpressionOtherContext)_localctx).identifier.id;
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(448);
				((ExpressionOtherContext)_localctx).identifier = identifier();
				setState(449);
				match(T__30);
				setState(450);
				((ExpressionOtherContext)_localctx).expression = expression();
				setState(451);
				match(T__31);

				        ((ExpressionOtherContext)_localctx).e =  new ArrayCall(
				            ((ExpressionOtherContext)_localctx).identifier.id,
				            ((ExpressionOtherContext)_localctx).expression.e
				        );
				    
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(454);
				match(T__3);
				setState(455);
				((ExpressionOtherContext)_localctx).expression = expression();
				setState(456);
				match(T__4);

				        ((ExpressionOtherContext)_localctx).e =  ((ExpressionOtherContext)_localctx).expression.e;
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type t;
		public IdentifierContext identifier;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_type);
		try {
			setState(474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				match(T__6);
				 ((TypeContext)_localctx).t =  new IntType(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(463);
				match(T__38);
				 ((TypeContext)_localctx).t =  new BooleanType(); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(465);
				match(T__39);
				 ((TypeContext)_localctx).t =  new StringType(); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(467);
				match(T__6);
				setState(468);
				match(T__30);
				setState(469);
				match(T__31);
				 ((TypeContext)_localctx).t =  new ArrayType(); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(471);
				((TypeContext)_localctx).identifier = identifier();
				 ((TypeContext)_localctx).t =  new UserDefinedType(); ((UserDefinedType)(_localctx.t)).setName(((TypeContext)_localctx).identifier.id);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public Identifier id;
		public Token ID;
		public TerminalNode ID() { return getToken(SmoolaParser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmoolaListener ) ((SmoolaListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			((IdentifierContext)_localctx).ID = match(ID);
			 ((IdentifierContext)_localctx).id =  new Identifier(((IdentifierContext)_localctx).ID.getText()); _localctx.id.setLine(((IdentifierContext)_localctx).ID.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u01e2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\7\2K\n\2\f\2\16\2N\13\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3a\n\3\f"+
		"\3\16\3d\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4u\n\4\3\4\3\4\3\4\3\4\7\4{\n\4\f\4\16\4~\13\4\3\4\3\4\3\4\7\4"+
		"\u0083\n\4\f\4\16\4\u0086\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a1"+
		"\n\6\f\6\16\6\u00a4\13\6\3\6\3\6\5\6\u00a8\n\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6\u00b1\n\6\f\6\16\6\u00b4\13\6\3\6\3\6\3\6\7\6\u00b9\n\6\f\6\16"+
		"\6\u00bc\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d3\n\7\3\b\3\b\3\b\3\b\3\b\7\b\u00da"+
		"\n\b\f\b\16\b\u00dd\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\t\u00ec\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u010b\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u0117\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u0123\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u012d\n"+
		"\24\3\24\3\24\3\24\3\24\3\24\5\24\u0134\n\24\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\5\26\u013e\n\26\3\26\3\26\3\26\3\26\3\26\5\26\u0145\n"+
		"\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u014f\n\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u0156\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\5\32\u0160\n\32\3\32\3\32\3\32\3\32\3\32\5\32\u0167\n\32\3\33\3\33\3"+
		"\33\3\33\3\33\5\33\u016e\n\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0176"+
		"\n\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0182\n\35"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0199\n\37\f\37\16\37\u019c\13"+
		"\37\3\37\3\37\3\37\3\37\5\37\u01a2\n\37\3\37\3\37\3\37\3\37\5\37\u01a8"+
		"\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01ce\n \3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u01dd\n!\3\"\3\"\3\"\3\"\2\2#\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\2\2\u01ee\2D"+
		"\3\2\2\2\4Q\3\2\2\2\6m\3\2\2\2\b\u0089\3\2\2\2\n\u0090\3\2\2\2\f\u00d2"+
		"\3\2\2\2\16\u00d4\3\2\2\2\20\u00e0\3\2\2\2\22\u00ed\3\2\2\2\24\u00f4\3"+
		"\2\2\2\26\u00fb\3\2\2\2\30\u00ff\3\2\2\2\32\u010a\3\2\2\2\34\u010c\3\2"+
		"\2\2\36\u0116\3\2\2\2 \u0118\3\2\2\2\"\u0122\3\2\2\2$\u0124\3\2\2\2&\u0133"+
		"\3\2\2\2(\u0135\3\2\2\2*\u0144\3\2\2\2,\u0146\3\2\2\2.\u0155\3\2\2\2\60"+
		"\u0157\3\2\2\2\62\u0166\3\2\2\2\64\u0175\3\2\2\2\66\u0177\3\2\2\28\u0181"+
		"\3\2\2\2:\u0183\3\2\2\2<\u01a7\3\2\2\2>\u01cd\3\2\2\2@\u01dc\3\2\2\2B"+
		"\u01de\3\2\2\2DE\b\2\1\2EF\5\4\3\2FL\b\2\1\2GH\5\6\4\2HI\b\2\1\2IK\3\2"+
		"\2\2JG\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\2"+
		"\2\3P\3\3\2\2\2QR\7\3\2\2RS\5B\"\2ST\b\3\1\2TU\7\4\2\2UV\7\5\2\2VW\5B"+
		"\"\2WX\b\3\1\2XY\7\6\2\2YZ\7\7\2\2Z[\7\b\2\2[\\\7\t\2\2\\b\7\4\2\2]^\5"+
		"\f\7\2^_\b\3\1\2_a\3\2\2\2`]\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3"+
		"\2\2\2db\3\2\2\2ef\7\n\2\2fg\5\30\r\2gh\b\3\1\2hi\7\13\2\2ij\7\f\2\2j"+
		"k\b\3\1\2kl\7\f\2\2l\5\3\2\2\2mn\7\3\2\2nt\5B\"\2op\7\r\2\2pq\5B\"\2q"+
		"r\b\4\1\2ru\3\2\2\2su\b\4\1\2to\3\2\2\2ts\3\2\2\2uv\3\2\2\2v|\7\4\2\2"+
		"wx\5\b\5\2xy\b\4\1\2y{\3\2\2\2zw\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2"+
		"}\u0084\3\2\2\2~|\3\2\2\2\177\u0080\5\n\6\2\u0080\u0081\b\4\1\2\u0081"+
		"\u0083\3\2\2\2\u0082\177\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2"+
		"\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088"+
		"\7\f\2\2\u0088\7\3\2\2\2\u0089\u008a\7\16\2\2\u008a\u008b\5B\"\2\u008b"+
		"\u008c\7\b\2\2\u008c\u008d\5@!\2\u008d\u008e\7\13\2\2\u008e\u008f\b\5"+
		"\1\2\u008f\t\3\2\2\2\u0090\u0091\7\5\2\2\u0091\u0092\5B\"\2\u0092\u00a7"+
		"\b\6\1\2\u0093\u0094\7\6\2\2\u0094\u00a8\7\7\2\2\u0095\u0096\7\6\2\2\u0096"+
		"\u0097\5B\"\2\u0097\u0098\7\b\2\2\u0098\u0099\5@!\2\u0099\u00a2\b\6\1"+
		"\2\u009a\u009b\7\17\2\2\u009b\u009c\5B\"\2\u009c\u009d\7\b\2\2\u009d\u009e"+
		"\5@!\2\u009e\u009f\b\6\1\2\u009f\u00a1\3\2\2\2\u00a0\u009a\3\2\2\2\u00a1"+
		"\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\7\7\2\2\u00a6\u00a8\3\2\2\2\u00a7"+
		"\u0093\3\2\2\2\u00a7\u0095\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\7\b"+
		"\2\2\u00aa\u00ab\5@!\2\u00ab\u00ac\b\6\1\2\u00ac\u00b2\7\4\2\2\u00ad\u00ae"+
		"\5\b\5\2\u00ae\u00af\b\6\1\2\u00af\u00b1\3\2\2\2\u00b0\u00ad\3\2\2\2\u00b1"+
		"\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00ba\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\5\f\7\2\u00b6\u00b7\b\6\1\2\u00b7"+
		"\u00b9\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00be\7\n\2\2\u00be\u00bf\5\30\r\2\u00bf\u00c0\b\6\1\2\u00c0\u00c1\7"+
		"\13\2\2\u00c1\u00c2\7\f\2\2\u00c2\13\3\2\2\2\u00c3\u00c4\5\16\b\2\u00c4"+
		"\u00c5\b\7\1\2\u00c5\u00d3\3\2\2\2\u00c6\u00c7\5\20\t\2\u00c7\u00c8\b"+
		"\7\1\2\u00c8\u00d3\3\2\2\2\u00c9\u00ca\5\22\n\2\u00ca\u00cb\b\7\1\2\u00cb"+
		"\u00d3\3\2\2\2\u00cc\u00cd\5\24\13\2\u00cd\u00ce\b\7\1\2\u00ce\u00d3\3"+
		"\2\2\2\u00cf\u00d0\5\26\f\2\u00d0\u00d1\b\7\1\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00c3\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d2\u00c9\3\2\2\2\u00d2\u00cc\3\2"+
		"\2\2\u00d2\u00cf\3\2\2\2\u00d3\r\3\2\2\2\u00d4\u00d5\b\b\1\2\u00d5\u00db"+
		"\7\4\2\2\u00d6\u00d7\5\f\7\2\u00d7\u00d8\b\b\1\2\u00d8\u00da\3\2\2\2\u00d9"+
		"\u00d6\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7\f\2\2\u00df"+
		"\17\3\2\2\2\u00e0\u00e1\7\20\2\2\u00e1\u00e2\7\6\2\2\u00e2\u00e3\5\30"+
		"\r\2\u00e3\u00e4\7\7\2\2\u00e4\u00e5\7\21\2\2\u00e5\u00e6\5\f\7\2\u00e6"+
		"\u00eb\b\t\1\2\u00e7\u00e8\7\22\2\2\u00e8\u00e9\5\f\7\2\u00e9\u00ea\b"+
		"\t\1\2\u00ea\u00ec\3\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\21\3\2\2\2\u00ed\u00ee\7\23\2\2\u00ee\u00ef\7\6\2\2\u00ef\u00f0\5\30"+
		"\r\2\u00f0\u00f1\7\7\2\2\u00f1\u00f2\5\f\7\2\u00f2\u00f3\b\n\1\2\u00f3"+
		"\23\3\2\2\2\u00f4\u00f5\7\24\2\2\u00f5\u00f6\7\6\2\2\u00f6\u00f7\5\30"+
		"\r\2\u00f7\u00f8\7\7\2\2\u00f8\u00f9\7\13\2\2\u00f9\u00fa\b\13\1\2\u00fa"+
		"\25\3\2\2\2\u00fb\u00fc\5\30\r\2\u00fc\u00fd\7\13\2\2\u00fd\u00fe\b\f"+
		"\1\2\u00fe\27\3\2\2\2\u00ff\u0100\5\32\16\2\u0100\u0101\b\r\1\2\u0101"+
		"\31\3\2\2\2\u0102\u0103\5\34\17\2\u0103\u0104\7\25\2\2\u0104\u0105\5\32"+
		"\16\2\u0105\u0106\b\16\1\2\u0106\u010b\3\2\2\2\u0107\u0108\5\34\17\2\u0108"+
		"\u0109\b\16\1\2\u0109\u010b\3\2\2\2\u010a\u0102\3\2\2\2\u010a\u0107\3"+
		"\2\2\2\u010b\33\3\2\2\2\u010c\u010d\5 \21\2\u010d\u010e\5\36\20\2\u010e"+
		"\u010f\b\17\1\2\u010f\35\3\2\2\2\u0110\u0111\7\26\2\2\u0111\u0112\5 \21"+
		"\2\u0112\u0113\5\36\20\2\u0113\u0114\b\20\1\2\u0114\u0117\3\2\2\2\u0115"+
		"\u0117\b\20\1\2\u0116\u0110\3\2\2\2\u0116\u0115\3\2\2\2\u0117\37\3\2\2"+
		"\2\u0118\u0119\5$\23\2\u0119\u011a\5\"\22\2\u011a\u011b\b\21\1\2\u011b"+
		"!\3\2\2\2\u011c\u011d\7\27\2\2\u011d\u011e\5$\23\2\u011e\u011f\5\"\22"+
		"\2\u011f\u0120\b\22\1\2\u0120\u0123\3\2\2\2\u0121\u0123\b\22\1\2\u0122"+
		"\u011c\3\2\2\2\u0122\u0121\3\2\2\2\u0123#\3\2\2\2\u0124\u0125\5(\25\2"+
		"\u0125\u0126\5&\24\2\u0126\u0127\b\23\1\2\u0127%\3\2\2\2\u0128\u0129\7"+
		"\30\2\2\u0129\u012d\b\24\1\2\u012a\u012b\7\31\2\2\u012b\u012d\b\24\1\2"+
		"\u012c\u0128\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f"+
		"\5(\25\2\u012f\u0130\5&\24\2\u0130\u0131\b\24\1\2\u0131\u0134\3\2\2\2"+
		"\u0132\u0134\b\24\1\2\u0133\u012c\3\2\2\2\u0133\u0132\3\2\2\2\u0134\'"+
		"\3\2\2\2\u0135\u0136\5,\27\2\u0136\u0137\5*\26\2\u0137\u0138\b\25\1\2"+
		"\u0138)\3\2\2\2\u0139\u013a\7\32\2\2\u013a\u013e\b\26\1\2\u013b\u013c"+
		"\7\33\2\2\u013c\u013e\b\26\1\2\u013d\u0139\3\2\2\2\u013d\u013b\3\2\2\2"+
		"\u013e\u013f\3\2\2\2\u013f\u0140\5,\27\2\u0140\u0141\5*\26\2\u0141\u0142"+
		"\b\26\1\2\u0142\u0145\3\2\2\2\u0143\u0145\b\26\1\2\u0144\u013d\3\2\2\2"+
		"\u0144\u0143\3\2\2\2\u0145+\3\2\2\2\u0146\u0147\5\60\31\2\u0147\u0148"+
		"\5.\30\2\u0148\u0149\b\27\1\2\u0149-\3\2\2\2\u014a\u014b\7\34\2\2\u014b"+
		"\u014f\b\30\1\2\u014c\u014d\7\35\2\2\u014d\u014f\b\30\1\2\u014e\u014a"+
		"\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\5\60\31\2"+
		"\u0151\u0152\5.\30\2\u0152\u0153\b\30\1\2\u0153\u0156\3\2\2\2\u0154\u0156"+
		"\b\30\1\2\u0155\u014e\3\2\2\2\u0155\u0154\3\2\2\2\u0156/\3\2\2\2\u0157"+
		"\u0158\5\64\33\2\u0158\u0159\5\62\32\2\u0159\u015a\b\31\1\2\u015a\61\3"+
		"\2\2\2\u015b\u015c\7\36\2\2\u015c\u0160\b\32\1\2\u015d\u015e\7\37\2\2"+
		"\u015e\u0160\b\32\1\2\u015f\u015b\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0161"+
		"\3\2\2\2\u0161\u0162\5\64\33\2\u0162\u0163\5\62\32\2\u0163\u0164\b\32"+
		"\1\2\u0164\u0167\3\2\2\2\u0165\u0167\b\32\1\2\u0166\u015f\3\2\2\2\u0166"+
		"\u0165\3\2\2\2\u0167\63\3\2\2\2\u0168\u016d\b\33\1\2\u0169\u016a\7 \2"+
		"\2\u016a\u016e\b\33\1\2\u016b\u016c\7\35\2\2\u016c\u016e\b\33\1\2\u016d"+
		"\u0169\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\5\64"+
		"\33\2\u0170\u0171\b\33\1\2\u0171\u0176\3\2\2\2\u0172\u0173\5\66\34\2\u0173"+
		"\u0174\b\33\1\2\u0174\u0176\3\2\2\2\u0175\u0168\3\2\2\2\u0175\u0172\3"+
		"\2\2\2\u0176\65\3\2\2\2\u0177\u0178\5:\36\2\u0178\u0179\58\35\2\u0179"+
		"\u017a\b\34\1\2\u017a\67\3\2\2\2\u017b\u017c\7!\2\2\u017c\u017d\5\30\r"+
		"\2\u017d\u017e\7\"\2\2\u017e\u017f\b\35\1\2\u017f\u0182\3\2\2\2\u0180"+
		"\u0182\b\35\1\2\u0181\u017b\3\2\2\2\u0181\u0180\3\2\2\2\u01829\3\2\2\2"+
		"\u0183\u0184\5> \2\u0184\u0185\5<\37\2\u0185\u0186\b\36\1\2\u0186;\3\2"+
		"\2\2\u0187\u0188\b\37\1\2\u0188\u0189\7#\2\2\u0189\u01a1\b\37\1\2\u018a"+
		"\u018b\5B\"\2\u018b\u018c\b\37\1\2\u018c\u018d\7\6\2\2\u018d\u018e\7\7"+
		"\2\2\u018e\u01a2\3\2\2\2\u018f\u0190\5B\"\2\u0190\u0191\b\37\1\2\u0191"+
		"\u0192\7\6\2\2\u0192\u0193\5\30\r\2\u0193\u019a\b\37\1\2\u0194\u0195\7"+
		"\17\2\2\u0195\u0196\5\30\r\2\u0196\u0197\b\37\1\2\u0197\u0199\3\2\2\2"+
		"\u0198\u0194\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b"+
		"\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\7\7\2\2\u019e"+
		"\u01a2\3\2\2\2\u019f\u01a0\7$\2\2\u01a0\u01a2\b\37\1\2\u01a1\u018a\3\2"+
		"\2\2\u01a1\u018f\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a4\5<\37\2\u01a4\u01a5\b\37\1\2\u01a5\u01a8\3\2\2\2\u01a6\u01a8\b"+
		"\37\1\2\u01a7\u0187\3\2\2\2\u01a7\u01a6\3\2\2\2\u01a8=\3\2\2\2\u01a9\u01aa"+
		"\7+\2\2\u01aa\u01ce\b \1\2\u01ab\u01ac\7,\2\2\u01ac\u01ce\b \1\2\u01ad"+
		"\u01ae\7%\2\2\u01ae\u01af\7\t\2\2\u01af\u01b0\7!\2\2\u01b0\u01b1\7+\2"+
		"\2\u01b1\u01b2\7\"\2\2\u01b2\u01ce\b \1\2\u01b3\u01b4\7%\2\2\u01b4\u01b5"+
		"\5B\"\2\u01b5\u01b6\7\6\2\2\u01b6\u01b7\7\7\2\2\u01b7\u01b8\b \1\2\u01b8"+
		"\u01ce\3\2\2\2\u01b9\u01ba\7&\2\2\u01ba\u01ce\b \1\2\u01bb\u01bc\7\'\2"+
		"\2\u01bc\u01ce\b \1\2\u01bd\u01be\7(\2\2\u01be\u01ce\b \1\2\u01bf\u01c0"+
		"\5B\"\2\u01c0\u01c1\b \1\2\u01c1\u01ce\3\2\2\2\u01c2\u01c3\5B\"\2\u01c3"+
		"\u01c4\7!\2\2\u01c4\u01c5\5\30\r\2\u01c5\u01c6\7\"\2\2\u01c6\u01c7\b "+
		"\1\2\u01c7\u01ce\3\2\2\2\u01c8\u01c9\7\6\2\2\u01c9\u01ca\5\30\r\2\u01ca"+
		"\u01cb\7\7\2\2\u01cb\u01cc\b \1\2\u01cc\u01ce\3\2\2\2\u01cd\u01a9\3\2"+
		"\2\2\u01cd\u01ab\3\2\2\2\u01cd\u01ad\3\2\2\2\u01cd\u01b3\3\2\2\2\u01cd"+
		"\u01b9\3\2\2\2\u01cd\u01bb\3\2\2\2\u01cd\u01bd\3\2\2\2\u01cd\u01bf\3\2"+
		"\2\2\u01cd\u01c2\3\2\2\2\u01cd\u01c8\3\2\2\2\u01ce?\3\2\2\2\u01cf\u01d0"+
		"\7\t\2\2\u01d0\u01dd\b!\1\2\u01d1\u01d2\7)\2\2\u01d2\u01dd\b!\1\2\u01d3"+
		"\u01d4\7*\2\2\u01d4\u01dd\b!\1\2\u01d5\u01d6\7\t\2\2\u01d6\u01d7\7!\2"+
		"\2\u01d7\u01d8\7\"\2\2\u01d8\u01dd\b!\1\2\u01d9\u01da\5B\"\2\u01da\u01db"+
		"\b!\1\2\u01db\u01dd\3\2\2\2\u01dc\u01cf\3\2\2\2\u01dc\u01d1\3\2\2\2\u01dc"+
		"\u01d3\3\2\2\2\u01dc\u01d5\3\2\2\2\u01dc\u01d9\3\2\2\2\u01ddA\3\2\2\2"+
		"\u01de\u01df\7.\2\2\u01df\u01e0\b\"\1\2\u01e0C\3\2\2\2!Lbt|\u0084\u00a2"+
		"\u00a7\u00b2\u00ba\u00d2\u00db\u00eb\u010a\u0116\u0122\u012c\u0133\u013d"+
		"\u0144\u014e\u0155\u015f\u0166\u016d\u0175\u0181\u019a\u01a1\u01a7\u01cd"+
		"\u01dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}