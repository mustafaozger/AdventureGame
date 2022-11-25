public class Character
{
    private String charName;
    private int id=0;
    private int damage;
    private int health;
    private int totalHealth;
    private int money;

    public Character(String charName, int id, int damage, int totalHealth, int money)
    {
        this.charName=charName;
        this.id=id;
        this.damage=damage;
        this.health=totalHealth;
        this.money=money;
        this.totalHealth=totalHealth;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getTotalHealth(){
        return this.totalHealth;
    }
    public void setTotalHealth(int totalHealth){
        this.totalHealth=totalHealth;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getCharName(){
        return charName;}
    public void setCharName(String charName){
        this.charName=charName;}
    public int getId(){
        return id;}
    public void setId(int id){
        this.id=id;}

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



}
