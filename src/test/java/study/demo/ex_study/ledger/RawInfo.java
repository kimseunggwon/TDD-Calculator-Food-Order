package study.demo.ex_study.ledger;

public class RawInfo {

    public int id;
    public String date;
    public String income;
    public String expense;
    public String history;

    public RawInfo(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getIncome() {
        return income;
    }

    public String getExpense() {
        return expense;
    }

    public String getHistory() {
        return history;
    }
}
