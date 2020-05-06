package thread;

public class AdderThread extends Sum implements Runnable {

	int start, end;

	public AdderThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i=start; i<=end; i++)
			addNum(i);
	}

}
