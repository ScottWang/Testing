package test.soundex;

import org.apache.commons.codec.StringEncoderComparator;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.Soundex;

public class TestSoundex {
   
   public static void main(String[] args) {
      Soundex sd = new Soundex();
      
      String testString = sd.encode("GOOOOOOOOOOOOD");
      String testString1 = sd.encode("Good");
      
      String testString2 = sd.encode("porn");
      String testString3 = sd.encode("P0rn");
      String testString4 = sd.encode("P O_R+N");
      
      String testString5 = sd.encode("sex");
      String testString6 = sd.encode("sssexiii");
      String testString7 = sd.encode("sexiiiii");
      
      String testString8 = sd.encode("xphoto");
      String testString9 = sd.encode("photo");
      String testString10 = sd.encode("fuckphoto");
      String testString11 = sd.encode("fuck");
      String testString12 = sd.encode("fucked");
      
      System.out.println("The soundex return string is: "+testString+" original: "+testString1);
      
      System.out.println("The soundex return string is: "+testString2+" test1: "+testString3+ " test2: "+testString4);
      
      System.out.println("The soundex return string is 5: "+testString5+" test6: "+testString6+ " test7: "+testString7);
      
      System.out.println("The soundex return string is 8: "+testString8+" test9: "+testString9+ " test10: "+testString10);
      
      System.out.println("The soundex return string is 11: "+testString11);
      
      System.out.println("The soundex return string is 12: "+testString12);
      
      StringEncoderComparator comparator = new StringEncoderComparator(sd);
      System.out.println("Using string comparator: "+comparator.compare("fuck", "fucked"));
      System.out.println("Using string comparator ff: "+comparator.compare("fuckd", "fucked"));
      
      DoubleMetaphone dm = new DoubleMetaphone();
      StringEncoderComparator comparatorDM = new StringEncoderComparator(dm);
      
      System.out.println("Using string comparator: "+comparatorDM.compare("fuck", "fucked"));
      System.out.println("Using string comparator1: "+dm.isDoubleMetaphoneEqual("fuck", "fucked"));
      System.out.println("Using string comparator2: "+dm.isDoubleMetaphoneEqual("fuck", "fucked",true));
      
      Soundex sndx = new Soundex();
      DoubleMetaphone doubleMetaphone = new DoubleMetaphone();

      System.err.println("Soundex Code for Wilson is: " + sndx.encode("Wilson"));
      System.err.println("Soundex Code for Wylson is: " + sndx.encode("Wylson"));

      // Use the StringEncoderComparator to compare these two Strings
      StringEncoderComparator comparator1 = new StringEncoderComparator(sndx);
      System.err.println("Are Wilson and Wylson same based on Soundex? "
        + comparator1.compare("Wilson", "Wylson"));

      System.err.println("Are Auto and Otto same based on Soundex? "
        + comparator1.compare("Auto", "Otto"));

      StringEncoderComparator comparator2 =
        new StringEncoderComparator(doubleMetaphone);

      System.err.println("Are Auto and Otto same based on DoubleMetaphone? "
        + comparator2.compare("Auto", "Otto"));

      System.err.println("Double Metaphone primary code for Schmidt: " +
        doubleMetaphone.doubleMetaphone("Schmidt"));

      System.err.println("Double Metaphone secondary code for Schmidt: " +
        doubleMetaphone.doubleMetaphone("Schmidt", true));
   }
}
