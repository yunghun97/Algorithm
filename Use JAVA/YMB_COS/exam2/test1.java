package YMB_COS.exam2;

class Main {
    interface Book {
        public int getRentalPrice(int day);
    }

    class ComicBook implements Book { // 바꾼 부분
        public int getRentalPrice(int day) {
            int cost = 500;
            day -= 2;
            if (day > 0)
                cost += day * 200; // 바꾼 부분
            return cost;
        }
    }

    class Novel implements Book { // 바꾼 부분
        public int getRentalPrice(int day) {
            int cost = 1000;
            day -= 3;
            if (day > 0)
                cost += day * 300; // 바꾼 부분
            return cost;
        }
    }

    public int solution(String[] bookTypes, int day) {
        Book[] books = new Book[50];
        int length = bookTypes.length;
        for (int i = 0; i < length; ++i) {
            if (bookTypes[i].equals("comic"))
                books[i] = new ComicBook();
            else if (bookTypes[i].equals("novel"))
                books[i] = new Novel();
        }
        int totalPrice = 0;
        for (int i = 0; i < length; ++i)
            totalPrice += books[i].getRentalPrice(day);
        return totalPrice;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String[] bookTypes = { "comic", "comic", "novel" };
        int day = 4;
        int ret = sol.solution(bookTypes, day);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
// https://edu.goorm.io/learn/lecture/17301/cos-pro-1%EA%B8%89-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-java/lesson/839405/2%EC%B0%A8-%EB%AC%B8%EC%A0%9C1-%EB%8F%84%EC%84%9C-%EB%8C%80%EC%97%AC%EC%A0%90-%EC%9A%B4%EC%98%81-java