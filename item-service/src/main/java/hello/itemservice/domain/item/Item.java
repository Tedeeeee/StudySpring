package hello.itemservice.domain.item;

import lombok.Data;

// 메인 데이터를 다루는 곳에서 Data 어노테이션은 굉장히 위험하다.
//@Getter @Setter
@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
