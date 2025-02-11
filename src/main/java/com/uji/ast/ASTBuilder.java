package com.uji.ast;

import com.uji.antlr_output.*;
import com.uji.util.ProcessedFmtString;
import java.util.List;
import java.util.ArrayList;


public class ASTBuilder implements ujiFileVisitor<ASTNode>  {
	@Override public ASTNode visitUjiFile(
		ujiFileParser.UjiFileContext ctx
	) {
		// return ASTProgram with 'bindings' set to ArrayList<ASTBinding> ... TODO
		return new ASTNode(1, 1, 2, 2);
	}

	@Override public ASTNode visitUjiMulBinding(
		ujiFileParser.UjiMulBindingContext ctx
	) {
		// visitChildren(ctx);
		System.out.println("binding key: " + ctx.key.getText());
		System.out.println("binding value: " + ctx.value.getText());

		return new ASTNode(1, 1, 2, 2);
	}

	@Override public ASTNode visitUjiOneCopy(
		ujiFileParser.UjiOneCopyContext ctx
	) {
		List<ASTNode> args = new ArrayList<>();
		for (int i = 1; i < ctx.getChildCount(); i += 1) {
			args.add(ctx.ujiPrimary(i).accept(this));
		}
		return new ASTCopy(
			ctx.ujiPrimary(0).accept(this),
			args,
			new ASTNodeFromRuleContext(ctx).value()
		);
	}

	@Override public ASTNode visitUjiLiteral(
		ujiFileParser.UjiLiteralContext ctx
	) {
		if (ctx.RAW_STRING() != null) {
			return new ASTString(
				ctx.RAW_STRING().getText(),
				new ASTNodeFromRuleContext(ctx).value()
			);
		}
		if (ctx.FMT_STRING() != null) {
			return new ASTString(
				new ProcessedFmtString(ctx.FMT_STRING().getText()).value(),
				new ASTNodeFromRuleContext(ctx).value()
			);
		}
		if (ctx.FLOAT() != null) {
			return new ASTFloat(
				ctx.FLOAT().getText(),
				new ASTNodeFromRuleContext(ctx).value()
			);
		}
		if (ctx.INT() != null) {
			return new ASTInt(
				ctx.INT().getText(),
				new ASTNodeFromRuleContext(ctx).value()
			);
		}
		assert(false);
		return null;
	}

	@Override public ASTNode visitEols(
		ujiFileParser.EolsContext ctx
	) {
		return null;
	}

	@Override public ASTNode visitIndent(
		ujiFileParser.IndentContext ctx
	) {
		return null;
	}

	@Override public ASTNode visitUnindent(
		ujiFileParser.UnindentContext ctx
	) {
		return null;
	}
}

