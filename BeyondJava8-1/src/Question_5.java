public class Question_5 {
    public static void main(String[] args) {


        String toBeRepeated = "Hello";
        System.out.println(toBeRepeated.repeat(2));


        String string = "\n   Hello\u2005";
        System.out.println(string.strip());


        String string2 = "\n   Hello   ";
        System.out.println(string2.trim());


        String blankString = "  \n";
        System.out.println(blankString.isBlank());
        // will return true but .isEmpty() will return false


        System.out.println("Hello World".indent(5));
        String text = "Sanchit";
        String reverseText = text.transform(str-> new StringBuilder(str)
                .reverse().toString());
        System.out.println(reverseText);


        String string3 = """
                \tHello
                \t\t\tWorld
                \thow are you""";

        System.out.println(string3.stripIndent());


        String str = "Sanchit\\n Arora";

        System.out.println(str.translateEscapes());


        String multilineString = """
                line1
                     line2""";
        System.out.println(multilineString);


        System.out.println("Sanchit Age is :%d".formatted(21));

    }
}