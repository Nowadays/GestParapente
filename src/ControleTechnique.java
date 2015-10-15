/**
 * Created by deodexed on 15/10/2015.
 * Project name GestParapente
 */
public class ControleTechnique {

	private boolean ailes;
	private boolean suspense;
	private boolean sellette;
	private boolean casque;
	private boolean conclusion;

	public ControleTechnique(boolean ailes, boolean suspense, boolean sellette, boolean casque){
		this.ailes = ailes;
		this.suspense = suspense;
		this.sellette = sellette;
		this.casque = casque;
	}

	public boolean getTestAiles(){
		return this.ailes;
	}

	public boolean getTestSuspense(){
		return this.suspense;
	}

	public boolean getTestSellette(){
		return this.sellette;
	}

	public boolean getTestCasque(){
		return this.casque;
	}

	public boolean getControleTechniqueResultat(){
		return conclusion = this.getTestAiles() && this.getTestCasque() && this.getTestSellette() && this.getTestSuspense();
	}
}
