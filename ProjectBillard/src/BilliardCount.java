
public class BilliardCount {

	private int num;
	private int tableNum;
	private String time;
	private int charge;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public BilliardCount(int num, int tableNum, String time, int charge) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.tableNum= tableNum;
		this.time = time;
		this.charge = charge;
	}

}
