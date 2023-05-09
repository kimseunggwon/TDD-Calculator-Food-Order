package study.demo.ex_study.parsing;

import java.util.ArrayList;

public class Parser {

    final static String[] commands = { "GET", "POST" };

    String rawString;
    String[] lines;
    ArrayList<Command> cmds = new ArrayList<Command>();
    ArrayList<Datum> data = new ArrayList<Datum>();

    // 생성자
    Parser(String str) {
        rawString = str;
    }

    public String[] parsingLine() {
        lines = rawString.split("\r\n"); //라인을 6개로 나누어서 출력
        int i = 0;
        for (String line : lines) {

            System.out.println("[" + (i++) + "]" + line);
        }
        return lines;

    }

    public void ParseCommand() {

        for (String line : lines) {

            for (String command : commands) {
                if (line.contains(command)) {
                    Command cmd = new Command(command);
                    String content = getCommandContent(line);
                    cmd.setContent(content);
                    cmds.add(cmd);
                }

            }

        }

    }

    public void printCommand() {
        for (int i = 0; i < cmds.size(); i++) {
            System.out.println("cmd : " + cmds.get(i).command);
            System.out.println("content : " + cmds.get(i).content);
        }

    }

    private String getCommandContent(String line) {
        String[] contents = line.split(" / ");
        return contents[1];
    }

    public void run() {
        System.out.println("==================");
        parsingLine();
        System.out.println("==================");
        ParseCommand();
        printCommand();
        System.out.println("==================");
        parseData();
        printData();

    }

    public void printData() {
        for (int i = 0; i < data.size(); i++) {
            System.out.println("tilte : " + data.get(i).getTitle());

            int j = 0;
            for(String content : data.get(i).contents) {
                System.out.println("content[" + (j++) + "] :" + content);
            }
        }


    }

    private void parseData() {
        for (String line : lines) {

            boolean isCmd = false;

            for (String command : commands) {
                if (line.contains(command)) {
                    isCmd = true;

                }
            }

            if(!isCmd) {
                Datum datum = new Datum();
                getDatumTitleAndContent(line,datum);
                data.add(datum);

            }


        }

    }

    private void getDatumTitleAndContent(String line, Datum datum) {
        String[] content = line.split(": ");
        datum.setTitle(content[0]);
        datum.setContents(content[1].split(";"));
    }

    class Datum{
        String title;
        String [] contents;

        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String[] getContents() {
            return contents;
        }
        public void setContents(String[] contents) {
            this.contents = contents;
        }




    }
    class Command {

        String command;
        String content;

        Command(String cmd) {
            command = cmd;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCommand() {
            return command;
        }

    }
}
