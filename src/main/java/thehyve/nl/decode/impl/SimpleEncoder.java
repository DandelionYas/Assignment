package thehyve.nl.decode.impl;

import thehyve.nl.decode.Encoder;

import java.util.ArrayList;
import java.util.List;

public class SimpleEncoder implements Encoder {

    /**
     * Gets array of HexStrings as its input
     * Encodes according to following algorithm:
     *   For each element e in the input:
     *      Add element 00 to the resultList then add e to the resultList
     * sample input: 20 2A 20
     * sample output: 00 20 00 2A 02 01
     * @param plainHexStrings An array of plain Hex Strings
     * @return List of HexString each element represents one encoded byte
     */
    public List<String> encode(List<String> plainHexStrings) {
        List<String> encoded = new ArrayList<>();
        plainHexStrings.forEach(hexString -> {
            encoded.add("00");
            encoded.add(hexString);
        });
        return encoded;
    }


}
