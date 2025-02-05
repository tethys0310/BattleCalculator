package battle;

public class Boss {

    private String name; // 이름
    private int maxHp; // 체력
    private int currentHp; // 현재 체력
    private float buffDamage; // 딜 증가 또는 감소

    public Boss(String name, int hp) {
        this.name = name;
        this.maxHp = hp;
        this.currentHp = hp;
        this.buffDamage = 1.0F;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public float getBuffDamage() {
        return buffDamage;
    }

    public void setBuffDamage(float buffDamage) {
        this.buffDamage = buffDamage;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
}
