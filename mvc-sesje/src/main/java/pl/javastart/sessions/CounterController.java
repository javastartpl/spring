package pl.javastart.sessions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class CounterController {
    private final VisitCounter visitCounter;

    public CounterController(VisitCounter visitCounter) {
        this.visitCounter = visitCounter;
    }

    @GetMapping("/")
    String counter() {
        visitCounter.increment();
        return "index";
    }

}

//@Controller
//class CounterController {
//    private static final String COUNTER_NAME = "counter";
//
//    @GetMapping("/")
//    String counter(HttpSession session) {
//        Integer counter = (Integer) session.getAttribute(COUNTER_NAME);
//        if (counter != null) {
//            counter++;
//        } else {
//            counter = 1;
//        }
//        session.setAttribute(COUNTER_NAME, counter);
//        return "index";
//    }
//
//}
