package org.eclipse.example.calc.internal.operations;

import org.eclipse.example.calc.UnaryOperation;

/**
 * Cosine operation
 */
public class Cosine extends AbstractOperation implements UnaryOperation {

	@Override
	public String getName() {
		return "cos";
	}

	@Override
	public float perform(float arg1) {
		return (float) Math.cos(arg1);
	}

}
