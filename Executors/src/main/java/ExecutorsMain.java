import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorsMain {

    private static final String EURUSD = "EURUSD";
    private static final String USDJPY = "USDJPY";
    private static final String EURGBP = "EURGBP";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws InterruptedException {
        //getEurUsdRateByScheduledExecutor();
        getRatesByExecutorInvokeAll();
        Thread.sleep(100000000);
    }

    private static void getRatesByExecutorInvokeAll() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3, new MyThreadFactory());
        Callable<Double> cEurUsd = getCallable(EURUSD);
        Callable<Double> cUsdJpy = getCallable(USDJPY);
        Callable<Double> cEurGbp = getCallable(EURGBP);
        executor.invokeAll(List.of(cEurUsd, cEurGbp, cUsdJpy));
    }

    private static void getEurUsdRateByScheduledExecutor() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new MyDateTimeThreadFactory());
        Runnable r = getRunnable(EURUSD);
        executor.scheduleAtFixedRate(r, 5, 7, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String currencyPair) {
        return () -> {
            double rateEurUsd = getCurrentRate(currencyPair);
            System.out.println(Thread.currentThread().getName() + " - " + currencyPair + " : " + rateEurUsd);
        };
    }

    private static Callable<Double> getCallable(String currencyPair) {
        return () -> {
            double rateEurUsd = getCurrentRate(currencyPair);
            System.out.println(Thread.currentThread().getName() + " - " + currencyPair + " : " + rateEurUsd);
            return rateEurUsd;
        };
    }

    private static double getCurrentRate(String currencyPair) {
        double rate = 0d;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://www.freeforexapi.com/api/live?pairs=" + currencyPair))
                    .build();
            HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());
            rate = MAPPER.readTree(response.body()).get("rates").get(currencyPair).get("rate").asDouble();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return rate;
    }

    private static class MyDateTimeThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "ScheduledExecutor-" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }

    private static class MyThreadFactory implements ThreadFactory {

        private static final AtomicInteger i = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "MyThread-" + i.incrementAndGet());
        }
    }
}
