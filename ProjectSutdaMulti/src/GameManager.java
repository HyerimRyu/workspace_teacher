import java.io.ObjectInputStream.GetField;

import javax.management.monitor.MonitorSettingException;

class GameManager{
	
	int basicBet = 100000;
	
	int moneyCollection = 0;
	
	int moneySaved = 0;
	
	
	
	public GameManager() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	public int notifyBasicBet() {	
		moneySaved = 0;
		return basicBet;
	}
	
	public void collectBasicBet() {
		moneySaved += basicBet;
		moneyCollection += basicBet;
		
	}
	
	public int notifyHalf() {
		moneySaved = 0;
		return moneyCollection/2;
	}
	
	public void collectHalf() {
		
		moneySaved += moneyCollection/2;
		moneyCollection += moneyCollection/2;
	}
	
	
	
	public int notifyCall() {
		return moneySaved;
	}
	
	public void collectCall() {
		moneyCollection += moneySaved;
	}
	
	public void collectCall(int money) {
		moneyCollection += money;
	}
	
	public int notifyDadang() {
		return moneySaved*2;
	}
	
	public void collectDadang() {
		moneyCollection += moneySaved*2;
	}
	
	
	public int getMoneyCollection() {
		return moneyCollection;
	}
	
	public void resetGameManager() {
		moneyCollection = 0;
		moneySaved = 0;
		
	}
	
	public void collectAllin(int moneyLeft) {
		moneyCollection += moneyLeft;
	}

	
	
		
}