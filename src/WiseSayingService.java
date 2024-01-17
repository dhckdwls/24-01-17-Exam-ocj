import java.util.List;

public class WiseSayingService {
	private WiseSayingRepository wiseSayingRepository;
	
	public WiseSayingService() {
		this.wiseSayingRepository = new WiseSayingRepository();
	}

	public void write(int id, String wise, String author) {
		wiseSayingRepository.write(id, wise,author);
		
	}

	public List<WiseSaying> list() {
		return wiseSayingRepository.list();
		
	}

	public WiseSaying wiseSayingFoundById(int id) {
		return wiseSayingRepository.wiseSayingFoundById(id);
		
	}

	
}
