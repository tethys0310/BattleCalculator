package character;

import battle.BattleManager;

import java.util.ArrayList;

public class Character {

    private String name; // 이름

    private int maxHp; // 체력
    private int currentHp; // 현재 체력
    private int atk; // 공격력
    private int def; // 방어력
    private int heal; // 치유력

    private float buffHp; // 체력 증가
    private float buffAtk; // 공격력 증가
    private float buffDef; // 방어력 증가

    private int shield; // 보호막
    private boolean isImmortal; // 불사상태인지?
    private boolean isInvincible; // 체력 안 닳는 상태인지?

    private ArrayList<CharacterMove> moves;

    public Character(String name, int hp, int atk, int def, int heal) {
      this.name = name;
      this.maxHp = hp;
      this.currentHp = hp;
      this.atk = atk;
      this.def = def;
      this.heal = heal;

      buffHp = 1.0F;
      buffAtk = 1.0F;
      buffDef = 1.0F;

      shield = 0;
      isImmortal = false;
      isInvincible = false;
    };

    // 캐릭터 무브 검토하는 함수.
    // duration이 같으면 - 공격, 방어, 도트힐: 효과 부여, 버프/디버프: isActive 체크
    // duration이 크면 - isActive 체크
    // duration이 작으면 - 삭제
    public void checkMyMove() {
        for (int index = moves.size() - 1; index >= 0; index--)  {
            CharacterMove move = moves.get(index);

            if (move.getDuration() == BattleManager.turnCounter) { // 지금 턴
                if (!move.isActive) { // 버프 또는 디버프의 경우
                    // 버프/디버프 효과 적용
                    if (move.isBuff || move.isDebuff) move.setActive(true);
                }
                // 공격
                // 방어
                // 힐

            }
            else if (move.getDuration() > BattleManager.turnCounter) { // 미래 턴
                if (!move.isActive) { // 버프 또는 디버프의 경우
                    // 버프/디버프 효과 적용
                    if (move.isBuff || move.isDebuff) move.setActive(true);
                }
                // 공격
                // 방어
                // 힐
            }
            else { // 지난 턴
                eraseMyMove(index);
            }
        }
    }

    //캐릭터 무브 검토 후 걸리면 버프나 보호막 초기화시키는 함수. 
    //버프 중첩은 합연산.
    private void eraseMyMove(int index) {
        if (moves.get(index).isBuff || moves.get(index).isDebuff) {
            // 버프 디버프 내역 빼줘야함
        }
        moves.remove(index);
    }

    
    



    /* ---- getter & setter ----*/


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

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public float getBuffHp() {
        return buffHp;
    }

    public void setBuffHp(float buffHp) {
        this.buffHp = buffHp;
    }

    public float getBuffAtk() {
        return buffAtk;
    }

    public void setBuffAtk(float buffAtk) {
        this.buffAtk = buffAtk;
    }

    public float getBuffDef() {
        return buffDef;
    }

    public void setBuffDef(float buffDef) {
        this.buffDef = buffDef;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public ArrayList<CharacterMove> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<CharacterMove> moves) {
        this.moves = moves;
    }

    public boolean isImmortal() {
        return isImmortal;
    }

    public void setImmortal(boolean immortal) {
        isImmortal = immortal;
    }

    public boolean isInvincible() {
        return isInvincible;
    }

    public void setInvincible(boolean invincible) {
        isInvincible = invincible;
    }

}
