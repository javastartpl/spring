package pl.javastart.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

class Base64UrlExample {
    public static void main(String[] args) {
        String source = "Programista zapisał dziwny ciąg znaków: <>!=@#$";
        String base64 = encodeWithBase64(source);
        System.out.println(base64);
        String decodedText = decodeWithBase64(base64);
        System.out.println(decodedText);
    }

    static String encodeWithBase64(String source) {
        byte[] sourceBytes = source.getBytes(StandardCharsets.UTF_8);
        //url encoder
        byte[] base64Bytes = Base64.getUrlEncoder().encode(sourceBytes);
        String base64Text  = new String(base64Bytes);
        return base64Text;
    }

    static String decodeWithBase64(String base64) {
        byte[] base64Bytes = base64.getBytes(StandardCharsets.UTF_8);
        //url decoder
        byte[] originalBytes = Base64.getUrlDecoder().decode(base64Bytes);
        String decodedText = new String(originalBytes);
        return decodedText;
    }
}
