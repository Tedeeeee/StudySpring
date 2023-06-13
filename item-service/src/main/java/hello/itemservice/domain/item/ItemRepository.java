package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {

    // HashMap 은 실제 업무에서는 사용하지 않는것이 좋다.
    // static 으로 싱글톤으로 생성되며 동시성때문에 사용하면 안된다.
    private static final Map<Long, Item> store = new HashMap<>(); // static 사용

    // 같은 이유로 long 도 위험하다.
    private static long sequence = 0L;  // static 사용

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }


    // 실제 업무에서는 현재 사용하는 데이터 3개를 가지고 DTO 를 만들어서 객체형태로 사용하는것이 바람직하다.
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
