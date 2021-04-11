package org.eclipse.example.calc.internal.operations;

import org.eclipse.example.calc.UnaryOperation;

/**
 * Sine operation
 */
public class Sine extends AbstractOperation implements UnaryOperation {

	@Override
	public String getName() {
		return "sin";
	}

	@Override
	public float perform(float arg1) {
		return (float) Math.sin(arg1);
	}

}
