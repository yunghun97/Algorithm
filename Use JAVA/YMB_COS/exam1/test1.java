package YMB_COS.exam1;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    interface DeliveryStore {
        public void setOrderList(String[] orderList);

        public int getTotalPrice();
    }

    class Food {
        public String name;
        public int price;

        public Food(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    class PizzaStore implements DeliveryStore {
        private ArrayList<Food> menuList;
        private ArrayList<String> orderList;

        public PizzaStore() {
            menuList = new ArrayList<Food>();
            String[] menuNames = { "Cheese", "Potato", "Shrimp", "Pineapple", "Meatball" };
            int[] menuPrices = { 11100, 12600, 13300, 21000, 19500 };
            for (int i = 0; i < 5; i++)
                menuList.add(new Food(menuNames[i], menuPrices[i]));

            orderList = new ArrayList<String>();
        }

        public void setOrderList(String[] orderList) {
            for (int i = 0; i < orderList.length; i++)
                this.orderList.add(orderList[i]);
        }

        public int getTotalPrice() {
            int totalPrice = 0;
            Iterator<String> iter = orderList.iterator();
            while (iter.hasNext()) {
                String order = iter.next();
                for (int i = 0; i < menuList.size(); i++)
                    if (order.equals(menuList.get(i).name))
                        totalPrice += menuList.get(i).price;
            }
            return totalPrice;
        }
    }

    public int solution(String[] orderList) {
        DeliveryStore deliveryStore = new PizzaStore();

        deliveryStore.setOrderList(orderList);
        int totalPrice = deliveryStore.getTotalPrice();

        return totalPrice;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String[] orderList = { "Cheese", "Pineapple", "Meatball" };
        int ret = sol.solution(orderList);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
// https://edu.goorm.io/learn/lecture/17301/cos-pro-1%EA%B8%89-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-java/lesson/839395/1%EC%B0%A8-%EB%AC%B8%EC%A0%9C1-%EC%9D%8C%EC%8B%9D%EC%A0%84%EB%AC%B8%EC%A0%90-%EC%9A%B4%EC%98%81-java