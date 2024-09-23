package cursosdedesarrollo;

import jakarta.batch.api.chunk.AbstractItemReader;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;


@Named
public class FirstItemReader extends AbstractItemReader {

    private BufferedReader reader;

    @Override
    public void open(Serializable checkpoint) throws Exception {

        String fileName = "/tmp/input.csv";

        reader = new BufferedReader(new FileReader(fileName));

        System.out.println("fichero leido");
    }

    @Override
    public String readItem() {
        try {
            String line = reader.readLine();
            return line;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
