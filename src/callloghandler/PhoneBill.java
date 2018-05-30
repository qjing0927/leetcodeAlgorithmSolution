package callloghandler;

public class PhoneBill {

	private String phoneNumber;
	private int duration;
	private int costForThisPhone;

	public PhoneBill(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.duration = 0;
		this.costForThisPhone = 0;
	}

	public void updateCostForThisPhone(int durationInSeconds) {
		int cost = this.getCostForThisPhone();

		if (durationInSeconds < 300) {
			cost += durationInSeconds * 3;
		} else {
			if (durationInSeconds % 60 == 0) {
				cost += durationInSeconds / 60 * 150;
			} else {
				cost += durationInSeconds / 60 * 150 + 150;
			}
		}

		this.setCostForThisPhone(cost);
		this.setDuration(this.getDuration() + durationInSeconds);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCostForThisPhone() {
		return costForThisPhone;
	}

	public void setCostForThisPhone(int costForThisPhone) {
		this.costForThisPhone = costForThisPhone;
	}
}
