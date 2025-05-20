# otel-micrometer-itests-bug

This project reproduce a bug found in the quarkus-micrometer-opentelemetry extension.

To reproduce the issue, run multiple the following command:

```bash
mvn test
```

You will see that the test randomly success or fails.

When failing, the meterRegistry always returns "NaN" when asking the value of any gauge metric.