package log;

import battle.BattleManager;
import battle.CharacterMoveQueue;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class LogPrinter {

    Path documentsPath;
    // 배틀 매니저에서 캐릭터무브큐 받아 로그 출력해서 txt로 저장.
    // 양식은 날짜_보스 이름_현재 턴.txt

    public LogPrinter() {
        try {
            String userHome = System.getProperty("user.home");
            documentsPath = Paths.get(userHome, "자동 전투 계산기", "Log");
            Files.createDirectories(documentsPath);
        }
        catch (FileAlreadyExistsException ignored) {}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportTxt(BattleManager battleManager) {

        LocalDate date = LocalDate.now();
        String name = battleManager.getMainBoss().getName();
        int counter = battleManager.getTurnCounter();
        
        // 로그 저장 경로와 파일명 수정
        String fileFormat = date + "_" + name + "_" + counter + "턴";
        Path path = documentsPath.resolve(fileFormat + ".txt");

        try {
            if (!Files.exists(path)) {
                FileWriter fileWriter = new FileWriter(path.toFile());
                fileWriter.write("테스트!!");
                fileWriter.close();
            }
            else {
                throw new FileAlreadyExistsException("이미 오늘 같은 보스를 대상으로 계산한 내역이 있습니다.");
            }
        } catch (FileAlreadyExistsException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // 다른 IO 예외 처리
            e.printStackTrace();
        }
    }

    public void queueToString(CharacterMoveQueue moveQueue) {

    }

}
