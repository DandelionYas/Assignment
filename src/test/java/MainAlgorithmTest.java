import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import thehyve.nl.decode.impl.SimpleEncoder;
import thehyve.nl.encode.Decoder;

import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.List;

public class MainAlgorithmTest {

    @Test
    public void testDecodeMethodForSampleInput() {
        byte[] input = DatatypeConverter.parseHexBinary("0020002A0201");
        List<String> decode = new Decoder().decode(input);
        Assert.assertThat(decode, Matchers.equalTo(Arrays.asList("20","2A", "20")));
    }

    @Test
    public void testSimpleEncodeMethod() {
        List<String> input = Arrays.asList("20","2A", "20");
        List<String> encode = new SimpleEncoder().encode(input);
        Assert.assertThat(encode, Matchers.equalTo(Arrays.asList("00", "20", "00", "2A", "00", "20")));
    }

    @Test
    public void testDecodeMethodGettingStringAsItsSampleInput() {
        String inputString = "0,61-1,1-0,62-3,2-3,3";
        List<Byte> decode = new Decoder().decode(inputString);
        Assert.assertThat(decode, Matchers.equalTo(Arrays.asList(new Byte("61"), new Byte("61"), new Byte("62"),
                new Byte("61"), new Byte("61"), new Byte("62"), new Byte("61"), new Byte("61"))));
    }
}
