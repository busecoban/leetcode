import java.util.Arrays;

public class FindArrGivenSubsetSums_1982 {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int m = sums.length, zeroShift = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int diff = sums[1] - sums[0], hasZero = 0, p = 0, k = 0, zpos = m;
            for (int j = 0; j < m; ++j) {
                if (k < p && sums[k] == sums[j]) k++;
                else {
                    if (zeroShift == sums[j]) zpos = p;
                    sums[p++] = sums[j] + diff;
                }
            }
            if (zpos >= m / 2) {
                res[i] = -diff;
            } else {
                res[i] = diff;
                zeroShift += diff;
            }
            m /= 2;
        }
        return res;
    }
    public static void main(String[] args) {
        FindArrGivenSubsetSums_1982 obj = new FindArrGivenSubsetSums_1982();
        int n = 4;
        int[] sums = {0, 0, 0, 0};
        System.out.println("Recovered array: " + Arrays.toString(obj.recoverArray(n, sums)));
    }

   
}
