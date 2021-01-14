package thehyve.nl.decode;

import java.util.List;


/**
 * An Interface for implementing various types of encode algorithms
 * */
public interface Encoder {
    List<String> encode(List<String> plainHexStrings);
}
