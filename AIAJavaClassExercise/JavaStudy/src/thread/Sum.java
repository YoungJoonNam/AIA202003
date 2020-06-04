package thread;

public class Sum {
	long num;

	public Sum() {
		num = 0;
	}

	public void addNum(long n) {
		num += n;
	}

	public long getNum() {
		return num;
	}
}
