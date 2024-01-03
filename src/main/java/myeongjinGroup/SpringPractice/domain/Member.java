package myeongjinGroup.SpringPractice.domain;

public class Member {

    private Long id;      //key
    private String name;  // value

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
