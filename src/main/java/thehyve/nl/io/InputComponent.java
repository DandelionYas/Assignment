package thehyve.nl.io;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InputComponent {

    /**
     * Gets Binary data from Standard Input
     * Uses BufferedReader in order to being more efficient
     * @return An Array: each element represents one byte
     */
    public byte[] readFromStandardInputToByteArray() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return DatatypeConverter.parseHexBinary(bufferedReader.readLine());
    }
}
