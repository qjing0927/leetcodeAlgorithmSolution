package practiseAlgrothim;

public class Primes {

	// https://codility.com/media/train/8-PrimeNumbers.pdf
	public int numberOfFactores(int N) {
		int result = 0;
		int factor = 1;

		while (factor * factor < N) {
			if (N % factor == 0)
				result += 2;
			factor++;
		}
		if (factor * factor == N)
			result += 1;

		return result;
	}

	// https://app.codility.com/demo/results/trainingEZZNG3-AHU/
	public int minPermeterRectangle(int N) {
		int minPermeter = 2 * (1 + N);
		int factor = 1;

		while (factor * factor < N) {
			if (N % factor == 0) {
				minPermeter = Math.min(minPermeter, 2 * (factor + N / factor));
			}
			factor++;
		}
		if (factor * factor == N)
			minPermeter = Math.min(minPermeter, 4 * factor);

		return minPermeter;
	}
}
