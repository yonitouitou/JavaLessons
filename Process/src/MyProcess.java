import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyProcess {

    public static void main(String[] args) throws IOException, InterruptedException {

        ProcessBuilder builder = new ProcessBuilder("notepad.exe");
        Process process = builder.start();
        process.waitFor(10, TimeUnit.SECONDS);
        process.destroy(); //process.destroyForcibly();
        printProcessDetails(process);
    }

    private static void printProcessDetails(Process process) {
        StringBuilder sb = new StringBuilder("Process Details :").append(System.lineSeparator())
                .append("Process ID : ").append(process.pid()).append(System.lineSeparator())
                .append("Is Alive : ").append(process.isAlive()).append(System.lineSeparator())
                .append("Exit Value : ").append(process.exitValue()).append(System.lineSeparator())
                .append("User : ").append(process.info().user()).append(System.lineSeparator())
                .append("Other Infos : ").append(process.info()).append(System.lineSeparator());
        System.out.println(sb.toString());
    }
}
