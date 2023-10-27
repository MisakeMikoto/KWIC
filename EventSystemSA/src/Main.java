public class Main {
    public static void main(String[] args) {
        //创建主题
        KWICSubject kwicSubject = new KWICSubject();
        //创建观察者
        Input_ESSA inputESSA = new Input_ESSA("input.txt");
        Shift shift = new Shift(inputESSA.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "output3.txt");

        // 将观察者加入主题
        kwicSubject.addObserver(inputESSA);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        // 逐步调用各个观察者
        kwicSubject.startKWIC();
    }
}
