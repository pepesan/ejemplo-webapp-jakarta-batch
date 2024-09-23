package cursosdedesarrollo;

import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.inject.Named;
import jakarta.json.JsonObject;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;


@Named
public class FirstItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List list) {

        String resourceName = "/tmp/output.json";

        try(PrintWriter pw =new PrintWriter(new FileWriter(resourceName,true))){

            for (Object json: list) {
                System.out.println("Writer "+((JsonObject)json).toString());
                pw.write(((JsonObject)json).toString());
            }
            pw.flush();
            System.out.println("fichero escrito");

        }catch (Exception e){
            System.err.println("Error: " + e);
        }
    }
}
