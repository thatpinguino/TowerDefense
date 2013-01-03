public abstract class Enemy {
    
    private int speed;
    private int hp;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void move(){
        
    }
    
    public void doMoveAnimation(){
        
    }
    
    public void die (){
        
    }
    
    private void doDeathAnimation(){
        
    }
}
