package interview;

import sun.management.resources.agent;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by nikhil on 3/3/18.
 */
public class Wissen {





        public static class StatisticsAggregatorImpl implements StatisticsAggregator {

            private static final Map<String,List<Double>> stockMap = new ConcurrentHashMap<String,List<Double>>();


            @Override
            public void putNewPrice(String symbol, double price) {
              synchronized (stockMap) {
                  List<Double> list = stockMap.get(symbol);
                  if (list == null) {

                      stockMap.put(symbol, new java.util.ArrayList<Double>());

                  }
                  stockMap.get(symbol).add(price);
              }
            }

            @Override
            public double getAveragePrice(String symbol) {
                List<Double> list =   stockMap.get(symbol);
                return   list.stream().mapToDouble(val -> val).average().getAsDouble();
            }

            @Override
            public int getTickCount(String symbol) {
                return  stockMap.get(symbol).size();
            }
        }

        ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

        public interface StatisticsAggregator {
            // This is an input. Make note of this price.
            public void putNewPrice(String symbol, double price);

            // Get the average price
            public double getAveragePrice(String symbol);

            // Get the total number of prices recorded
            public int getTickCount(String symbol);
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                final StatisticsAggregator stats = new StatisticsAggregatorImpl();
                final Set<String> symbols = new TreeSet<>();

                String line = scanner.nextLine();
                String[] inputs = line.split(",");
                int threads = Integer.parseInt(inputs[0]);
                ExecutorService pool = Executors.newFixedThreadPool(threads);
                for (int i = 1; i < inputs.length; ++i) {
                    String[] tokens = inputs[i].split(" ");
                    final String symbol = tokens[0];
                    symbols.add(symbol);
                    final double price = Double.parseDouble(tokens[1]);
                    pool.submit(new Runnable() {
                        @Override
                        public void run() {
                            stats.putNewPrice(symbol, price);
                        }
                    });

                }
                pool.shutdown();
                try {
                    pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (String symbol : symbols) {
                    System.out.println(String.format("%s %.4f %d", symbol,
                            stats.getAveragePrice(symbol),
                            stats.getTickCount(symbol)));
                }
            }
            scanner.close();

        }
    }

