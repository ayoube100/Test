package smsHandy;

import java.util.ArrayList;
import java.util.Date;

public abstract class SmsHandy {

	private String number;
	private Provider provider;
	private ArrayList<Message> sent;
	private ArrayList<Message> recieved;
	
	public SmsHandy(String number, Provider provider) {
		sent = new ArrayList<Message>();
		recieved = new ArrayList<Message>();
		this.number = number;
		this.provider = provider;
	}
	
	public void sendSms(String to, String content) {
		Date d = new Date();
		Message m = new Message(number, to, content, d);
		if(canSendSms()) {
			if(provider.send(m)) {
				sent.add(m);
			}
		}else {
			if (this instanceof PrepaidSmsHandy) {
				System.out.println("Sorry you can't send any more sms you ran out of balance.");
			} else if (this instanceof TariffPlanSmsHandy) {
				System.out.println("Sorry you can't send SMS your amount of free SMS is spent.");
			}
			
		}	
	}

	public abstract boolean canSendSms();
	public abstract void payForSms();
	
	public void sendSmsDirect(SmsHandy s, String content) {
		
	}
			
	public void receiveSms(Message m) {
		if(m != null) {
			recieved.add(m);
			System.out.println(m.toString());
		}	
	}
	
	public void listSent() {
		int i = 1;
		for(Message s : sent) {
			System.out.println("Message " + i + " : " + s.toString());
			i++;
		}
	}
	
	public void listReceived() {
		int i = 1;
		for(Message r : recieved) {
			System.out.println("Message " + i + " : " + r.toString());
			i++;
		}
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	
}
