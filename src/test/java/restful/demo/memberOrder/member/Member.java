package restful.demo.memberOrder.member;

/**
 *  초기 원시 개발로 어노테이션 없이 개발
 *  회원 엔티티
 */
public class Member {

    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade gradle) {
        this.id = id;
        this.name = name;
        this.grade = gradle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGradle(Grade gradle) {
        this.grade = gradle;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Grade getGradle() {
        return grade;
    }
}
