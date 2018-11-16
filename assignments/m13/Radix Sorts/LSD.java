/**
 * Class for lsd.
 */
class LSD {
	/**
	 * Constructs the object.
	 */
	protected LSD() {

	}
	/**
	 * private bits.
	 */
	private static final int BITS_PER_BYTE = 8;
	/**
	 * tfs.
	 */
	public static final int T_FS = 256;
	/**
	 * complexity O(2n(l+R))
	 */
	public static String[] sort(final String[] ar, final int n) {
		int len = ar.length;
		int r = T_FS; // extend ASCII alphabet size
		String[] aux = new String[len];
		for (int i = n - 1; i >= 0; i--) {
			int[] count = new int[r + 1];

			for (int j = 0; j < len; j++) {
				count[ar[j].charAt(i) + 1]++;
			}

			for (int k = 0; k < r; k++) {
				count[k + 1] += count[k];
			}

			for (int m = 0; m < len; m++) {
				aux[count[ar[i].charAt(i)]++] = ar[i];
			}
			for (int x = 0; x < len; x++) {
				ar[x] = aux[x];
			}
		}
		return ar;
	}


}