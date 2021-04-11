package org.eclipse.example.calc.internal.operations;

import org.eclipse.example.calc.UnaryOperation;

/**
 * Tangent Inverse operation
 */
public class TangentInverse extends AbstractOperation implements UnaryOperation {

	@Override
	public String getName() {
		return "tanInv";
	}

	@Override
	public float perform(float arg1) {
		return (float) Math.atan(arg1);
	}

}