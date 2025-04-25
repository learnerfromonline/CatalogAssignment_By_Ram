import com.google.gson.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] files = {"input1.json", "input2.json"};

        for (String file : files) {
            JsonObject root = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();
            JsonObject keys = root.getAsJsonObject("keys");

            int k = keys.get("k").getAsInt();

            List<BigInteger> xList = new ArrayList<>();
            List<BigInteger> yList = new ArrayList<>();

            for (Map.Entry<String, JsonElement> entry : root.entrySet()) {
                if (entry.getKey().equals("keys")) continue;
                int x = Integer.parseInt(entry.getKey());

                JsonObject point = entry.getValue().getAsJsonObject();
                int base = point.get("base").getAsInt();
                String value = point.get("value").getAsString();

                BigInteger y = new BigInteger(value, base);

                xList.add(BigInteger.valueOf(x));
                yList.add(y);

                if (xList.size() == k) break;
            }

            BigInteger secret = lagrangeInterpolation(BigInteger.ZERO, xList, yList);
            System.out.println("Secret for " + file + " is: " + secret);
        }
    }

    public static BigInteger lagrangeInterpolation(BigInteger x, List<BigInteger> xs, List<BigInteger> ys) {
        BigInteger result = BigInteger.ZERO;
        int k = xs.size();

        for (int i = 0; i < k; i++) {
            BigInteger term = ys.get(i);
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    BigInteger numerator = x.subtract(xs.get(j));
                    BigInteger denominator = xs.get(i).subtract(xs.get(j));
                    term = term.multiply(numerator).divide(denominator);
                }
            }
            result = result.add(term);
        }

        return result;
    }
}
