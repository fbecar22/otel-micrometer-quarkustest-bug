package fr.fbecar22;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Startup
public class ItemsMetrics {
    private final MeterRegistry meterRegistry;

    public ItemsMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        registerMetrics();
    }

    public void registerMetrics() {
        Gauge.builder("count.items", this, ItemsMetrics::itemsCount)
                .register(meterRegistry);
    }

    public Long itemsCount() {
        return 42l;
    }

}
