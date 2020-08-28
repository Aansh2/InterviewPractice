package interview.calsoft;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerFileData {
    private static final  Map<String, List<byte[]>> map = new ConcurrentHashMap<>();
    private static final  Map<String, AtomicInteger> atomicInteger = new ConcurrentHashMap<>();

    public static synchronized Map<String, List<byte[]>> getMap() {
        return map;
    }
    synchronized
    public static  Map<String, AtomicInteger> getAtomicInteger() {
        return atomicInteger;
    }
}
