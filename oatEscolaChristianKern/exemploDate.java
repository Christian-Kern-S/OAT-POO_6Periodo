
import java.text.SimpleDateFormat;
import java.util.*;

public class exemploDate {

    public static void main(String[] args) {
        try (Scanner leitura = new Scanner(System.in)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataNascimento = leitura.next();
            Date dataNascimentoDate = null;

            dataNascimentoDate = sdf.parse(dataNascimento);
                System.out.println(dataNascimentoDate);
            } catch (Exception e) {
               System.out.println("Data invalida");
            }
        }
            
    }
