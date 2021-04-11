package org.eclipse.example.calc.internal.operations;

import org.eclipse.example.calc.UnaryOperation;

/**
 * Cosine Inverse operation
 */
public class CosineInverse extends AbstractOperation implements UnaryOperation {

	@Override
	public String getName() {
		return "cosInv";
	}

	@Override
	public float perform(float arg1) {
		return (float) Math.acos(arg1);
	}

}