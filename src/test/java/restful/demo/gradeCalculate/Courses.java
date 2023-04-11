package restful.demo.gradeCalculate;

import java.util.List;

public class Courses { // -> 여러개 list<Course>정보를 가진 클래스
    private final List<Course> courses;  //일급 컬렉션은 : list형태로 된 Course를 여러개 가진 Course정보만 인스턴스 변수로가진 클래스이다

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multipliedCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble((Course::multiplyCreditAndCourseGrade))
                //.mapToDouble(courses->courses.multiplyCreditAndCourseGrade())
                .sum();

        // 해당 코드를 위에처럼 간단하게 표현
       /* double multipliedCreditAndCourseGrade = 0;
        for (Course course : courses){
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        return multipliedCreditAndCourseGrade;*/
    }

    // 총 학점수만 수정 사항이 발생했을때, 해당 메서드만 수정을 하면 된다.
    public int calculateTotalCompletedCredit() {
         return courses.stream()
                 .mapToInt(Course::getCredit)
                //.mapToInt(courses->courses.getCredit())
                .sum();
    }
}
