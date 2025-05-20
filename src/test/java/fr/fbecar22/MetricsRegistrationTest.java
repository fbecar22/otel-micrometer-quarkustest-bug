package fr.fbecar22;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
class MetricsRegistrationTest {

    @Inject
    ItemsMetrics itemsMetrics;

    MeterRegistry registry = Metrics.globalRegistry;


    @BeforeEach
    void setUp() {
        registry.clear();
    }

    @Test
    void test() throws InterruptedException {
        itemsMetrics.registerMetrics();
        Thread.sleep(2000);

        Assertions.assertEquals(42l,registry.get("count.items").gauge().value());
    }

}