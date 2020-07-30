package logarithm.controller;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource
@Component
public class Counter {

    @ManagedAttribute
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    private long count = 0L;

}
