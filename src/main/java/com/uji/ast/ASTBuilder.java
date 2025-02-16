package com.uji.ast;

import com.uji.antlr.*;
import com.uji.util.ProcessedFmtString;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class ASTBuilder extends ujiFileBaseVisitor<ASTNode>  {

	// NOTE: this method was generated with chatgpt and is to be removed later.
	@Override public ASTNode visitErrorNode(ErrorNode node) {
			Token token = node.getSymbol();
			System.err.println("🚨 Error at line " + token.getLine() + ":" + token.getCharPositionInLine());
			System.err.println("🔹 Offending token: " + token.getText());
			return null;
	}

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

	@Override public ASTNode visitUjiMulBinding(
		ujiFileParser.UjiMulBindingContext ctx
	) {
		return new ASTBinding(
			ctx.ID().getText(),
			ctx.ujiMulRvalue().accept(this),
			new ASTNodeFromRuleContext(ctx).value()
		);
	}

	@Override public ASTNode visitUjiOneBinding(
		ujiFileParser.UjiOneBindingContext ctx
	) {
		return new ASTBinding(
			ctx.ID().getText(),
			ctx.ujiOneRvalue().accept(this),
			new ASTNodeFromRuleContext(ctx).value()
		);
	}

	@Override public ASTNode visitUjiMulRvalueMulDefOption(
		ujiFileParser.UjiMulRvalueMulDefOptionContext ctx
	) {
		return ctx.ujiMulDef().accept(this);
	}

	@Override public ASTNode visitUjiMulRvalueMulCopyOption(
		ujiFileParser.UjiMulRvalueMulCopyOptionContext ctx
	) {
		return ctx.ujiMulCopy().accept(this);
	}

	@Override public ASTNode visitUjiMulRvalueMulBindingOption(
		ujiFileParser.UjiMulRvalueMulBindingOptionContext ctx
	) {
		return ctx.ujiMulBinding().accept(this);
	}

	@Override public ASTNode visitUjiMulRvalueOneRvalueOption(
		ujiFileParser.UjiMulRvalueOneRvalueOptionContext ctx
	) {
		return ctx.ujiOneRvalue().accept(this);
	}

	@Override public ASTNode visitUjiOneRvalueOneBindingOption(
		ujiFileParser.UjiOneRvalueOneBindingOptionContext ctx
	) {
		return ctx.ujiOneBinding().accept(this);
	}

	@Override public ASTNode visitUjiOneRvalueOneCopyOption(
		ujiFileParser.UjiOneRvalueOneCopyOptionContext ctx
	) {
		return ctx.ujiOneCopy().accept(this);
	}

	@Override public ASTNode visitUjiOneRvalueOneDefOption(
		ujiFileParser.UjiOneRvalueOneDefOptionContext ctx
	) {
		return ctx.ujiOneDef().accept(this);
	}

	@Override public ASTNode visitUjiPrimaryBaseRvalueOption(
		ujiFileParser.UjiPrimaryBaseRvalueOptionContext ctx
	) {
		return ctx.rvalue.accept(this);
	}

	@Override public ASTNode visitUjiPrimaryBaseLiteralOption(
		ujiFileParser.UjiPrimaryBaseLiteralOptionContext ctx
	) {
		return ctx.literal.accept(this);
	}

	@Override public ASTNode visitUjiPrimaryBaseKeyOption(
		ujiFileParser.UjiPrimaryBaseKeyOptionContext ctx
	) {
		return new ASTKey(
			ctx.key.getText(),
			new ASTNodeFromTwoTokens(
				ctx.key,
				ctx.key
			).value()
		);
	}

	@Override public ASTNode visitUjiPrimary(
		ujiFileParser.UjiPrimaryContext ctx
	) {
		var baseCtx = ctx.ujiPrimaryBase();
		ASTNode baseNode = baseCtx.accept(this);

		// Creating ASTObject which represents object to be possibly binded
		ASTObject object = new ASTObject(
			baseNode,
			ctx.attrs.stream().map(a -> a.getText()).collect(Collectors.toList()),
			ctx.packed != null,
			new ASTNodeFromTwoRuleContexts(baseCtx, ctx).value()
		);

		// If object is to be binded then returning ASTBinding
		if (ctx.key != null) {
			return new ASTBinding(
				ctx.key.getText(),
				object,
				new ASTNodeFromRuleContext(ctx).value()
			);
		}
		// Otherwise return object itself (not binding because there's no key)
		return object;
	}

	@Override public ASTNode visitUjiMulDefShortOption(
		ujiFileParser.UjiMulDefShortOptionContext ctx
	) {
		return ctx.ujiShortMulDef().accept(this);
	}

	@Override public ASTNode visitUjiMulDefMulOption(
		ujiFileParser.UjiMulDefMulOptionContext ctx
	) {
		ASTNode paramsNode = ctx.ujiDefParams().accept(this);
		if (!(paramsNode instanceof ASTDefParams)) {
			assert(false);
		}
		List<ASTBinding> childrenBindings = new ArrayList<>();
		for (ujiFileParser.UjiMulBindingContext bctx : ctx.ujiMulBinding()) {
			ASTNode bindingNode = bctx.accept(this);
			if (!(bindingNode instanceof ASTBinding)) {
				assert(false);
			}
			childrenBindings.add((ASTBinding)bindingNode);
		}
		return new ASTDef(
			(ASTDefParams)paramsNode,
			ctx.ujiMulRvalue().accept(this),
			childrenBindings,
			new ASTNodeFromRuleContext(ctx).value()
		);
	}

	@Override public ASTNode visitUjiShortMulDefOneOption(
		ujiFileParser.UjiShortMulDefOneOptionContext ctx
	) {
		return ctx.ujiOneDef().accept(this);
	}

	@Override public ASTNode visitUjiShortMulDefMulOption(
		ujiFileParser.UjiShortMulDefMulOptionContext ctx
	) {
		ASTNode paramsNode = ctx.ujiDefParams().accept(this);
		if (!(paramsNode instanceof ASTDefParams)) {
			assert(false);
		}
		return new ASTDef(
			(ASTDefParams)paramsNode,
			ctx.ujiMulRvalue().accept(this),
			List.of(),
			new ASTNodeFromRuleContext(ctx).value()
		);
	}

	@Override public ASTNode visitUjiOneDef(
		ujiFileParser.UjiOneDefContext ctx
	) {
		ASTNode paramsNode = ctx.ujiDefParams().accept(this);
		if (!(paramsNode instanceof ASTDefParams)) {
			assert(false);
		}
		return new ASTDef(
			(ASTDefParams)paramsNode,
			ctx.ujiOneRvalue().accept(this),
			List.of(),
			new ASTNodeFromRuleContext(ctx).value()
		);
	}

	@Override public ASTNode visitUjiDefParams(
		ujiFileParser.UjiDefParamsContext ctx
	) {
		List<ASTBinding> bindings = new ArrayList<>();
		for (int i = 0; i < ctx.bindingKeys.size(); i += 1) {
			Token keyToken = ctx.bindingKeys.get(i);
			bindings.add(
				new ASTBinding(
					keyToken.getText(),
					ctx.bindingObjects.get(i).accept(this),
					new ASTNodeFromTwoTokens(
						keyToken,
						ctx.bindingObjects.get(i).getStop()
					).value()
				)
			);
		}

		return new ASTDefParams(
			ctx.keys.stream().map(t -> t.getText()).collect(Collectors.toList()),
			(ctx.packedKey == null ? "" : ctx.packedKey.getText()),
			bindings,
			new ASTNodeFromRuleContext(ctx).value()
		);
	}

	@Override public ASTNode visitUjiMulCopyOneOption(
		ujiFileParser.UjiMulCopyOneOptionContext ctx
	) {
		return ctx.ujiOneCopy().accept(this);
	}

	@Override public ASTNode visitUjiMulCopyMulOption(
		ujiFileParser.UjiMulCopyMulOptionContext ctx
	) {
		List<ASTNode> args = new ArrayList<>();
		for (int i = 0; i < ctx.ujiMulRvalue().size(); i += 1) {
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

