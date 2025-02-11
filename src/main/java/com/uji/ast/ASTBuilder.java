package com.uji.ast;

import com.uji.antlr_output.*;
import com.uji.util.ProcessedFmtString;
import java.util.List;
import java.util.ArrayList;


public class ASTBuilder implements ujiFileVisitor<ASTNode>  {
	@Override public ASTNode visitUjiFile(
		ujiFileParser.UjiFileContext ctx
	) {
		List<ASTBinding> bindings = new ArrayList<>();
		for (int i = 0; i < ctx.ujiMulBinding().size(); i += 1) {
			ASTNode node = ctx.ujiMulBinding(i).accept(this);
			if (!(node instanceof ASTBinding)) {
				assert(false);
			}
			bindings.add((ASTBinding)node);
		}
		return new ASTProgram(
			bindings,
			new ASTNodeFromRuleContext(ctx).value()
		);
	}

	@Override public ASTNode visitUjiMulCopyMulOption(
		ujiFileParser.UjiMulCopyMulOptionContext ctx
	) {
		List<ASTNode> args = new ArrayList<>();
		for (int i = 1; i < ctx.ujiMulRvalue().size(); i += 1) {
			args.add(ctx.ujiMulRvalue(i).accept(this));
		}
		return new ASTCopy(
			ctx.ujiPrimary().accept(this),
			args,
			new ASTNodeFromRuleContext(ctx).value()
		);
	}

	@Override public ASTNode visitUjiOneCopy(
		ujiFileParser.UjiOneCopyContext ctx
	) {
		List<ASTNode> args = new ArrayList<>();
		for (int i = 1; i < ctx.ujiPrimary().size(); i += 1) {
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

