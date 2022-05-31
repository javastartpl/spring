package pl.javastart.sessions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
class CounterController {
    private VisitCounter visitCounter;

    public CounterController(VisitCounter visitCounter) {
        this.visitCounter = visitCounter;
    }

    @GetMapping("/")
    String counter(HttpSession session) {
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
