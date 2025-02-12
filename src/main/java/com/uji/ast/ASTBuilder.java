package com.uji.ast;

import com.uji.antlr_output.*;
import com.uji.util.ProcessedFmtString;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


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

	@Override public ASTNode visitUjiPrimary(
		ujiFileParser.UjiPrimaryContext ctx
	) {
		// Base object alternatives processing
		ASTNode primaryObject = null;
		Token primaryObjectToken = null;
		ParserRuleContext primaryObjectCtx = null;
		if (ctx.primaryRvalue != null) {
			primaryObjectCtx = ctx.primaryRvalue;
			primaryObject = primaryObjectCtx.accept(this);
		} else if (ctx.primaryLiteral != null) {
			primaryObjectCtx = ctx.primaryLiteral;
			primaryObject = primaryObjectCtx.accept(this);
		} else if (ctx.primaryKey != null) {
			primaryObjectToken = ctx.primaryKey;
			primaryObject = new ASTKey(
				primaryObjectToken.getText(),
				new ASTNodeFromTwoTokens(
					primaryObjectToken,
					primaryObjectToken
				).value()
			);
		}
		assert(primaryObject != null);

		// Calculating start token for base object
		Token startToken = null;
		if (primaryObjectCtx != null) {
			startToken = primaryObjectCtx.getStart();
		} else {
			assert(primaryObjectToken != null);
			startToken = primaryObjectToken;
		}

		// Calculating stop token for whole expression (ujiPrimary)
		Token stopToken = null;
		if (ctx.packed != null) {
			stopToken = ctx.packed;
		} else if (ctx.attrs.size() != 0) {
			stopToken = ctx.attrs.get(ctx.attrs.size()-1);
		} else {
			stopToken = primaryObjectCtx.getStop();
		}

		// Creating ASTObject which represents object to be possibly binded
		ASTObject object = new ASTObject(
			primaryObject,
			ctx.attrs.stream().map(a -> a.getText()).collect(Collectors.toList()),
			ctx.packed != null,
			new ASTNodeFromTwoTokens(startToken, stopToken).value()
		);

		// If object is to be binded then returhing ASTBinding
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
			ctx.packedKey.getText(),
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

