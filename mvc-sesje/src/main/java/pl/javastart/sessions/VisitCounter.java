package pl.javastart.sessions;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
class VisitCounter {
    private int counter;

    public int getCounter() {
        return counter;
    }

    void increment() {
        counter++;
    }
}
