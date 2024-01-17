import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
	
	private List<WiseSaying> wiseSayings = new ArrayList<>();

	public void write(int id,String wise, String author) {
		wiseSayings.add(new WiseSaying(id,wise,author));
	}

	public List<WiseSaying> list() {
		return wiseSayings;
		
	}

	public WiseSaying wiseSayingFoundById(int id) {
		WiseSaying wiseSaying = null;
		for (WiseSaying foundWiseSaying : wiseSayings) {
			if (foundWiseSaying.getId() == id) {
				wiseSaying = foundWiseSaying;
				break;
			}
		}
		return wiseSaying;
	}
	
	
}
