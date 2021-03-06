package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * Weapon dropped from knocking off the arm of a Zombie. Can be crafted into a Zombie Club.
 * 
 * @author Daniel Yuen
 *
 */
public class ZombieArm extends WeaponItem{
	private Item craftItem;
	private boolean canCraft = true;
	
	public ZombieArm() {
		super("zombie arm", '/', 15, "smacks");
		this.craftItem = new ZombieClub();	
	}
	
	public Item getCraftItem() {
		return this.craftItem;
	}
	
	public void tick(Location currentLocation, Actor actor) {
		if (this.canCraft == true && this.getCraftItem() != null) {
			super.allowableActions.add(new CraftingAction(this));
			this.canCraft = false;
		}
	}
}
