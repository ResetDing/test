package prac0106;

public abstract class Pet {
	
	private Integer health;
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}
	public void addHealth(Integer health) {
		if(this.health == null) {
			this.health=0;
		}
		this.health += health;
	}
	public abstract void eat();

}
