package study.demo.ex_study.ledger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  클래스를 이용한 장부 프로그램 만들기
 *  장부 입력 / 출력 / 검색 / 삭제 / 종료
 */
public class Ledger {

    public Scanner sc;
    public int id =0;
    public RawInfo rawInfo;
    public ArrayList<RawInfo> totalInfo; // 제네릭타입 = 일반화

    // 생성자
    Ledger() {
        sc = new Scanner(System.in);
        totalInfo = new ArrayList<RawInfo>(); //객체 생성
    }

    public void run() {
        System.out.println("***장부 프로그램 실행***");

        while (true){ // roop

            printMenu();
            int menu = sc.nextInt();  // menu = sc입력
            if (menu ==0){
                System.out.println("프로그램 종료");
                break;
            }

            switch (menu) {
                case 1:
                    inputInfo();  //장부 정보 입력
                    break;
                case 2:
                    printInfo(); //장부 정보 출력
                    break;
                case 3:
                    search();  //장부 찾기
                    break;
                case 4:
                    delete();  // 장부 삭제
                    break;
                default:

                    System.out.println("잘못 입력하셨습니다");
                    break;
            }

        }
    }

    private void printInfo() {
        System.out.println("*******메뉴*******");
        System.out.println("1 : 전체출력");
        System.out.println("2 : 수입내역출력");
        System.out.println("3 : 지출내역출력");
        System.out.println("0 : 이전");
        System.out.println("*****************");
        System.out.print("선택:");
        int menu2 = sc.nextInt();

        switch (menu2) { // start switch menu2

            case 0:
                System.out.println("이젠 메뉴 이동");
                break;

            case 1:
                int sum = 0;
                int i = 0;
                if (0 == totalInfo.size()) {
                    System.out.println("입력된 내용 없음.");
                } else {
                    System.out.println("****전체 출력******");
                    for (i = 0; i < totalInfo.size(); i++) {
                        rawInfo = totalInfo.get(i); //total 자료중 0번째 부터 rawInfo 저장
                        int income = Integer.parseInt(rawInfo.getIncome());
                        int expense = Integer.parseInt(rawInfo.getExpense());
                        sum = sum + (income - expense);
                        System.out.println("ID: " + rawInfo.id);
                        System.out.println("날짜: " + rawInfo.date);
                        System.out.println("수입: " + income);
                        System.out.println("지출: " + -expense);
                        System.out.println("내역: " + rawInfo.history);
                        System.out.println("합계: " + sum);
                        System.out.println();
                    }
                    System.out.println("****************");
                }
                break;

            case 2:
                int totalIncome = 0;
                i = 0;
                if (0 == totalInfo.size()) {
                    System.out.println("수입 내역 없음.");
                } else {
                    System.out.println("****수입 내역******");
                    for (i = 0; i < totalInfo.size(); i++) {
                        rawInfo = totalInfo.get(i);
                        int income = Integer.parseInt(rawInfo.getIncome());
                        if (income > 0) { //수익은 무조건 0 보다 클경우만 출력
                            totalIncome = totalIncome + income;
                            System.out.println("ID: " + rawInfo.id);
                            System.out.println("날짜: " + rawInfo.date);
                            System.out.println("수입: " + income);
                            System.out.println("내역: " + rawInfo.history);
                            System.out.println("합계: " + totalIncome);
                            System.out.println();
                        }
                    }
                    System.out.println("****************");
                }

                break;

            case 3:
                int totalExpense = 0;
                i = 0;
                if (0 == totalInfo.size()) {
                    System.out.println("지출 내역 없음.");
                } else {
                    System.out.println("****지출 내역******");
                    for (i = 0; i < totalInfo.size(); i++) {
                        rawInfo = totalInfo.get(i);
                        int expense = Integer.parseInt(rawInfo.getExpense());
                        if (expense > 0) {
                            totalExpense = totalExpense + expense;
                            System.out.println("ID: " + rawInfo.id);
                            System.out.println("날짜: " + rawInfo.date);
                            System.out.println("지출: " + expense);
                            System.out.println("내역: " + rawInfo.history);
                            System.out.println("합계: " + totalExpense);
                            System.out.println();
                        }
                    }
                }
                System.out.println("****************");

                break;

            default:
                System.out.println("잘못 입력하셨습니다.");
                break;

        } // end switch menu2

    } // end printInfo
    private void inputInfo() {

        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DateTimeFormatter.ofPattern("mm-dd"));


        System.out.println("*******메뉴******");
        System.out.println("1: 수입 입력");
        System.out.println("2: 지출 출력");
        System.out.println("0: 이전 메뉴");
        System.out.println("**********************");
        System.out.println("선택 : ");

        int menu1 = sc.nextInt();

        switch (menu1) {

            case 0:
                System.out.println("이전 메뉴 이동");
                break;

            case 1:
                rawInfo = new RawInfo(id++);
                sc.nextLine(); //빈 공간 받아주기
                System.out.println("ID : " + (id -1)); // 원래 0이여서 -1을 통해 원래 값 print
                System.out.println("날짜 :" + date);
                rawInfo.setDate(date);

                System.out.println("수입:");
                rawInfo.setIncome(sc.nextLine());
                rawInfo.setExpense("0");  // 수입이기에 지출은 0

                System.out.println("내역:");
                rawInfo.setHistory(sc.nextLine());

                totalInfo.add(rawInfo);
                break;

            case 2:
                rawInfo = new RawInfo(id++);
                sc.nextLine(); //빈 공간 받아주기
                System.out.println("ID : " + (id -1)); // 원래 0이여서 -1을 통해 원래 값 print
                System.out.println("날짜 :" + date);
                rawInfo.setDate(date);

                System.out.println("지출:");
                rawInfo.setExpense(sc.nextLine());
                rawInfo.setIncome("0");  // 수입이기에 지출은 0

                System.out.println("내역:");
                rawInfo.setHistory(sc.nextLine());

                totalInfo.add(rawInfo);
                break;

            default:
                System.out.println("잘못 입력");
                break;
        }


    }
    private void printMenu() {
        System.out.println("*******메뉴******");
        System.out.println("1: 장부 입력");
        System.out.println("2: 장부 출력");
        System.out.println("3: 장부 검색");
        System.out.println("4: 장부 삭제");
        System.out.println("0: 종료");
        System.out.println("**********************");
        System.out.println("선택 : ");

    }
    private void search(){

        System.out.println("*******메뉴*******");
        System.out.println("1 : 날짜 검색");
        System.out.println("0 : 이전");
        System.out.println("****************");
        System.out.print("선택:");

        int menu3 = sc.nextInt();
        if (menu3 == 0) {
            System.out.println("이전 메뉴 이동");
            return;
        }
        sc.nextLine();
        if (menu3 == 1) {
            System.out.print("날짜 입력: ");
            String sdate = sc.nextLine(); // 사용자가 입력한 날짜
            int j = 0;
            if (0 == totalInfo.size()) {
                System.out.println("데이터가 없습니다.");
            } else {
                System.out.println("******검색 결과*******");
                for (j = 0; j < totalInfo.size(); j++) {
                    rawInfo = totalInfo.get(j);

                    if (sdate.equals(rawInfo.getDate())) { // 사용자가 입력한 날짜와 동일한지.
                        int income = Integer.parseInt(rawInfo.getIncome());
                        int expense = Integer.parseInt(rawInfo.getExpense());
                        int total = 0;
                        total = total + (income - expense);
                        System.out.println("ID: " + rawInfo.id);
                        System.out.println("날짜: " + rawInfo.date);
                        System.out.println("수입: " + income);
                        System.out.println("지출: " + -expense);
                        System.out.println("내역: " + rawInfo.history);
                        System.out.println("합계: " + total);
                        System.out.println();
                    }
                }
                System.out.println("*******************");
            }
        } else {
            System.out.println("잘못 입력하셨습니다.");
            return;
        }
    } //end search

    private void delete(){

        System.out.println("*******메뉴*******");
        System.out.println("1 : ID로 삭제");
        System.out.println("2 : 전체삭제");
        System.out.println("0 : 이전");
        System.out.println("****************");
        System.out.print("선택:");

        int menu4 = sc.nextInt();
        if (menu4 == 0) {
            System.out.println("이전 메뉴 이동");
            return;
        }
        sc.nextLine();
        if (menu4 == 1) {     // start if 1
            System.out.print("ID 입력: ");
            int id = sc.nextInt();

            int k = 0;
            if (k == totalInfo.size()) {
                System.out.println("데이터 없음.");
            }
            for (k = 0; k < totalInfo.size(); k++) {
                rawInfo = totalInfo.get(k);
                if (id == rawInfo.getId()) { // 입력한 id와 저장된 id가 같으면
                    totalInfo.remove(k); // 찾은 아이디를 메서드를 통해 삭제
                    System.out.println("*******************");
                    System.out.println("삭제된 데이터");
                    int income = Integer.parseInt(rawInfo.getIncome());
                    int expense = Integer.parseInt(rawInfo.getExpense());
                    int sum = 0;
                    sum = sum + (income - expense);
                    System.out.println("ID: " + rawInfo.id);
                    System.out.println("날짜: " + rawInfo.date);
                    System.out.println("수입: " + income);
                    System.out.println("지출: " + -expense);
                    System.out.println("내역: " + rawInfo.history);
                    System.out.println("합계: " + sum);
                    System.out.println("*******************");

                }
            }

            return;
        } // end if 1

        if (menu4 == 2) {
            totalInfo.clear();
            System.out.println("전체 삭제 완료.");
            return;
        } else {
            System.out.println("잘못된 입력 입니다.");
            return;
        }



    } // end delete


}









