package integer;

import java.nio.ByteBuffer;
import java.util.UUID;

public class uniqueRandom {

	// first way
	private static long startTime = System.currentTimeMillis();
	private static long id;

	public static synchronized String getUniqueID() {
		return "id." + startTime + "." + id++;
	}

	// second
	private static int staticCounter = 0;
	private final int nBits = 4;

	public long getUnique() {
		return (System.currentTimeMillis() << nBits) | (staticCounter++ & 2 ^ nBits - 1);
	}

	/*
	 * When I've had to generate them I typically use a MD5 hashsum of the
	 * current date time, the user name and the IP address of the computer.
	 * Basically the idea is to take everything that you can find out about the
	 * computer/person and then generate a MD5 hash of this information.
	 * 
	 * It works really well and is incredibly fast (once you've initialised the
	 * MessageDigest for the first time).
	 */

	public static void main(String[] args) {

		String s = uniqueRandom.getUniqueID();
		System.out.println(s);

		String uuid = UUID.randomUUID().toString();

		System.out.println("uuid = " + uuid);

		UUID myuuid = UUID.randomUUID();
		long highbits = myuuid.getMostSignificantBits();
		long lowbits = myuuid.getLeastSignificantBits();
		System.out.println("My UUID is: " + highbits + " " + lowbits);

		long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
		System.out.println(Long.toString(l, Character.MAX_RADIX));
	}

	/*
	 * static Random rnd = new Random();
	 * 
	 * public static void main(String args[]) { Collection<Integer>
	 * alreadyChosen = new HashSet<Integer>(); for (int i = 0; i < 10; i++) {
	 * System.out.println(getNextUniqueRandom(alreadyChosen)); } }
	 * 
	 * public static int getNextUniqueRandom(Collection<Integer> alreadyChosen)
	 * { if (alreadyChosen.size() == 90000) { // hardcoded 5 figure numbers, //
	 * consider making a variable throw new
	 * RuntimeException("All 5 figure IDs used"); }
	 * 
	 * boolean unique = false; int value = 0; while (unique == false) { value =
	 * rnd.nextInt(90000) + 10000; unique = !alreadyChosen.contains(value); }
	 * alreadyChosen.add(value); return value; }
	 */

}
