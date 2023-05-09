package study.demo.gradeCalculate;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;
    //private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    /**
     * 핵심
     */
    // 이수한 과목을 전달하여 평균학점 계산 요청 -----> 학점 계산기 -----> (학점수×교과목 평점)의 합계   ----> 과목(코스) 일급 컬렉션
    //                                                -----> 수강신청 총학점 수          ----> 과목(코스) 일급 컬렉션
    public double calculateGrade() {

        // (학점수×교과목 평점)의 합계
        double multipliedCreditAndCourseGrade = courses.multipliedCreditAndCourseGrade();

        // 수강신청 총학점 수
        int calculateTotalCompletedCredit = courses.calculateTotalCompletedCredit();


        return multipliedCreditAndCourseGrade / calculateTotalCompletedCredit;
    }

}
