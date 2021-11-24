package pl.javastart.prg;

import java.time.LocalDateTime;

class Note {
    private String id;
    private String text;
    private LocalDateTime timeAdded;

    public Note(String id, String text) {
        this.id = id;
        this.text = text;
        timeAdded = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalDateTime timeAdded) {
        this.timeAdded = timeAdded;
    }
}
