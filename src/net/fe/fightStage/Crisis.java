package net.fe.fightStage;

import net.fe.rng.RNG;
import net.fe.unit.Unit;

// TODO: Auto-generated Javadoc
/**
 * The Class Crisis.
 */
public class Crisis extends CombatTrigger{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new crisis.
	 * 
	 * Info: User's Avo becomes 30.
	 * 
	 * Chance: HP < 1/3 of total.
	 */
	public Crisis() {
		super(NO_NAME_MOD, YOUR_TURN_PRE + ENEMY_TURN_PRE);
	}

	/* (non-Javadoc)
	 * @see net.fe.fightStage.CombatTrigger#attempt(net.fe.unit.Unit, int)
	 */
	@Override
	public boolean attempt(Unit user, int range, Unit opponent, RNG rng) {
		return user.getHp() < user.getStats().maxHp/3;
	}

	/* (non-Javadoc)
	 * @see net.fe.fightStage.CombatTrigger#runPreAttack(net.fe.fightStage.CombatCalculator, net.fe.unit.Unit, net.fe.unit.Unit)
	 */
	@Override
	public boolean runPreAttack(CombatCalculator calc, Unit a, Unit d) {
		a.setTempMod("Avo", 30);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see net.fe.fightStage.CombatTrigger#getCopy()
	 */
	public CombatTrigger getCopy(){
		return new Crisis();
	}

}
