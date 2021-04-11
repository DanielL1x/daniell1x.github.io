package org.eclipse.example.calc.internal.operations;

import org.eclipse.example.calc.UnaryOperation;

/**
 * Tangent operation
 */
public class Tangent extends AbstractOperation implements UnaryOperation {

	@Override
	public String getName() {
		return "tan";
	}

	@Override
	public float perform(float arg1) {
		return (float) Math.tan(arg1);
	}

}