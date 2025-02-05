package battle;
import character.Character;

import java.util.ArrayList;

public class CharacterMoveQueue {
    
    // 캐릭터에 있는 캐릭터들의 무브 ArrayList를 가져와서 읽을 것.
    // 캐릭터들 입력 순서에 맞게 줄 세우는 곳.
    ArrayList<Character> moves;

    CharacterMoveQueue() {
        moves = new ArrayList<>();
    }
    
    
    // 캐릭터 검색
    public Character searchCharacter(Character c) {
        for (Character ch : moves) {
            if (ch.equals(c)) {
                return ch;
            }
        }
        return null;
    }

}
