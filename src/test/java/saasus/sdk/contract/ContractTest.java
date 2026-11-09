package saasus.sdk.contract;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * JUnit entry point for the contract test — the stable {@code mvn test} surface.
 *
 * <p>Each (operation, call form) is its own parameterized test, so failures are
 * counted and named individually in the surefire report. A module with no
 * configured Prism endpoint contributes no case, which is how one module runs
 * locally and all of them in CI. Synthetic data only; no response body, token
 * or PII is logged.
 */
public class ContractTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void contract(Case c) throws Throwable {
        c.op.invoke(c.form, c.baseUrl);
    }

    static List<Case> cases() {
        List<Case> cases = new ArrayList<Case>();
        for (String module : ContractEngine.MODULES) {
            String base = PrismEndpoints.urlForOrNull(module);
            if (base == null) {
                continue;
            }
            for (ContractEngine.OperationCase op : ContractEngine.discover(module)) {
                for (ContractEngine.Form form : ContractEngine.Form.values()) {
                    cases.add(new Case(op, form, base));
                }
            }
        }
        return cases;
    }

    /**
     * Every spec operation of a configured module must map to a generated SDK
     * method. Enforced only for the latest SDK (CONTRACT_REQUIRE_COMPLETE=true);
     * an older SDK (C) legitimately lacks newer operations, so there it is
     * reported as skipped rather than silently passing.
     */
    @Test
    void allOperationsEnumerated() {
        Assumptions.assumeTrue("true".equalsIgnoreCase(System.getenv("CONTRACT_REQUIRE_COMPLETE")),
                "CONTRACT_REQUIRE_COMPLETE is not set: completeness is only enforced for the latest SDK");
        List<String> missing = new ArrayList<String>();
        for (String module : ContractEngine.MODULES) {
            if (PrismEndpoints.urlForOrNull(module) == null) {
                continue;
            }
            for (String op : ContractEngine.unmappedOperations(module)) {
                missing.add(module + "." + op);
            }
        }
        Assertions.assertTrue(missing.isEmpty(),
                "spec operations not enumerated in SDK: " + missing);
    }

    /** One contract case: an operation exercised through one call form. */
    static final class Case {
        final ContractEngine.OperationCase op;
        final ContractEngine.Form form;
        final String baseUrl;

        Case(ContractEngine.OperationCase op, ContractEngine.Form form, String baseUrl) {
            this.op = op;
            this.form = form;
            this.baseUrl = baseUrl;
        }

        @Override
        public String toString() {
            return op.id() + " [" + form + "]";
        }
    }
}
