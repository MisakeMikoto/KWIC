public class OOSA {
    public static void execute(String inputFile, String outputFile) {
        Input input = new Input();
        input.input(inputFile);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output(outputFile);

    }
}
