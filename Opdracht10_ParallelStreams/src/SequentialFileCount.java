import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequentialFileCount {

    private long startTime;
    private long endTime;


    public String getProcessDuration ( ) {
        long duration = this.endTime -this.startTime;
        return "The sequential processing took: " + duration + " milliseconds";
    }

    public String RunSequentialFileCount ( String path) throws IOException {

        /// Set starttime
        this.startTime = System.currentTimeMillis ();

        StringBuilder sb = new StringBuilder (  );
        sb.append ( "EXT\t| CNT");
        sb.append ( "\n---\t| ---");

        // Get all the regular files in the folder
        Stream < Path > stream = Files.list ( Paths.get ( path ) );
        Map < String, Long > fileExtCountMap = stream.filter ( Files::isRegularFile )
                .map ( f -> f.getFileName ( ).toString ( ).toUpperCase ( ) )
                .map ( n -> n.substring ( n.lastIndexOf ( "." ) + 1 ) )
                .collect ( Collectors.groupingBy ( Function.identity ( ) , Collectors.counting ( ) ) );

        //sort and create output via stringbuilder
        fileExtCountMap.entrySet ().stream( )
                .sorted ( Comparator.comparing ( f -> f.getValue () ))
                .forEach ( i -> sb.append ("\n"+ i.getKey () + "\t| " + i.getValue () ));

        // Set timestamp of completion
        this.endTime = System.currentTimeMillis ();

        return sb.toString ();

    }
}
