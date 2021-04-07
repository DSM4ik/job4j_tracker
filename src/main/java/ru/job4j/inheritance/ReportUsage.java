package ru.job4j.inheritance;
/**
 * переопределение методов
*/
public class ReportUsage {
    public static void main(String[] args) {
        TextReport textReport = new TextReport();
        String text = textReport.generate("Report's name", "Report's body");
        System.out.println(text);

        System.out.println(System.lineSeparator());

        HtmlReport htmlReport = new HtmlReport();
        String text2 = htmlReport.generate("Report's name", "Report's body");
        System.out.println(text2);

        System.out.println(System.lineSeparator());

        JSONReport jsonReport = new JSONReport();
        String text3 = jsonReport.generate("Report's name", "Report's body");

        System.out.println(text3);
    }
}
