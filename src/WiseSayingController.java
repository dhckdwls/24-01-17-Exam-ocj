import java.util.List;

public class WiseSayingController {
	
	private WiseSayingService wiseSayingService;
	
	public WiseSayingController() {
		this.wiseSayingService = new WiseSayingService();
	}
	
	public void write(int id,String wise,String author) {
		wiseSayingService.write(id,wise,author);
		
	}

	public List<WiseSaying> list() {
		return wiseSayingService.list();
		
	}

	public WiseSaying wiseSayingFoundById(int id) {
		return wiseSayingService.wiseSayingFoundById(id);
		
	}

}
