package character;

import battle.Boss;

import static battle.BattleManager.turnCounter;

// 캐릭터 행동 결정용 클래스
public class CharacterMove {

    int duration; // 효과가 종료되는 턴
    Boss enemyTarget; // 타겟(적)
    Character allyTarget; // 타겟(아군)
    
    // 플래그
    boolean isAttack;
    boolean isDefense;
    boolean isHeal;
    boolean isBuff;
    boolean isDebuff;
    boolean isCharging;
    boolean isActive; // 버프/디버프 적용중인지?

    public CharacterMove() {
        isAttack = false;
        isDefense = false;
        isHeal = false;
        isBuff = false;
        isDebuff = false;
        isCharging = false;
        isActive = false;
    }

    /* ---- 일반 공격 ---- */
    
    public void attack(Character source, Boss target) {
        isAttack = true;
        enemyTarget = target;
        source.getMoves().add(this);
        duration = turnCounter;
    }

    public void defense(Character source, Character target) {
        isDefense = true;
        allyTarget = target;
        source.getMoves().add(this);
        duration = turnCounter;
    }

    public void heal(Character source, Character target) {
        isHeal = true;
        allyTarget = target;
        source.getMoves().add(this);
        duration = turnCounter;
    }

    public void buff(Character source, Character target) {
        isBuff = true;
        allyTarget = target;
        source.getMoves().add(this);
        duration = turnCounter;
    }

    public void debuff(Character source, Boss target) {
        isDebuff = true;
        enemyTarget = target;
        source.getMoves().add(this);
        duration = turnCounter;
    }


    /* ---- 2턴 이상 지속 ---- */

    public void attack(Character source, Boss target, int duration) {
        isAttack = true;
        enemyTarget = target;
        source.getMoves().add(this);
        this.duration = turnCounter + duration - 1;
    }

    public void defense(Character source, Character target, int duration) {
        isDefense = true;
        allyTarget = target;
        source.getMoves().add(this);
        this.duration = turnCounter + duration - 1;
    }

    public void heal(Character source, Character target, int duration) {
        isHeal = true;
        allyTarget = target;
        source.getMoves().add(this);
        this.duration = turnCounter + duration - 1;
    }
    
    public void buff(Character source, Character target, int duration) {
        isBuff = true;
        allyTarget = target;
        source.getMoves().add(this);
        this.duration = turnCounter + duration - 1;
    }

    public void debuff(Character source, Boss target, int duration) {
        isDebuff = true;
        enemyTarget = target;
        source.getMoves().add(this);
        this.duration = turnCounter + duration - 1;
    }


    /* ---- 차징 ---- */





    /* ---- getter & setter ---- */

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Boss getEnemyTarget() {
        return enemyTarget;
    }

    public void setEnemyTarget(Boss enemyTarget) {
        this.enemyTarget = enemyTarget;
    }

    public Character getAllyTarget() {
        return allyTarget;
    }

    public void setAllyTarget(Character allyTarget) {
        this.allyTarget = allyTarget;
    }

    public boolean isAttack() {
        return isAttack;
    }

    public void setAttack(boolean attack) {
        isAttack = attack;
    }

    public boolean isDefense() {
        return isDefense;
    }

    public void setDefense(boolean defense) {
        isDefense = defense;
    }

    public boolean isHeal() {
        return isHeal;
    }

    public void setHeal(boolean heal) {
        isHeal = heal;
    }

    public boolean isBuff() {
        return isBuff;
    }

    public void setBuff(boolean buff) {
        isBuff = buff;
    }

    public boolean isDebuff() {
        return isDebuff;
    }

    public void setDebuff(boolean debuff) {
        isDebuff = debuff;
    }

    public boolean isCharging() {
        return isCharging;
    }

    public void setCharging(boolean charging) {
        isCharging = charging;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
