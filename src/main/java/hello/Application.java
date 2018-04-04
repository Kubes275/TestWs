package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ws"})
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
        log.debug("HURA DEBUG FUNGUJE");
        if (args.length > 0) {
            log.debug(args[0]);
        }

    }
}
