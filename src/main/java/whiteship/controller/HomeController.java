package whiteship.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Keeun Baik
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Welome to the Adieu 2014";
    }

}
