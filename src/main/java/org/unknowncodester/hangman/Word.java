package org.unknowncodester.hangman;

public class Word {
    private String name;
    private String topic;

    public Word(String name, String topic) {
        setName(name);
        setTopic(topic);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    private void setTopic(String topic) {
        this.topic = topic;
    }
}
