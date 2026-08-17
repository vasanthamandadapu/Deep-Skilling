public class ForecastCalculator {

    public static int recursiveCalls = 0;

    public static double predictFutureValue(
            double currentValue,
            double growthRate,
            int years) {

        recursiveCalls++;

        // Base Case
        if (years == 0) {
            return currentValue;
        }

        // Recursive Case
        return predictFutureValue(
                currentValue * (1 + growthRate),
                growthRate,
                years - 1);
    }
}