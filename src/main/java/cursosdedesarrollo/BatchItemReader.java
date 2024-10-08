package cursosdedesarrollo;

import jakarta.batch.api.chunk.AbstractItemReader;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;


@Named
public class BatchItemReader extends AbstractItemReader {

    // Definimos el atributo injectando el contexto
    @Inject private JobContext jobContext;

    private BufferedReader reader;


    @Override
    public void open(Serializable checkpoint) throws Exception {

        Properties jobParameters = jobContext.getProperties();

        String fileName = (String) jobParameters.get("input_file");

        System.out.println("Fichero a leer: " + fileName);

        reader = new BufferedReader(new FileReader(fileName));

        System.out.println("Fichero leido");
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
