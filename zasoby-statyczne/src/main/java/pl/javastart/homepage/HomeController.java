package pl.javastart.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
class HomeController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return """
                <html>
                <head>...</head>
                <body>
                    ...
                </body>
                </html>
                """;
    }
}
