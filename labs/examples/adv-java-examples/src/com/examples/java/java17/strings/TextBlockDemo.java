package com.examples.java.java17.strings;

public class TextBlockDemo {

    public static void main(String[] args) {
        String stringJSON = "{\r\n"
                + "\"Name\" : \"Ajay\",\r\n"
                + "\"EmpId\" : \"1234\"\r\n"
                + "}";

        System.out.println(stringJSON);

        String textBlockJSON = """
         {
            "name" : "Ajay",
            "empId" : "1234"
         }
         """;
        System.out.println(textBlockJSON);

        System.out.println("Contains: " + textBlockJSON.contains("Ajay"));
        System.out.println("indexOf: " + textBlockJSON.indexOf("Ajay"));
        System.out.println("Length: " + textBlockJSON.length());
    }
}
