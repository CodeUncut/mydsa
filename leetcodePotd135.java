import java.util.Arrays;

public class CandyDistribution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        if (size <= 1) {
            return size;
        }

        int[] num = new int[size];
        Arrays.fill(num, 1);

        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            }
        }

        for (int i = size - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                num[i - 1] = Math.max(num[i] + 1, num[i - 1]);
            }
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            result += num[i];
        }

        return result;
    }

    public static void main(String[] args) {
        CandyDistribution candyDistribution = new CandyDistribution();
        int[] ratings = {1, 0, 2};
        int candies = candyDistribution.candy(ratings);
        System.out.println("Minimum candies required: " + candies);
    }
}
