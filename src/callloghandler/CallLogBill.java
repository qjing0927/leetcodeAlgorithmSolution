package callloghandler;

import java.util.HashMap;
import java.util.Map;

public class CallLogBill {

	public static void main(String[] args) {
		String s = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";
		int cost = new CallLogBill().callLogBill(s);

		System.out.println(cost);
	}

	public int callLogBill(String callLophoneBill) {

		int totalCost = 0;
		int longestDuration = 0;
		String promotionPhoneNumber = null;

		String[] phoneRecords = callLophoneBill.split("\n");

		HashMap<String, PhoneBill> phoneToPhoneBillMap = new HashMap<String, PhoneBill>();

		for (int i = 0; i < phoneRecords.length; i++) {
			String duration = phoneRecords[i].split(",")[0];
			String phoneNumber = phoneRecords[i].split(",")[1];

			// duration into String[]
			int durationInSeconds = Integer.parseInt(duration.split(":")[0]) * 3600
					+ Integer.parseInt(duration.split(":")[1]) * 60 + Integer.parseInt(duration.split(":")[2]);

			PhoneBill current = null;

			if (phoneToPhoneBillMap.containsKey(phoneNumber)) {
				current = phoneToPhoneBillMap.get(phoneNumber);
				current.updateCostForThisPhone(durationInSeconds);
			} else {
				current = new PhoneBill(phoneNumber);
				current.updateCostForThisPhone(durationInSeconds);
				phoneToPhoneBillMap.put(phoneNumber, current);
			}

			// if phoneBillEntry duration>longest Duration
			if (current.getDuration() > longestDuration) {
				promotionPhoneNumber = phoneNumber;
				longestDuration = current.getDuration();
			}
			// if there is a tie
			if (current.getDuration() == longestDuration && phoneNumber.compareTo(promotionPhoneNumber) < 0) {
				promotionPhoneNumber = phoneNumber;
				longestDuration = current.getDuration();
			}

		}

		// if a promotion can be applied
		if (phoneToPhoneBillMap.size() > 1) {
			phoneToPhoneBillMap.remove(promotionPhoneNumber);
		}

		for (Map.Entry<String, PhoneBill> phoneToPhoneBillEntry : phoneToPhoneBillMap.entrySet()) {
			totalCost += phoneToPhoneBillEntry.getValue().getCostForThisPhone();
		}

		return totalCost;

	}

}
