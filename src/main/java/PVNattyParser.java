import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PVNattyParser
{

  public static void main(String[] args)
  {
    if (args.length < 1)
    {
      System.out.println("Usage:\n\n   java -jar sample-jstl-4.0.2-SNAPSHOT.jar <date string>\n\n"
          + "Note: if <date string> is a dash (-), the addresses will be read from stdin until an EOF");
      System.exit(0);
    }

    StringBuffer sb = new StringBuffer();
    Parser parser = new Parser();

    if ("-".equals(args[0]))
    {

      Scanner input = new Scanner(System.in);
      System.out.println("Please enter  a date:");
      System.out.flush();

      while (input.hasNextLine())
      {

        sb.setLength(0);
        String dateStr = input.nextLine();

        System.out.println(dateStr);

        parseDate(parser,dateStr, sb);

        System.out.println(sb.toString());

        System.out.println("\nPlease enter  a date:");
        System.out.flush();

      }

    }
    else
    {
      sb.setLength(0);

      parseDate(parser,args[0], sb);

      System.out.println(sb.toString());

    }

  }

  public static void parseDate(Parser parser, String date, StringBuffer sb)
  {
    //    Options opts = new Options(Pointer.PointerType.NONE);
    List<DateGroup> dateGroup = parser.parse(date);
    List<Date> dates = dateGroup.isEmpty() ? new ArrayList<Date>() : dateGroup.get(0).getDates();

    for (int i = 0, ilen = dates.size(); i < ilen; i++)
    {
      String label = dates.get(i).toString();
      sb.append("\n").append(label);

    }

  }
}
