import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Main {
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		ExprLexer lexer = new ExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);
		// ParseTree tree = parser.init();
		// System.out.println(tree.toStringTree(parser));
	}
}

