package battle;

import log.LogPrinter;

import java.util.ArrayList;

// 배틀 총괄 클래스
// 진행순서 : 보스 패턴 공개 > 러너 행동 > 러너 정산 > 보스 행동 정산 > 최종 정산
public class BattleManager {

    private ArrayList<CharacterMoveQueue> characterMoveQueues;
    private LogPrinter logPrinter;

    private final ArrayList<Boss> boss; // 인덱스 0번에 메인 보스
    public static int turnCounter;

    public BattleManager() {
        characterMoveQueues = new ArrayList<CharacterMoveQueue>();
        logPrinter = new LogPrinter();
        boss = new ArrayList<>();

        turnCounter = 0;
    }

    public BattleManager(Boss mainBoss) {
        characterMoveQueues = new ArrayList<CharacterMoveQueue>();
        logPrinter = new LogPrinter();
        boss = new ArrayList<>();

        turnCounter = 0;
        this.boss.addFirst(mainBoss);
    }

    public void printBattle() {
        logPrinter.exportTxt(this);
    }




    public ArrayList<CharacterMoveQueue> getCharacterMoveQueues() {
        return characterMoveQueues;
    }

    public void setCharacterMoveQueues(ArrayList<CharacterMoveQueue> characterMoveQueues) {
        this.characterMoveQueues = characterMoveQueues;
    }

    public LogPrinter getLogPrinter() {
        return logPrinter;
    }

    public void setLogPrinter(LogPrinter logPrinter) {
        this.logPrinter = logPrinter;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        BattleManager.turnCounter = turnCounter;
    }

    public Boss getMainBoss() {
        return boss.getFirst();
    }

    public void setMainBoss (Boss boss) {
        this.boss.set(0, boss);
    }

    public ArrayList<Boss> getBoss() {
        return boss;
    }


    public String toString() {
        return "=======전투 매니저 작동 중=======\n"
                + "보스 이름 : " + getMainBoss().getName()
                + "\n체력 : " + getMainBoss().getCurrentHp() + " / " + getMainBoss().getMaxHp()
                + "\n현재 턴수 : " + getTurnCounter()
                + "\n==============================";
    }

}
