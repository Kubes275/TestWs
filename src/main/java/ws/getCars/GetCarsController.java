package ws.getCars;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCarsController {

    private Logger log = LoggerFactory.getLogger(GetCarsController.class);

    @RequestMapping(value = "/car")
    public ResponseEntity<Car> getCar() {

        Car car = new Car();
        car.setColor("blue");
        car.setVIN("12434");
        car.setMiles(100);

        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/getCar", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Car> update(@RequestBody Car car) {

        log.debug("TEST LOG DEBUG");

        if (car != null) {
            car.setMiles(car.getMiles() + 10);
        }

        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }


}
