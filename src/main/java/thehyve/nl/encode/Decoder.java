package thehyve.nl.encode;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.List;

public class Decoder {

    /**
     * Gets array of bytes as its input
     * Decodes according to following algorithm:
     *   Consider two bytes:(f: first, s: second)
     *     if the f is equal to zero then add s to resultList
     *        else if the f is greater than zero then
     *                 go back to last f index and add s number of elements to resultList
     * sample input: 00 20 00 2A 02 01
     * sample output: 20 2A 20
     * @param bytes An array of encoded bytes
     * @return List of HexString each element represents one decoded byte
     */
    public List<String> decode(byte[] bytes) {
        List<String> decodedBytes = new ArrayList<>();
        for (int i = 0; i < bytes.length - 1; i+=2) {
            byte first = bytes[i];
            byte second = bytes[i+1];
            if (first == 0) {
                decodedBytes.add(DatatypeConverter.printHexBinary(new byte[]{second}));
            } else {
                if (first > 0) {
                    int start = decodedBytes.size() - first;
                    for (int j = start; j < start + second; j++) {
                        decodedBytes.add(decodedBytes.get(j));
                    }
                }
            }
        }
        return decodedBytes;
    }


    /**
     * Gets array of bytes as its input
     * Decodes according to following algorithm:
     *   Consider two bytes:(f: first, s: second)
     *     if the f is equal to zero then add s to resultList
     *        else if the f is greater than zero then
     *                 go back to last f index and add s number of elements to resultList
     * sample input: (0, 61)-(1, 1)-(0, 62)-(3,2)-(3,3)
     * sample output: 20 2A 20
     * @param inputString A formatted input String
     * @return List of decoded bytes
     */
    // TODO: 1/14/2021 this method accepts another format as its input can be used if needed
    public List<Byte> decode(String inputString) {
        List<Byte> decodedBytes = new ArrayList<>();
        String[] pairs = inputString.split("-");
        for (String pair : pairs) {
            String[] splitPair = pair.split(",");
            byte first = Byte.parseByte(splitPair[0]);
            byte second = Byte.parseByte(splitPair[1]);
            if (first == 0) {
                decodedBytes.add(second);
            } else {
                if (first > 0) {
                    int index = decodedBytes.size() - first;
                    for (int i = index; i < index + second; i++) {
                        decodedBytes.add(decodedBytes.get(i));
                    }
                }
            }
        }
        return decodedBytes;
    }
}
