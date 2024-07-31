class FinancialForecasting {

    public double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public double calculateFutureValueMemoized(double currentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != -1) {
            return memo[years];
        }
        memo[years] = calculateFutureValueMemoized(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }
}

public class FinancialForecastingDemo {
    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();
        double currentValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        double futureValue = forecasting.calculateFutureValue(currentValue, growthRate, years);
        System.out.println("Future Value (Recursive): " + futureValue);

        double[] memo = new double[years + 1];
        for (int i = 0; i <= years; i++) {
            memo[i] = -1;
        }
        double futureValueMemoized = forecasting.calculateFutureValueMemoized(currentValue, growthRate, years, memo);
        System.out.println("Future Value (Memoized): " + futureValueMemoized);
    }
}
