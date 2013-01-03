public abstract class Tower {
    
    private int range;
    private int speed;
    private int power;
    private boolean enhanced;
    private int upgradeLevel;

    public boolean isEnhanced() {
        return enhanced;
    }

    public void setEnhanced(boolean enhanced) {
        this.enhanced = enhanced;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public void setUpgradeLevel(int upgradeLevel) {
        this.upgradeLevel = upgradeLevel;
    }
    
    //This method builds a tower at the provided x and y coordinates
    public void build(int x, int y){
        
    }
    //This method performs the build animation for each tower
    private void doBuildAnimation(){
        
    }
    //This method damages the provided enemy based on the current power and 
    //upgrade level of the current tower.  If the enemy's life is <= 0 then 
    //the enemy is killed and its death method is called.
    public void attack( Enemy e){
        this.doAttackAnimation();
        if((e.getHp() - (power * upgradeLevel)) > 0){
            e.setHp(e.getHp() - (power* upgradeLevel));
        }else{
            e.die();
        }
        
    }
    //This method performs the attack animation for each tower.
    private void doAttackAnimation(){
        
    }
}
