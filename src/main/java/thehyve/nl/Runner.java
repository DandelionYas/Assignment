package thehyve.nl;

import thehyve.nl.decode.Encoder;
import thehyve.nl.decode.impl.SimpleEncoder;
import thehyve.nl.encode.Decoder;
import thehyve.nl.io.InputComponent;

import java.io.IOException;
import java.util.List;

/**
 * The main runner for executing the algorithm
 * - Uses inputCompnent for getting encoded data from standard input: example: 0020002A0201
 * - Decodes data using Decoder object
 * - Prints decoded data in the Standard output stream
 * - Encodes data using SimpleEncoder
 * - Prints encoded data in the Standard error stream
 * */
public class Runner {
    public static void main(String[] args) throws IOException {
        InputComponent inputComponent = new InputComponent();
        Decoder decoder = new Decoder();
        Encoder simpleEncoder = new SimpleEncoder();
        System.out.println("Please enter input string with no extra character(e.g. 0020002A0201):");
        byte[] bytes = inputComponent.readFromStandardInputToByteArray();
        List<String> decode = decoder.decode(bytes);
        System.out.println(decode);
        List<String> encode = simpleEncoder.encode(decode);
        System.err.println(encode);
    }
}
