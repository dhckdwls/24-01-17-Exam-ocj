import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int lastId = 0;
		List<WiseSaying> wiseSayings = new ArrayList<>();

		System.out.println("==명언 앱 실행==");
		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine();

			if (cmd.equals("종료")) {
				System.out.println("명언 앱 종료");
				break;
			}

			if (cmd.equals("등록")) {
				int id = lastId + 1;
				System.out.print("명언 : ");
				String wise = sc.nextLine();
				System.out.print("작가 : ");
				String author = sc.nextLine();

				WiseSaying wiseSaying = new WiseSaying(id, wise, author);
				wiseSayings.add(wiseSaying);

				System.out.println(id + "번 명언이 등록되었습니다");
				lastId++;
			} else if (cmd.equals("목록")) {
				if (wiseSayings.size() == 0) {
					System.out.println("등록된 명언이 없습니다");
					continue;
				}

				System.out.println("번호  /  작가  /  명언");
				for (int i = wiseSayings.size() - 1; i >= 0; i--) {
					System.out.printf("%d  /  %s  /  %s  \n", wiseSayings.get(i).getId(),
							wiseSayings.get(i).getAuthor(), wiseSayings.get(i).getWise());
				}

			} else if (cmd.startsWith("수정")) {
				//수정?id=1
				String[] cmdBits = cmd.split("\\?", 2);

				if (cmdBits.length == 1) {
					System.out.println("에러1 명령어를 다시 입력하세요");
					continue;
				}

				String[] cmdBits2 = cmdBits[1].split("=", 2);
				if (cmdBits2.length == 1) {
					System.out.println("에러2 명령어를 다시 입력하세요");
					continue;
				}

				if (!cmdBits2[0].equals("id")) {
					System.out.println("에러3 명령어를 다시 입력하세요");
					continue;
				}

				int id = -1;

				try {
					id = Integer.parseInt(cmdBits2[1]);
				} catch (Exception e) {
					System.out.println("에러4 올바른 번호를 입력하세요");
					continue;
				}
				
				//명령어 쪼개기
				WiseSaying wiseSaying = null;

				for (WiseSaying foundWiseSaying : wiseSayings) {
					if (foundWiseSaying.getId() == id) {
						wiseSaying = foundWiseSaying;
						break;
					}
				}

				if (wiseSaying == null) {
					System.out.println(id + "번 명언은 없습니다");
					continue;
				} else {
					System.out.printf("명언(기존) : %s\n",wiseSaying.getWise());
					System.out.printf("작가(기존) : %s\n",wiseSaying.getAuthor());
					System.out.print("새 명언 : ");
					String wise = sc.nextLine();
					System.out.print("새 작가 : ");
					String author = sc.nextLine();
					
					wiseSaying.setWise(wise);
					wiseSaying.setAuthor(author);
					
					System.out.println(id + "번 명언이 수정되었습니다");
				}
				

			} else if (cmd.startsWith("삭제")) {
				// 삭제?id=3
				String[] cmdBits = cmd.split("\\?", 2);

				if (cmdBits.length == 1) {
					System.out.println("에러1 명령어를 다시 입력하세요");
					continue;
				}

				String[] cmdBits2 = cmdBits[1].split("=", 2);
				if (cmdBits2.length == 1) {
					System.out.println("에러2 명령어를 다시 입력하세요");
					continue;
				}

				if (!cmdBits2[0].equals("id")) {
					System.out.println("에러3 명령어를 다시 입력하세요");
					continue;
				}

				int id = -1;

				try {
					id = Integer.parseInt(cmdBits2[1]);
				} catch (Exception e) {
					System.out.println("에러4 올바른 번호를 입력하세요");
					continue;
				}

				// 명령어 쪼개기
				WiseSaying wiseSaying = null;

				for (WiseSaying foundWiseSaying : wiseSayings) {
					if (foundWiseSaying.getId() == id) {
						wiseSaying = foundWiseSaying;
						break;
					}
				}

				if (wiseSaying == null) {
					System.out.println(id + "번 명언은 없습니다");
					continue;
				} else {
					wiseSayings.remove(wiseSaying);
					System.out.println(id + "번 명언이 삭제되었습니다");
				}
			} else {
				System.out.println("그런 명령어는 없습니다");
			}
		}

		sc.close();
	}
}
