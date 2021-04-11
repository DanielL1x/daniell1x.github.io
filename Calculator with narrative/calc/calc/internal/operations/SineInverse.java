package org.eclipse.example.calc.internal.operations;

import org.eclipse.example.calc.UnaryOperation;

/**
 * Sine Inverse operation
 */
public class SineInverse extends AbstractOperation implements UnaryOperation {

	@Override
	public String getName() {
		return "sinInv";
	}

	@Override
	public float perform(float arg1) {
		return (float) Math.asin(arg1);
	}

}
