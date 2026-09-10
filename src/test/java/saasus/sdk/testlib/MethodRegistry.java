package saasus.sdk.testlib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Registry mapping base method names to their {@link MethodInvokers}.
 *
 * <p>The set of registered {@code (method, callStyle)} pairs also defines the universe of
 * methods tracked for coverage.
 */
public class MethodRegistry {

    private final Map<String, MethodInvokers> invokers = new LinkedHashMap<String, MethodInvokers>();

    public MethodRegistry register(String methodName, MethodInvokers methodInvokers) {
        if (methodName == null || methodName.isEmpty()) {
            throw new IllegalArgumentException("methodName must not be empty");
        }
        if (methodInvokers == null) {
            throw new IllegalArgumentException("methodInvokers must not be null");
        }
        invokers.put(methodName, methodInvokers);
        return this;
    }

    public MethodInvokers get(String methodName) {
        return invokers.get(methodName);
    }

    public boolean contains(String methodName) {
        return invokers.containsKey(methodName);
    }

    public List<String> methodNames() {
        return new ArrayList<String>(invokers.keySet());
    }

    public boolean isEmpty() {
        return invokers.isEmpty();
    }

    /**
     * All registered {@code (method, style)} coverage keys, e.g. {@code getStripeInfo:NORMAL}.
     * Used to seed the {@link CoverageTracker}.
     */
    public List<String> coverageKeys() {
        List<String> keys = new ArrayList<String>();
        for (Map.Entry<String, MethodInvokers> entry : invokers.entrySet()) {
            for (CallStyle style : entry.getValue().supportedStyles()) {
                keys.add(style.coverageKey(entry.getKey()));
            }
        }
        return Collections.unmodifiableList(keys);
    }
}
