package logarithm.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Component
@Endpoint(id="started")
public class Readiness {

        @ReadOperation
        public String readiness() throws Exception {
            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            if ( 60 * 1000 > runtimeMXBean.getUptime() ) {
                    throw new Exception("Starting...");
            }
            return "Ok";
        }

    }

