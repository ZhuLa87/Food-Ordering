import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    // 測試 MenuItem 類別的創建
    @Test
    public void testMenuItemCreation() {
        MenuItem burger = new MenuItem("Burger", null, 10, "Main");
        assertEquals("Burger", burger.getName()); // 檢查名稱是否正確
        assertEquals(10, burger.getPrice()); // 檢查價格是否正確
        assertEquals("Main", burger.getType()); // 檢查類別是否正確
    }

    // 測試 Order 類別的功能
    @Test
    public void testOrderFunctionality() {
        MenuItem burger = new MenuItem("Burger", null, 10, "Main");
        MenuItem pizza = new MenuItem("Pizza", null, 15, "Main");

        Order order = new Order();
        order.addOrderingItem(burger, 2); // 添加兩個漢堡
        order.addOrderingItem(pizza, 3); // 添加三個披薩

        assertEquals(2, order.getOrderingItems().size()); // 檢查訂單項目數量是否正確
        assertEquals(2, order.getOrderingItems().get(0).getQuantity()); // 檢查第一個訂單項目的數量是否正確
        assertEquals(3, order.getOrderingItems().get(1).getQuantity()); // 檢查第二個訂單項目的數量是否正確

        order.updateStatus("Preparing"); // 更新訂單狀態為準備中
        assertEquals("Preparing", order.getStatus()); // 檢查訂單狀態是否正確

        order.removeOrderingItem(0); // 移除第一個訂單項目
        assertEquals(1, order.getOrderingItems().size()); // 檢查訂單項目數量是否正確
    }
}