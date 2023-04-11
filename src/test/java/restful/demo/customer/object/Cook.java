package restful.demo.customer.object;

import java.util.Objects;

public class Cook {

    private final String name;
    private final int price;

    public Cook(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 메뉴 아이템을 가지고 요리를 만든다. 당연히 메뉴랑 요리는 같다
    public Cook(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
    }

    // 객체들끼리 비교할때는 equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return price == cook.price && Objects.equals(name, cook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
