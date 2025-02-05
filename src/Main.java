import battle.*;
import character.Character;

public class Main {
    public static void main(String[] args) {

        // 보스 패턴 공개, 러너 행동, 러너 정산, 보스 행동 정산, 최종 정산
        // 러너 행동 계산 우선순위는 FIFO

        // 스킬 등록 할 수 있는 기능...


        // 테스트
        // 보스 생성
        Boss boss = new Boss("텔루스", 100000);

        // 캐릭터 생성
        Character character = new Character("뉴주", 100, 40, 30, 0);

        // 배틀 매니저 생성, 보스 등록
        BattleManager battleManager = new BattleManager(boss);
        System.out.println(battleManager.toString());
        battleManager.printBattle();


    }
}