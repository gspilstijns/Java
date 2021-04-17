import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTypeCounter {

    public static void main ( String[] args ) {

        ///Ask and read the filepath from user
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        System.out.println("Enter a directory path:");
        String directoryPath = null;
        try {
            directoryPath = reader.readLine ();
        } catch (IOException e) {
            e.printStackTrace ( );
        }
        File file = new File(directoryPath);

        /// Test if filepath is valid
        if (file.isDirectory()) {

            SequentialFileCount sequentialFileCount = new SequentialFileCount ();
            ParallelFileCount parallelFileCount = new ParallelFileCount ();

            try {
                /// Sequential processing
                System.out.println ("\nSEQUENTIAL PROCESSING" );
                System.out.println ("---------------------" );
                System.out.println (sequentialFileCount.RunSequentialFileCount (file.getPath ())) ;
                System.out.println (sequentialFileCount.getProcessDuration () );
                /// Parallel processing
                System.out.println ("\nPARALLEL PROCESSING" );
                System.out.println ("--------------------" );
                System.out.println (parallelFileCount.RunParallelFileCount (file.getPath ()) );
                System.out.println (parallelFileCount.getProcessDuration () );
            }
            catch (IOException e) {
                e.printStackTrace ( );
            }
        }
        else {
            System.out.println("Directory doesn't exist!!");
        }

    }

}
